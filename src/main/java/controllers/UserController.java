package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import services.UserServices;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;


}