package cn.sd.web.servlet;

import cn.sd.domain.Books;
import cn.sd.domain.User;
import cn.sd.service.Impl.BooksserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindBooksByIdServlet")
public class FindBooksByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            User user =(User)session.getAttribute("user");
            BooksserviceImpl booksservice = new BooksserviceImpl();
            List<Books> books = booksservice.findbookbyId(user);
            session.setAttribute("books",books);
           /* System.out.println(books);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
