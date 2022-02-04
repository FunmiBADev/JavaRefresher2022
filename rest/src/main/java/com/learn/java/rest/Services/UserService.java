package com.learn.java.rest.Services;

import com.learn.java.rest.Exceptions.JavaUserAppException;
import com.learn.java.rest.Models.User;
import com.learn.java.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepo _userRepo;

    public UserService(UserRepo _userRepo) {
        super();
        this._userRepo = _userRepo;
    }

    @Override
    public User CreateUser(User user) {
        return _userRepo.save(user);
    }

    @Override
    public List<User> GetALlUsers() {
        return _userRepo.findAll();
    }

    @Override
    public User GetUserById(long id) {

        return   _userRepo.findById(id).orElseThrow(
                () -> new JavaUserAppException("User", "Id", id));
    }

    @Override
    public User UpdateUser(User user, long id) {

        User matchUser = GetUserById(id);

        matchUser.setFirstName(user.getFirstName());
        matchUser.setLastName(user.getLastName());
        matchUser.setAge(user.getAge());
        matchUser.setOccupation(user.getOccupation());

        _userRepo.save(matchUser);

        return matchUser;
    }

    @Override
    public void DeleteUser(long id) {
        User matchUser = GetUserById(id);
        _userRepo.delete(matchUser);
    }
}
