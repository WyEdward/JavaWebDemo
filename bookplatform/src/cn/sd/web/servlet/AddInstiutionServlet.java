package cn.sd.web.servlet;

import cn.sd.domain.Instiutions;
import cn.sd.service.Impl.Instiution_userserviceImpl;
import cn.sd.service.Impl.InstiutionsserviceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 用户进行基金会认证
 */
@WebServlet("/addInstiutionServlet")
public class AddInstiutionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            Map<String, String[]> map = request.getParameterMap();
            Instiutions instiutions = new Instiutions();
            BeanUtils.populate(instiutions,map);
            InstiutionsserviceImpl instiutionsservice = new InstiutionsserviceImpl();
            instiutionsservice.addInstiutions(instiutions);
            //System.out.println(instiutions.getInstiution_id());
            request.setAttribute("instiution",instiutions);
            request.getRequestDispatcher("/UseraddInstiutionServlet").forward(request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
