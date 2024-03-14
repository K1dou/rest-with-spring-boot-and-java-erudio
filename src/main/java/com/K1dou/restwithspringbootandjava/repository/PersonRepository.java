package com.K1dou.restwithspringbootandjava.repository;

import com.K1dou.restwithspringbootandjava.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long>{
}
