package vantoan.blog_security.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vantoan.blog_security.model.AppUser;

@Repository
public interface AppUserRepo extends CrudRepository<AppUser,Long> {
    AppUser findAppUserByName(String name);
}
