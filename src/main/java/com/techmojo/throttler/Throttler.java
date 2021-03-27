package com.techmojo.throttler;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Throttler implements HandlerInterceptor {

    Map<String, AppRequest> map = new ConcurrentHashMap<>();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        if (!map.containsKey(request.getRemoteAddr())) {

            map.put(request.getRemoteAddr(), AppRequest.builder().time(Calendar.getInstance().getTimeInMillis() + 10000).count(1).build());
        } else {
            AppRequest appreq = map.get(request.getRemoteAddr());
            if (appreq.getCount() > 20 && Calendar.getInstance().getTimeInMillis() < appreq.getTime()) {
                throw new IllegalArgumentException();

            } else if (appreq.getCount() > 20 && Calendar.getInstance().getTimeInMillis() > appreq.getTime()) {
                map.put(request.getRemoteAddr(), AppRequest.builder().time(Calendar.getInstance().getTimeInMillis() + 10000).count(1).build());
            } else {
                AppRequest appreqq = map.get(request.getRemoteAddr());
                appreq.setCount(appreqq.getCount() + 1);
                map.put(request.getRemoteAddr(), appreq);

            }

        }


        return true;

    }

}
