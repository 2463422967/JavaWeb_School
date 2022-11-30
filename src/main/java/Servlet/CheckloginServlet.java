package Servlet; /**
 * @ClassName: ${NAME}
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/11/12 20:21
 * @Version: 1.0
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CheckloginServlet", value = "/CheckloginServlet")
public class CheckloginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
