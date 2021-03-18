package vantoan.blog_security.service;

import vantoan.blog_security.model.AppUser;

public interface IAppUserService {
    AppUser findByName(String name);
}
