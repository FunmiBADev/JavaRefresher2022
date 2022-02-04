package com.learn.java.rest.Controller;

import com.learn.java.rest.Models.User;
import com.learn.java.rest.Repo.UserRepo;
import com.learn.java.rest.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ApiController {

    private IUserService _userService;

    public ApiController(IUserService userService) {
        super();
        _userService = userService;
    }

    @GetMapping
    public List<User> GetUsers() {
        return _userService.GetALlUsers();
    }

    @PostMapping
    public ResponseEntity<User>  CreateUser(@RequestBody User user) {
        return new ResponseEntity<>(_userService.CreateUser(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User>  UpdateUser(@PathVariable long id, @RequestBody User user) {

        return new ResponseEntity<>(_userService.UpdateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> DeleteUser(@PathVariable long id) {
        _userService.DeleteUser(id);
        return new ResponseEntity<>("User deleted successfully!.", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable("id") long userId){
        return new ResponseEntity<>(_userService.GetUserById(userId), HttpStatus.OK);
    }
}
