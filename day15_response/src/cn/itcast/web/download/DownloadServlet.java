package cn.itcast.web.download;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取请求参数，文件名称
        String filename = request.getParameter("filename");
        //2使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联
        FileInputStream fis=new FileInputStream(realPath);
        //3设置response的响应头
        //3.1设置响应头类型
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        /*String agent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);*/
        response.setHeader("content-disposition","attachment;filename="+filename);
        //4将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff =new byte[1024*8];
        int len =0;
        while((len=fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
