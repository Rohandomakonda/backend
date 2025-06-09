package com.example.auth_service.controller;


import com.example.auth_service.Model.Profile;
import com.example.auth_service.dto.ProfileRequest;
import com.example.auth_service.service.ProfileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class ProfileController {
    @Autowired
    ProfileService profileservice;
    @PostMapping("/addprofile")
    public ResponseEntity<Profile> login(@RequestBody ProfileRequest request, HttpServletResponse response) {
        System.out.println("logging in1");

        return ResponseEntity.ok(profileservice.addprofile(request));
    }

    @PostMapping("/editprofile/{profileId}")
    public ResponseEntity<Profile> edit(@PathVariable Long profileId, @RequestBody ProfileRequest request) {
        return ResponseEntity.ok(profileservice.edit(profileId, request));
    }

    @PostMapping("/getprofiles")
    public ResponseEntity<List<Profile>> get(@RequestBody Long UserId, HttpServletResponse response) {
        System.out.println("logging in3");
        return ResponseEntity.ok(profileservice.getProfiles(UserId));
    }
}
