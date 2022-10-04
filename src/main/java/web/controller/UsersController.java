package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService service;


    @GetMapping()
    public String getAllUsers(ModelMap map) {
        map.addAttribute("users", service.listUsers());
        return "users";
    }

}
