package com.example.bootdemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bootdemo.bean.User;
import com.example.bootdemo.service.UserService;
import com.example.bootdemo.service.impl.UserServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author Chenchenx
 * @version v1.0
 * @date 2021/12/215:05
 */
@Controller
public class TableController {

    @Autowired
    public UserService userService;


    @GetMapping("/basic_table.html")
    public String basic_table() {
        return "/table/basic_table";
    }

    @GetMapping("/dynamic_table.html")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //遍历User数据
//        List<User> users = Arrays.asList(new User("admin", "123465"),
//                new User("csy", "123"));
//        model.addAttribute("users", users);
        Page<User> userPage = new Page<>(pn, 2);
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page", page);
        return "/table/dynamic_table";
    }

    @GetMapping("/responsive_table.html")
    public String responsive_table() {
        return "/table/responsive_table.html";
    }

    @GetMapping("/editable_table.html")
    public String editable_table() {
        return "/table/editable_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes re) {
        userService.removeById(id);
        re.addAttribute("pn", pn);
        return "redirect:/dynamic_table.html";
    }

    @GetMapping("/toAdd")
    public String toAdd() {
        return "/table/adduser";
    }

    @PostMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/dynamic_table.html";
    }

    @GetMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id, Model model) {
        User byId = userService.getById(id);
        model.addAttribute("user",byId);
        return "/table/edit_table";
    }
    @PostMapping("/edit")
    public String edit(User user) {
        userService.updateById(user);
        return "redirect:/dynamic_table.html";
    }
}
