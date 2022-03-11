package ysw.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/4 9:47
 * @Version
 **/
public class SysExceptionResolver implements HandlerExceptionResolver {

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Param [httpServletRequest, httpServletResponse, o, e]
     * @Date 9:48 2020/7/4
     * @Description: 处理异常
     **/
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取异常对象
        SysException ex = null;
        if (e instanceof SysException) {
            ex = (SysException) e;
        } else {
            ex = new SysException("系统正在维护……");
        }
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", ex.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
