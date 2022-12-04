package Servlet; /**
 * @ClassName: ${NAME}
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/12/1 21:50
 * @Version: 1.0
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet", value = "/BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取用户需要访问的方法
            String methodName = req.getParameter("action");
            //获取指定类的字节码对象
            Class<?> clazz = this.getClass();//this指的是继承BaseServlet的对象
            //调用当前类的getMethod()来获取当前类的方法
            Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);//开启暴力反射
            //通过反射来调用当前类的方法（谁来调用，当前类就是this）
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
