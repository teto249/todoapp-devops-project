package com.devsuatt.todoApp.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String username;
    private String password;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Task> tasks = new HashSet<>();

    public User(String username, String password) {
        this.id = "";
        this.username = username;
        this.password = password;
        this.tasks = new HashSet<>();
    }
    
    public User(String id, String username, String password, Set<Task> tasks) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tasks = tasks != null ? tasks : new HashSet<>();
    }
}
