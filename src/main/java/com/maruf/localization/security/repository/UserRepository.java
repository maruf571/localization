package com.maruf.localization.security.repository;

import com.maruf.localization.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value =
            "SELECT u FROM " +
                    " User u " +
                    " WHERE " +
                    " u.email=?1")
    Optional<User> findByEmail(String email);
}
