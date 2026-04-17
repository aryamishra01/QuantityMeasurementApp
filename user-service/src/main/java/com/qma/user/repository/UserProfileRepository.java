package com.qma.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qma.user.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}