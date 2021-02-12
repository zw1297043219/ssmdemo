package com.ssm.interceptor;

import com.ssm.Exception.MyException;
import com.ssm.entity.BizError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局异常拦截器
 */
public class GlobalExceptionInterceptor implements HandlerExceptionResolver {
    //日志输出
    private Logger log = LoggerFactory.getLogger(GlobalExceptionInterceptor.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("全局异常拦截");
        try {
            if(e instanceof MyException){
                setJSONErrorResponse(httpServletResponse,((MyException) e).getBizError());
                log.error(((MyException) e).getBizError().getErrorCode()+"---->"+((MyException) e).getBizError().getErrorMessage(),e);
            }else {
                setJSONErrorResponse(httpServletResponse,BizError.SYSTEM_ERROR);
                e.printStackTrace();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //返回一个空的modelAndView
        return modelAndView;
    }

    private void setJSONErrorResponse(HttpServletResponse httpServletResponse, BizError bizError) throws IOException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        //拼接json
        String retStr = "{\"errorCode\":\""+bizError.getErrorCode()+
                            "\",\"status\":\"filed\",\"errorMsg\":\""+bizError.getErrorMessage()+"\"}";
        httpServletResponse.getWriter().write(retStr);
    }

}
