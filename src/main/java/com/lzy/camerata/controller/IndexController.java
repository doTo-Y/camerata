package com.lzy.camerata.controller;

import com.lzy.camerata.model.User;

import com.lzy.camerata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String t =cookie.getName();
                if (t.equals("token")) {
                    String token = cookie.getValue();
                    User user = userService.findMyToken(token);
                    if (user != null) request.getSession().setAttribute("user", user);

                    break;
                }

            }

        }
        return "index";
    }
}
