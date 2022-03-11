package ysw.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/4 10:46
 * @Version
 **/
public class MyInterceptor implements HandlerInterceptor {
    /**
     * @return boolean
     * true：放行，执行下一个拦截器，若没有，则执行controller中的方法
     * false：不放行
     * @Param [request, response, handler]
     * @Date 10:47 2020/7/4
     * @Description: 预处理，controller方法执行前
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("……");
        return true;
    }

    /**
     * @return void
     * @Param [request, response, handler, modelAndView]
     * @Date 10:58 2020/7/4
     * @Description: Controller执行后执行的方法
     **/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle……");
        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
    }

    /**
     * @return void
     * @Param [request, response, handler, ex]
     * @Date 10:59 2020/7/4
     * @Description: 最后执行的方法, 即跳转到success.jsp之后会执行该方法
     **/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion……");
    }
}
