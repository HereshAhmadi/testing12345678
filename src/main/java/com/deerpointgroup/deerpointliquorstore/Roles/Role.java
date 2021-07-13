package com.deerpointgroup.deerpointliquorstore.Roles;
import javax.persistence.*;
import com.deerpointgroup.deerpointliquorstore.user.User;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "role")
    private Collection<User> users;

    public Role(){}

    public Role(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}