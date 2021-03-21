package vantoan.blog_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vantoan.blog_security.model.AppUser;
import vantoan.blog_security.service.IAppUserService;

@Controller
public class UserController {
    @Autowired
    private IAppUserService appUserService;
    @ModelAttribute("currentUser")
    public AppUser getCurrentUser(){
        return appUserService.getUserCurrent();
    }
    @GetMapping("khongcoquyen")
    public ModelAndView p403(){
        return new ModelAndView("khongcoquyen");
    }
    @GetMapping("admin")
    public ModelAndView admin(){
        return new ModelAndView("admin");
    }
    @GetMapping("user")
    public ModelAndView pUser(){
        return new ModelAndView("user");
    }
    @GetMapping("login")
    public ModelAndView login(){
        return new ModelAndView("failLogin");
    }

}
