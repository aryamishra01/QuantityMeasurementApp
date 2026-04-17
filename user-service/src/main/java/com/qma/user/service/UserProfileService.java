package com.qma.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qma.user.dto.UserProfileRequest;
import com.qma.user.entity.UserProfile;
import com.qma.user.repository.UserProfileRepository;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile create(UserProfileRequest request) {
        UserProfile user = new UserProfile();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        return userProfileRepository.save(user);
    }

    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }

    public UserProfile getById(Long id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    public UserProfile update(Long id, UserProfileRequest request) {
        UserProfile user = userProfileRepository.findById(id).orElse(null);
        if (user == null) return null;

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        return userProfileRepository.save(user);
    }

    public void delete(Long id) {
        userProfileRepository.deleteById(id);
    }
}