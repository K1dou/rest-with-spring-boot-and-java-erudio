package com.K1dou.restwithspringbootandjava.repository;

import com.K1dou.restwithspringbootandjava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
