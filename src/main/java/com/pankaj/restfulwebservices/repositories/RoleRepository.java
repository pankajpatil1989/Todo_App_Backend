package com.pankaj.restfulwebservices.repositories;

import com.pankaj.restfulwebservices.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
