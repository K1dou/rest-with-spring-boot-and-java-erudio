package com.K1dou.restwithspringbootandjava.service;

import com.K1dou.restwithspringbootandjava.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;




}
