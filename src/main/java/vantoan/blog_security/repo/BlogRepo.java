package vantoan.blog_security.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vantoan.blog_security.model.Blog;

@Repository
public interface BlogRepo extends CrudRepository<Blog,Long> {
}
