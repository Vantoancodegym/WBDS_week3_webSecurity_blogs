package vantoan.blog_security.service;

import vantoan.blog_security.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    Blog save(Blog blog);
    void delete(Long id);
}
