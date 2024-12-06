package com.springDev.repositaries;

import com.springDev.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositary extends JpaRepository<User,Long> {

     User findByUserName(String username);
}
