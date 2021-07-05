//package ru.itis.javalab.servlets;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import ru.itis.javalab.models.User;
//import ru.itis.javalab.services.UserService;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.UUID;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//    private UserService userService;
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String password = req.getParameter("password");
//        String hashPassword = passwordEncoder.encode(password);
//        Optional<User> optionalUser = userService.findByUsername(req.getParameter("username"));
//        User user = optionalUser.orElse(null);
//        if (passwordEncoder.matches(Objects.requireNonNull(user).getPassword(), hashPassword)) {
//            String uuid = UUID.randomUUID().toString();
//            Cookie cookie = new Cookie("UUID", uuid);
//            cookie.setMaxAge(60 * 60 * 24);
//            userService.update(req.getParameter("username"), uuid);
//            resp.addCookie(cookie);
//            resp.sendRedirect("/jsp/profile.jsp");
//        } else {
//            resp.sendRedirect("/jsp/login.jsp");
//        }
//
//    }
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        ServletContext servletContext = config.getServletContext();
//        this.userService = (UserService) servletContext.getAttribute("userService");
//        this.passwordEncoder = (PasswordEncoder) servletContext.getAttribute("passwordEncoder");
//    }
//}
