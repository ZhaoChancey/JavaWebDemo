package cn.bjtu.servlet;

import cn.bjtu.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-03-14 20:24
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        // 发sql语句查询学生的信息
        // 使用for循环生成查询到的数据做模拟
        List<Student> students = new ArrayList<>();
        for (int i = 0;i <= 9;i++){
            int num = i + 1;
            students.add(new Student(num,"name" + num,18 + i,"phone" + num));
        }
        // 保存查询到的结果（学生信息）到request域中
        req.setAttribute("stuList",students);
        // 请求转发到showStudent.jsp页面
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req,resp);
    }
}
