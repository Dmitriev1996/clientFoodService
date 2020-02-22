package com.service.clientFoodService.daos;

import com.service.clientFoodService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

/**
 * Created by Admin on 18.02.2020.
 */
public interface UserDAO extends JpaRepository<User, Long> {

    @Query("select user from User user where user.login = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
