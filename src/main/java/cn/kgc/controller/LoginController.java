package cn.kgc.controller;

import cn.kgc.dao.UserDao;
import cn.kgc.entity.User;
import cn.kgc.entity.UserList;
import cn.kgc.service.Impl.UserServiceImpl;
import cn.kgc.service.UserService;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author mr
 * @Date 2019/10/15 14:50
 */
@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet (req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl ();
        req.setCharacterEncoding ("utf-8");
        resp.setCharacterEncoding ("utf-8");

        String userName = req.getParameter ("userName");
        String pwd = req.getParameter ("userPwd");

        List<User> users = userService.selectAllInfo ();
        for (int i = 0; i < users.size (); i++) {
            System.out.println (users.get (i).getUsername ());
        }

        User userFromDB = userService.getUserbyNameAndPwd (userName, pwd);
        if (userFromDB != null) {
            req.setAttribute ("mess", userName + "登录成功！");
            req.setAttribute ("info", users);

            req.getRequestDispatcher ("success.jsp").forward (req, resp);
        } else {
            req.getRequestDispatcher ("login.jsp").forward (req, resp);
        }
    }
}
