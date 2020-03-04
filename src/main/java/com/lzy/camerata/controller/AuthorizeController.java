package com.lzy.camerata.controller;

import com.lzy.camerata.dto.AccessTokenDTO;
import com.lzy.camerata.dto.GithubUserDTO;
import com.lzy.camerata.model.User;
import com.lzy.camerata.provider.GithubProvider;
import com.lzy.camerata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private UserService userService;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                            HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUserDTO githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null) {

            User user = new User();
            user.setName(githubUser.getName());
            user.setBio(githubUser.getBio());
            user.setGithubId(githubUser.getId());
            user.setGithubLogin(githubUser.getLogin());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            userService.register(user);
            response.addCookie(new Cookie("token", token));

            return "redirect:/";
        }
        return  "redirect:/";
    }

}
