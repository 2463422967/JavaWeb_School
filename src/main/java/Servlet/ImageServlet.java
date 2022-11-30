package Servlet; /**
 * @ClassName: ${NAME}
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/11/12 15:01
 * @Version: 1.0
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ImageServlet", value = "/ImageServlet")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int wight = 78;
        int height = 20;
        //创建对象
        BufferedImage bim = new BufferedImage(68,20,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = bim.getGraphics();
        Random rm = new Random();
        g.setColor(new Color(rm.nextInt(100),205,rm.nextInt(100)));
        g.fillRect(0,0,wight,height);
        StringBuffer sbf = new StringBuffer("");
        for (int i = 0; i < 4; i++) {
            g.setColor(Color.black);
            g.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,22));
            int n = rm.nextInt(10);
            sbf.append(n);
            g.drawString(""+n,i*15+5,18);
        }
        //将生成的验证码存到session
        HttpSession session = request.getSession(true);
        session.setAttribute("piccode",sbf);
        //禁止缓存
        response.setHeader("Prama","no-cache");
        response.setHeader("Coche=Control","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
        //将bim图片返回浏览器
        ImageIO.write(bim,"JPG",response.getOutputStream());
        response.getOutputStream().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
