package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0、强转转换
        HttpServletRequest request =(HttpServletRequest) req;
        //1、获取资源请求路径 要注意排除掉 css/js/图片/验证码等资源
        String url = request.getRequestURI();
        if(url.contains("/login.jsp")||url.contains("/loginServlet")||
                url.contains("/css/")|| url.contains("/js/")|| url.contains("/fonts/")|| url.contains("/checkCodeServlet")){
            //包含，用户登录 放行
            chain.doFilter(req, resp);
        }else{
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                chain.doFilter(req, resp);
            }else{
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
        //chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
