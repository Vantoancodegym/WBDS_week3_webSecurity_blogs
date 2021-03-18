package vantoan.blog_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vantoan.blog_security.model.AppUser;
import vantoan.blog_security.repo.AppUserRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private AppUserRepo appUserRepo;
    @Override
    public AppUser findByName(String name) {
        return appUserRepo.findAppUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=findByName(username);
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(appUser.getRole());
        UserDetails userDetails=new User(appUser.getName(),appUser.getPassword(),authorities);
        return userDetails;
    }
}
