package com.ssm.controller;

import com.ssm.entity.Users;
import com.ssm.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    UsersService usersService;
    @RequestMapping("/ex/{id}")
    public String testEX(@PathVariable("id") String id){
        usersService.doEX(id);
        String a="aaa";
        String b="bbbbbbbb";
        String c="ccccccc";
        String d="dddddddd";
        return "OK";
    }


    @RequestMapping("/hello")
    public String sayHello(HttpServletRequest request){
        List<Users> users = usersService.findAllUsers();
        Users user = users.get(0);
        request.setAttribute("file",user);
        return "show";
    }
}
