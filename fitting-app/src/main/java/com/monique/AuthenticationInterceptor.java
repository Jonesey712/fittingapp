package com.monique;


import com.monique.controllers.AbstractController;
import com.monique.models.User;
import com.monique.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationInterceptor {

    @Autowired
    UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        List<String> nonAuthPages = Arrays.asList("/", "/login", "/register");

        // Require sign-in for auth pages
        if ( !nonAuthPages.contains(request.getRequestURI()) ) {

            boolean isLoggedIn = false;
            User user;
            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
                user = userDao.findById(userId);

                if (user != null)
                    isLoggedIn = true;
            }

            // If user not logged in, redirect to login page
            if (!isLoggedIn) {
                response.sendRedirect("/login");
                return false;
            }
        }

        return true;
    }
}

