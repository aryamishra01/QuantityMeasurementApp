package com.qma.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.qma.user.dto.UserProfileRequest;
import com.qma.user.entity.UserProfile;
import com.qma.user.service.UserProfileService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserProfileService userProfileService;

    public UserController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<UserProfile> create(@Validated @RequestBody UserProfileRequest request) {
        return ResponseEntity.ok(userProfileService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<UserProfile>> getAll() {
        return ResponseEntity.ok(userProfileService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userProfileService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> update(@PathVariable Long id,
                                              @Validated @RequestBody UserProfileRequest request) {
        return ResponseEntity.ok(userProfileService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userProfileService.delete(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}