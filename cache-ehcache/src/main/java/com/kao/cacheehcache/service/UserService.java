package com.kao.cacheehcache.service;

import com.kao.cacheehcache.entity.User;

public interface UserService {

    User saveOrUpdate(User user);
    User get(Long id);
    void delete(Long id);
    
}
