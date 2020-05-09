package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //post请求参数
        String username = request.getParameter("username");
      /*  System.out.println("post");
        System.out.println(username);*/
       /* String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/
        Enumeration<String> parameterNames = request.getParameterNames();
        /*while(parameterNames.hasMoreElements()){
            String name=parameterNames.nextElement();
            System.out.println(name);
            String[] parameterValues = request.getParameterValues(name);
            for (String parameterValue : parameterValues) {
                System.out.println(parameterValue);
            }

            System.out.println("------------------");
        }*/
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("------------");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get请求参数
        /*String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/
        this.doPost(request,response);
    }
}
