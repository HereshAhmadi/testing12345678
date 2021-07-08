package com.deerpointgroup.deerpointliquorstore.security;

import com.google.common.collect.Sets;
import java.util.Set;
import static com.deerpointgroup.deerpointliquorstore.security.UserPermission.*;

public enum UserRole {
    CUSTOMER(Sets.newHashSet(USER_READ, USER_WRITE, PRODUCT_READ)),
    EMPLOYEE(Sets.newHashSet(USER_READ, USER_WRITE, PRODUCT_READ)),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE, PRODUCT_READ,PRODUCT_WRITE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions){
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions(){
        return permissions;
    }
}
