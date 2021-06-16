package com.atguigu.crowd.mvc.config;

import com.atguigu.crowd.exception.AccessForbiddenException;
import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xian
 * Data : 2021/5/27.
 * Time : 14:42.
 */
@ControllerAdvice
public class CrowdExceptionResolver {
    @ExceptionHandler(value = LoginFailedException.class)
    public ModelAndView resolverLoginFailedException(LoginFailedException  exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        return this.commonResolver( exception,  request,  response,"login");
    }
    @ExceptionHandler(value = AccessForbiddenException.class)
    public ModelAndView resolverAccessForbiddenException(AccessForbiddenException  exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        return this.commonResolver( exception,  request,  response,"login");
    }


    private  ModelAndView commonResolver(Exception exception,
                                         HttpServletRequest request,
                                         HttpServletResponse response,
                                         String viewName) throws IOException {

        boolean type = CrowdUtil.judgeRequestType(request);
        if (type){
            ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
            Gson gson = new Gson();
            String json = gson.toJson(resultEntity);
            response.getWriter().write(json);
            return null;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",exception);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
