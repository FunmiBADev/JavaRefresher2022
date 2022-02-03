package com.learn.java.rest.Controller;

import com.learn.java.rest.Models.User;
import com.learn.java.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private UserRepo _userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome!";
    }

    @GetMapping(value = "/users")
    public List<User> GetUsers() {
        return _userRepo.findAll();
    }
    @PostMapping(value = "/create")
    public String CreateUser(@RequestBody User user) {
        _userRepo.save(user);

        return "User saved to Database!";
    }

    @PutMapping(value = "/{id}")
    public String UpdateUser(@PathVariable long id, @RequestBody User user) {
        User matchUser = _userRepo.findById(id).get();
        matchUser.setFirstName(user.getFirstName());
        matchUser.setLastName(user.getLastName());
        matchUser.setAge(user.getAge());
        matchUser.setOccupation(user.getOccupation());

        _userRepo.save(matchUser);

        return "User details updated!";
    }

    @DeleteMapping(value = "/{id}")
    public String DeleteUser(@PathVariable long id) {
        User matchUser = _userRepo.findById(id).get();

        _userRepo.delete(matchUser);

        return "Deleted User with ID: " +id ;
    }
}
