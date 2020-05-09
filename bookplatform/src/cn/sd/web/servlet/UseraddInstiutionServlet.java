package cn.sd.web.servlet;

import cn.sd.domain.Instiutions;
import cn.sd.domain.User;
import cn.sd.service.Impl.Instiution_userserviceImpl;
import cn.sd.service.Impl.InstiutionsserviceImpl;
import cn.sd.service.Impl.UserserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UseraddInstiutionServlet")
public class UseraddInstiutionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            //获取上一个sevlet存储的认证的基金会信息
            Instiutions instiution = (Instiutions)request.getAttribute("instiution");
            HttpSession session = request.getSession();

            //获取session存储的用户
            User user = (User)session.getAttribute("user");

            //调用基金会表的service 来通过基金会的名字和联系人找基金会
            InstiutionsserviceImpl instiutionsservice = new InstiutionsserviceImpl();
            int id = instiutionsservice.findIdbyNameandlinkman(instiution);

            //更新用户的是基金会字段
            UserserviceImpl userservice = new UserserviceImpl();
            user.setIsinstiutions(id);
            //System.out.println(user);
            userservice.update(user);


            //将用户id与基金会id绑定
            Instiution_userserviceImpl instiution_userservice = new Instiution_userserviceImpl();
            instiution_userservice.userAddInstiution(user,id);



            request.getRequestDispatcher("juanshu.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
