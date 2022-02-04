package com.learn.java.rest.Services;

import com.learn.java.rest.Models.User;

import java.util.List;

@SuppressWarnings("ALL")
public interface IUserService {

    User CreateUser(User user);
    List<User> GetALlUsers();
    User GetUserById(long id);
    User UpdateUser(User user, long id);
    void DeleteUser(long id);
}
