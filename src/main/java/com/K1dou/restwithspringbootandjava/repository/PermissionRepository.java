package com.K1dou.restwithspringbootandjava.repository;

import com.K1dou.restwithspringbootandjava.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
