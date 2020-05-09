package cn.sd.web.servlet;

import cn.sd.domain.Books;
import cn.sd.domain.Donation_orders;
import cn.sd.domain.User;
import cn.sd.service.Impl.BooksserviceImpl;
import cn.sd.service.Impl.DonateordersserviceImpl;
import cn.sd.service.Impl.UserserviceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * 捐书功能
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> map = request.getParameterMap();
        Books book = new Books();
        try {
            BeanUtils.populate(book,map);
            HttpSession session = request.getSession();
            //获取session存储的user用户
            User user = (User) session.getAttribute("user");

            //绑定捐书的时间
            Date date = new Date();
            book.setBook_date(date);

            //将书与用户绑定

            book.setUser_id(user.getUser_id());
            BooksserviceImpl booksservice = new BooksserviceImpl();
            booksservice.addbook(book);

            //更新user的捐书数量
            user.setUser_donations(user.getUser_donations()+1);
            UserserviceImpl userservice = new UserserviceImpl();
            userservice.update(user);

            //创建捐单
            Donation_orders donation_order = new Donation_orders();
            Integer shouuserid = (Integer) session.getAttribute("shouuserid");//userid_2
            donation_order.setUser_id2(shouuserid);
            donation_order.setUser_id1(user.getUser_id());
            donation_order.setDonation_date(book.getBook_date());
            donation_order.setDonation_remarks(book.getBook_remakes());
            Integer id = booksservice.findbookIdbynameanddateanduid(book);//获取书的id
            donation_order.setBook_id(id);
            DonateordersserviceImpl donateordersservice = new DonateordersserviceImpl();
            donateordersservice.addDonateorder(donation_order);

            request.getRequestDispatcher("/juanshu.jsp").forward(request,response);
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
