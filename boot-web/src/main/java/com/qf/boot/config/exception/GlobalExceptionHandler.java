package com.qf.boot.config.exception;

import com.qf.boot.util.request.RequestUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 作者：杜夫人
 * date: 2020/8/11
 */
@ControllerAdvice // 一定要加这个注解
public class GlobalExceptionHandler {

    @ExceptionHandler
    ModelAndView exceptionHandler(Exception e) {
        ModelAndView mav;
        if (RequestUtil.isAjax()) {// （稍微标准工作）中要用的
            mav = new ModelAndView(new MappingJackson2JsonView());// 就是让数据以JSON的格式返回给调用方

            if (e instanceof UnauthorizedException) {
                mav.addObject("msg", "您没有相关的操作权限，请换号登录！");// 这里添加的数据，就是JSON格式的数据
            }
            mav.addObject("res", false);
        } else {
            mav = new ModelAndView("error/error");// 返回页面
            System.err.println(e.getMessage());
        }
        return mav;
    }

}
