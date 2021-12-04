package com.example.bootdemo.controller;

import com.example.bootdemo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Chenchenx
 * @version v1.0
 * @date 2021/11/30 22:44
 */
@Controller
public class UserController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //    登录页面
    @GetMapping("/")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session,Model model) {
        if (user.getUsername().equals("admin")&& user.getPassword().equals("123456")) {
            session.setAttribute("loginUser",user);
            return "redirect:/main";
        }else{
            model.addAttribute("msg","账号或密码错误");
            return "login";
        }
    }

    @GetMapping("/main")
    public String main(HttpSession session,Model model) {
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null){
            return "index";
//        }else {
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
    }
    @ResponseBody
    @GetMapping("/sql")
    public String sql(){
        List<Long> longs = jdbcTemplate.queryForList("select count(*) from book", long.class);
        return longs.toString();
    }
}
