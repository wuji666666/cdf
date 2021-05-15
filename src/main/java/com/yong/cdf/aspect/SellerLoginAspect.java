package com.yong.cdf.aspect;

import com.mysql.cj.util.StringUtils;
import com.yong.cdf.constant.CookieConstant;
import com.yong.cdf.constant.RedisConstant;
import com.yong.cdf.util.CookieUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: SellerLoginAspect
 * @Description: 卖家端登录拦截
 * @Author
 * @Date 2021/5/11
 * @Time 17:03
 * @Version 1.0
 */




@Component
@Aspect
public class SellerLoginAspect {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Before("execution(* com.yong.cdf.controller..*(..))"
          +"&& !execution(* com.yong.cdf.controller.BuyerProductController..*(..))"
           +"&& !execution(* com.yong.cdf.controller.SellerLoginController.login(..))"
           +"&& !execution(* com.yong.cdf.controller.SellerLoginController.register(..))")
    public void loginInterceptor( )   {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

           try{
               Cookie cookie = CookieUtil.getCookie(request, CookieConstant.CookieName);
               if(cookie==null){

               }
           }catch (Exception e){
               e.printStackTrace();
           }

           try {
               String value= redisTemplate.opsForValue().get(RedisConstant.token);
               if (StringUtils.isEmptyOrWhitespaceOnly(value)) {
                   response.sendRedirect("/cdf/seller/login");
               }
           }catch (Exception e){
               e.printStackTrace();
           }






    }
}
