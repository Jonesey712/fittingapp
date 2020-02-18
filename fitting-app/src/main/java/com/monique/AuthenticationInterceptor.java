package com.monique;


/*import com.monique.controllers.AbstractController;
import com.monique.models.User;
import com.monique.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    UserDao userDao;

    //@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        List<String> nonAuthPages = Arrays.asList("/", "/register/login");

        // Require sign-in for auth pages
        if ( !nonAuthPages.contains(request.getRequestURI()) ) {

            boolean isLoggedIn = false;
            Optional<User> user;
            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
                user = userDao.findById(userId);

                if (user != null)
                    isLoggedIn = true;
            }

            // If user not logged in, redirect to login page
            if (!isLoggedIn) {
                response.sendRedirect("/register/login");
                return false;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}*/

