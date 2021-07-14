package com.deerpointgroup.deerpointliquorstore.Roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;

public interface RolesRepository extends JpaRepository<Role, Long> {
}
