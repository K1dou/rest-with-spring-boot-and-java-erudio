package com.K1dou.restwithspringbootandjava.repository;

import com.K1dou.restwithspringbootandjava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM user WHERE u.userName =:userName")
    User findByUsername(@Param("userName")String userName);

}
