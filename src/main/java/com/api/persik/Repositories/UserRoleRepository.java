package com.api.persik.Repositories;

import com.api.persik.Models.Entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole getUserRoleById(Integer id);
}