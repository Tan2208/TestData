package com.example.TestData.repository;

import com.example.TestData.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository  extends JpaRepository<Permission, String> {

}
