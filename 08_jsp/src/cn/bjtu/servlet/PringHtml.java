package cn.bjtu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author shkstart
 * @create 2020-03-13 22:28
 */
public class PringHtml extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        org.apache.jasper.runtime.HttpJspBase a;

        resp.setContentType("text/html;charset=UTF-8");
        // 通过响应的输出流回传HTML页面数据
        PrintWriter writer = resp.getWriter();

        writer.write("<!DOCTYPE html>\r\n");
        writer.write("<html lang=\"en\">\r\n");
        writer.write("<head>\r\n");
        writer.write("<meta charset=\"UTF-8\">\r\n");
        writer.write("<title>Title</title>\r\n");
        writer.write("</head>\r\n");
        writer.write("<body>\r\n");
        writer.write("这是HTML页面数据\r\n");
        writer.write("</body>\r\n");
        writer.write("</html>\r\n");
        writer.write("\r\n");










    }
}
