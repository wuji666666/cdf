package com.yong.cdf.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CookieUtil
 * @Description: Cookie设置与获取
 * @Author
 * @Date 2021/5/12
 * @Time 18:20
 * @Version 1.0
 */


public class CookieUtil {
    public static void setCookie(HttpServletResponse response,String name ,String value,int age){
        Cookie cookie=new Cookie(name,value);
        cookie.setMaxAge(age);
        cookie.setPath("/cdf/seller");
        response.addCookie(cookie);
    }

    public static Cookie getCookie(HttpServletRequest request,String username){
      Map<String,Cookie> cookieMap= readCookieMap(request);
      if(cookieMap.containsKey(username)){
          return cookieMap.get(username);
      }else{
          return null;
      }
    }

    public static Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Map<String,Cookie> map=new HashMap<>();
        Cookie[] cookies=  request.getCookies();
        if(cookies == null){
            return null;
        }
        for(Cookie cookie:cookies){
            map.put(cookie.getName(),cookie);
        }
        return map;
    }



}
