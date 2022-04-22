package com.todd.trowbridge.ibex.interview.backend.repos;

import com.todd.trowbridge.ibex.interview.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository <User, Long> {
    User findByUserName(String userName);
}
