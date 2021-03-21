package vantoan.blog_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vantoan.blog_security.model.AppUser;
import vantoan.blog_security.model.Blog;
import vantoan.blog_security.service.AppUserService;
import vantoan.blog_security.service.IAppUserService;
import vantoan.blog_security.service.IBlogService;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IAppUserService appUserService;
    @ModelAttribute("currentUser")
    public AppUser getCurrentUser(){
        return appUserService.getUserCurrent();
    }
    @GetMapping("")
    public ModelAndView showAll(){
        List<Blog> blogs= blogService.findAll();
        return new ModelAndView("home","listBlogs",blogs);
    }
    @GetMapping("create")
    public ModelAndView shoeFormCreate(@ModelAttribute Blog blog){
        return new ModelAndView("create","blog",blog);

    }
    @PostMapping("create")
    public ModelAndView create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return new ModelAndView("redirect:/blogs");
    }
    @GetMapping("edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Blog blog=blogService.findById(id);
        return new ModelAndView("edit","blog",blog);
    }
    @PostMapping("edit/{id}")
    public ModelAndView edit(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return new ModelAndView("redirect:/blogs");
    }
    @GetMapping("detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id){
        Blog blog= blogService.findById(id);
        return new ModelAndView("detail","blog",blog);
    }

}
