package com.example.auth_service.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private Long user_id;

    @Column(nullable = false, unique = false)
    private String name;

    public Long getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(Long avatar) {
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    @Column(nullable = false)
    private Long avatar;

}
