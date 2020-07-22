package com.example.demo;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    // Save
    @PostMapping(value="/users", consumes  = MediaType.APPLICATION_XML_VALUE )
    @ResponseStatus(HttpStatus.CREATED)
    UserDTO newBook(@Valid @RequestBody UserDTO newUser) {
        return repository.save(newUser);
    }
}
