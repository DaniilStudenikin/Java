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
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.UUID;
//
//@WebServlet("/register")
//public class RegisterServlet extends HttpServlet {
//    private UserService userService;
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        ServletContext servletContext = config.getServletContext();
//        this.userService = (UserService) servletContext.getAttribute("userService");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
//    }
//
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
//            cookie.setMaxAge(60 * 60 * 25);
//            userService.save(req.getParameter("username"), req.getParameter("password"), uuid);
//            resp.addCookie(cookie);
//            resp.sendRedirect("/jsp/profile.jsp");
//        } else {
//            resp.sendRedirect("/jsp/register.jsp");
//        }
//    }
//}
