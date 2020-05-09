package cn.sd.web.servlet;

import cn.sd.domain.User;
import cn.sd.service.Userservice;
import cn.sd.service.Impl.UserserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/FindUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        /*System.out.println(email+" "+password);*/
        Userservice userservice =new UserserviceImpl();
        User user = userservice.findUser(email, password);
        HttpSession session = request.getSession();
        if(user!=null){
            //System.out.println(user);
            session.setAttribute("user",user);
            session.setAttribute("success","yes");
            //象征性的创建基金会用户发布书后的账号id
            int shouuid =1;
            String shouuserid ="shouuserid#"+shouuid;
            session.setAttribute("shouuserid",shouuid);

            request.getRequestDispatcher("juanshu.jsp").forward(request,response);
        }else{
            session.setAttribute("success","no");
            request.getRequestDispatcher("denglv.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
