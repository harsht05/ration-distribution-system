package com.ht.management.ration.distribution.repositories;

import com.ht.management.ration.distribution.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByRole(String role);

}
