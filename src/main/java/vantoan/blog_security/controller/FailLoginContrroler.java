package vantoan.blog_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FailLoginContrroler {
    @PostMapping ("failLogin")
    public ModelAndView failLogin(){
        return new ModelAndView("failLogin");
    }
}
