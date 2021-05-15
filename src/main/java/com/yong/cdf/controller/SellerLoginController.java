package com.yong.cdf.controller;

import com.mysql.cj.util.StringUtils;
import com.yong.cdf.constant.CookieConstant;
import com.yong.cdf.constant.RedisConstant;
import com.yong.cdf.entity.CdfSeller;
import com.yong.cdf.enums.SellerLoginEnum;
import com.yong.cdf.form.CdfSellerForm;
import com.yong.cdf.form.CdfSellerRegisterForm;
import com.yong.cdf.service.CdfSellerService;
import com.yong.cdf.util.CookieUtil;
import com.yong.cdf.util.UniqueKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: UserController
 * @Description: 登录、注册，登出
 * @Author
 * @Date 2021/5/10
 * @Time 21:22
 * @Version 1.0
 */
@Slf4j
@RequestMapping("/seller")
@Controller
public class SellerLoginController {
    @Autowired
    private CdfSellerService cdfSellerService;

    @Autowired
    private  StringRedisTemplate redisTemplate;

    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("seller/login");
    }

    @RequestMapping("/login/system")
    public ModelAndView login(CdfSellerForm cdfSellerForm, HttpServletResponse response, ModelMap modelMap){
        Map<String,String> map=new HashMap<>();
        if(StringUtils.isEmptyOrWhitespaceOnly(cdfSellerForm.getUsername())){
            map.put("error", SellerLoginEnum.LOGIN_USERNAME_NOT_EXIST.getMessage());
            return new ModelAndView("seller/login", map);
        }
        CdfSeller cdfSeller = cdfSellerService.findByUsername(cdfSellerForm.getUsername());
        if (cdfSeller == null) {
            map.put("error", SellerLoginEnum.LOGIN_USERNAME_NOT_EXIST.getMessage());
            return new ModelAndView("seller/login", map);
        }
            String pwdFromWeb=cdfSellerForm.getPassword();
            String pwdFromDB=cdfSeller.getPassword();

         if(pwdFromWeb.equals(pwdFromDB)){
             redisTemplate.opsForValue().set(RedisConstant.token,cdfSeller.getUsername(),RedisConstant.expire, TimeUnit.SECONDS);
             CookieUtil.setCookie(response,CookieConstant.CookieName,cdfSeller.getUsername(), CookieConstant.age);
             return new ModelAndView("redirect:/seller/product/list");
        }

          map.put("error", SellerLoginEnum.LOGIN_FAILURE.getMessage());
          return new ModelAndView("redirect:/seller/login",map);
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("seller/register");
    }

    @RequestMapping("/register/system")
    public ModelAndView register(@Valid CdfSellerRegisterForm cdfSellerRegisterForm, BindingResult bindingResult){
       Map<String,Object> map=new HashMap<>();
       if(bindingResult.hasErrors()){
           map.put("error",bindingResult.getFieldError().getDefaultMessage());
           return new ModelAndView("redirect:/seller/register",map);
       }
       CdfSeller cdfSeller=cdfSellerService.findByUsername(cdfSellerRegisterForm.getUsername());
       if(cdfSeller!=null){
           map.put("errorUsername",SellerLoginEnum.REGISTER_USER_HAS_EXIST.getMessage());
           return new ModelAndView("seller/register",map);
       }

       if(!cdfSellerRegisterForm.getPassword().equals(cdfSellerRegisterForm.getConfirmPWD()) ){
           map.put("errorPWD",SellerLoginEnum.REGISTER_PASSWORD_IS_NOT_PERSISTENCE.getMessage());
           return new ModelAndView("seller/register",map);
       }
       if(cdfSellerRegisterForm.getPassword().length()<6){
           map.put("errorPWD",SellerLoginEnum.REGISTER_PASSWORD_FORMAT_IS_ERROR.getMessage());
           return new ModelAndView("seller/register",map);
       }

          String regPhone="^[1][3,4,5,7,8][0-9]{9}$";
      if(!cdfSellerRegisterForm.getPhone_number().matches(regPhone)){
          map.put("phoneError",SellerLoginEnum.REGISTER_PHONE_FORMAT_ERROR.getMessage());
          return new ModelAndView("seller/register",map);
       }

       String regEmail="^([a-zA-Z_0-9-])+@([a-zA-Z_0-9-])+(.[a-zA-Z_0-9-])+$";

       if(!cdfSellerRegisterForm.getEmail().matches(regEmail)){
           map.put("emailError",SellerLoginEnum.REGISTER_EMAIL_FORMAT_ERROR.getMessage());
           return new ModelAndView("seller/register",map);
       }
        CdfSeller cdfSellerNew=new CdfSeller();
        BeanUtils.copyProperties(cdfSellerRegisterForm,cdfSellerNew);
        cdfSellerNew.setUser_id(UniqueKey.generatedKey());
        cdfSellerService.addUser(cdfSellerNew);
        return new ModelAndView("seller/login");
    }

    @RequestMapping("/find")
    public ModelAndView findByCookie(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        Cookie cookie= CookieUtil.getCookie(request,CookieConstant.CookieName);
        if(cookie.getValue()==null){
          map.put("error",SellerLoginEnum.UPDATE_SELLER_HAS_LOGOUT.getMessage());
          return new ModelAndView("redirect:/seller/login");
        }
       CdfSeller cdfSeller=cdfSellerService.findByUsername(cookie.getValue());
       map.put("cdfSeller",cdfSeller);
       return new ModelAndView("seller/update",map);
    }

    @RequestMapping("/update")
        public ModelAndView update(CdfSellerRegisterForm cdfSellerRegisterForm,BindingResult bindingResult){
            Map<String,Object> map=new HashMap<>();
            if(bindingResult.hasErrors()){
                map.put("error",bindingResult.getFieldError().getDefaultMessage());
                map.put("url","/cdf/seller/find");
                return new ModelAndView("common/error",map);
            }

        if(!(cdfSellerRegisterForm.getPassword().equals(cdfSellerRegisterForm.getConfirmPWD()))) {
            map.put("error",SellerLoginEnum.REGISTER_PASSWORD_IS_NOT_PERSISTENCE.getMessage());
            map.put("url","/cdf/seller/find");
            return new ModelAndView("common/error",map);
        }

        if(cdfSellerRegisterForm.getPassword().length()<6){
            map.put("error",SellerLoginEnum.REGISTER_PASSWORD_FORMAT_IS_ERROR.getMessage());
            map.put("url","/cdf/seller/find");
            return new ModelAndView("common/error",map);
        }

        String regPhone="^[1][3,4,5,7,8][0-9]{9}$";
        if(!cdfSellerRegisterForm.getPhone_number().matches(regPhone)){
            map.put("error",SellerLoginEnum.REGISTER_PHONE_FORMAT_ERROR.getMessage());
            map.put("url","/cdf/seller/find");
            return new ModelAndView("common/error",map);
        }

        String regEmail="^([a-zA-Z_0-9-])+@([a-zA-Z_0-9-])+(.[a-zA-Z_0-9-])+$";

        if(!cdfSellerRegisterForm.getEmail().matches(regEmail)){
            log.info(cdfSellerRegisterForm.getEmail());
            map.put("error",SellerLoginEnum.REGISTER_EMAIL_FORMAT_ERROR.getMessage());
            map.put("url","/cdf/seller/find");
            return new ModelAndView("common/error",map);
        }
            CdfSeller cdfSeller=new CdfSeller();
            BeanUtils.copyProperties(cdfSellerRegisterForm,cdfSeller);
            cdfSellerService.updateSeller(cdfSeller);
            map.put("success",SellerLoginEnum.SELLER_MESSAGE_UPDATE_SUCCESS.getMessage());
            map.put("url","/cdf/seller/product/list");
            return new ModelAndView("common/success",map);
        }

        @RequestMapping("logout")
        public ModelAndView logout(HttpServletResponse response){
              Map<String,Object> map=new HashMap<>();
              redisTemplate.opsForValue().getOperations().delete(RedisConstant.token);
              CookieUtil.setCookie(response,CookieConstant.CookieName,null,0);
              return new ModelAndView("redirect:/seller/login");
    }
}
