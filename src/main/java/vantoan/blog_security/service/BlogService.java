package vantoan.blog_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vantoan.blog_security.model.Blog;
import vantoan.blog_security.repo.BlogRepo;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private BlogRepo blogRepo;
    @Override
    public List<Blog> findAll() {
        return (List<Blog>)blogRepo.findAll() ;
    }

    @Override
    public Blog findById(Long id) {
        return blogRepo.findById(id).get();
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepo.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepo.deleteById(id);

    }
}
