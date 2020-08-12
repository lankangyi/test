package com.qf.boot.util.request;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * creator：杜夫人
 * date: 2020/7/31
 */
public class RequestUtil {

    /**
     * 拿到HttpServletRequest对象
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 判断是否是ajax请求
     *
     * @return
     */
    public static boolean isAjax() {
        return "XMLHttpRequest".equals(getRequest().getHeader("X-Requested-With"));
    }

}
