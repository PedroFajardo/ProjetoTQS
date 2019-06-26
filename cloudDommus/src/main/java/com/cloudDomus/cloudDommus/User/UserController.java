package com.cloudDomus.cloudDommus.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(value="CloudDomus User Management System")
public class UserController {

    @Autowired
    UserRepository repository;

    // Aggregate root
    @ApiOperation(value = "View a list of available User", response = List.class)
    @GetMapping("/user")
    List<User> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Create a new user", response = List.class)
    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item
    @ApiOperation(value = "Get user by Id", response = List.class)
    @GetMapping("/user/{id}")
    User getUserrByID(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

   /* @ApiOperation(value = "Edit/Replace a user by its Id", response = List.class)
    @PutMapping("/User/{id}")
    User replaceUser(@RequestBody User newuser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.setName(newuser.getName());
                    user.setNumberWorkers(newuser.getNumberWorkers());
                    user.setDescription(newuser.getDescription());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newuser.setId(id);
                    return repository.save(newuser;
                });
    }*/

    @ApiOperation(value = "Delete a user by its Id", response = List.class)
    @DeleteMapping("/User/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
