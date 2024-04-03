package com.example.CarbonCellAssignment.controller;

import com.example.CarbonCellAssignment.security.userDetails.CustomUserDetailsService;
import com.example.CarbonCellAssignment.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name="User Management", description = "Managing User Registration")public class UserController {
    @Autowired
    CustomUserDetailsService userDetailsService;

    @Operation(summary = "Allows new users to create an account by providing their username, email, and password.")
    @ApiResponse(responseCode = "200", description = "Successfully User Register")
    @ApiResponse(responseCode = "400", description = "Missing/invalid fields or user already exists.")

    //http://localhost:8080/user/register
    @PostMapping("/register")
    public String registerUser(@Parameter(name = "User Details",description = "Fill Your Details for Registration") @RequestBody User user){
        return userDetailsService.addUser(user);
    }
}
