package cn.kgc.controller;

import cn.kgc.entity.User;
import cn.kgc.entity.UserList;
import cn.kgc.service.Impl.UserServiceImpl;
import cn.kgc.service.UserService;
import cn.kgc.util.TranslationUtil;
import com.mysql.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mr
 * @Date 2019/10/14 17:07
 */
@WebServlet(name = "RegisterController",urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet (req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println ("===post请求===");
        //设置编码格式解决乱码问题
        req.setCharacterEncoding ("utf-8");
        resp.setCharacterEncoding ("utf-8");
        //获取用户名和密码
        String name = req.getParameter ("userName");
        String pwd = req.getParameter ("pwd");

        String sex = req.getParameter ("sex");
        if (sex.equals ("man")) {
            sex = "男";
        } else {
            sex = "女";
        }
        String[] hobbys = req.getParameterValues ("hobby");
        String hobby = TranslationUtil.hobbyTranslation (hobbys[0]);
        for (int i = 1; i < hobbys.length; i++) {
            hobby += " " + TranslationUtil.hobbyTranslation (hobbys[i]);
        }
        UserService userService = new UserServiceImpl ();

        boolean flagPwd = false;
        boolean flagName = false;

        String pattPwd = "^\\d+";
        if (pwd.matches (pattPwd)) {
            flagPwd = true;
        }
        String pattName = "^[^ ]+";
        if (name.matches (pattName)) {
            flagName = true;
        }

        if (flagName && flagPwd) {
            userService.saveUserIntoDB (new User (name,pwd,sex,hobby));
            resp.sendRedirect ("login.jsp");
        } else {
            resp.sendRedirect ("register.jsp");
        }


//        User user = new User (name, pwd);
//        UserList userList = new UserList ();
//        userList.addUserList (user);
//        userList.save ();
    }
}
