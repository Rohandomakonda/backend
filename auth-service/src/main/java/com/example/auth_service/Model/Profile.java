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
    private Long name;

    @Column(nullable = false)
    private String avatar;

}
