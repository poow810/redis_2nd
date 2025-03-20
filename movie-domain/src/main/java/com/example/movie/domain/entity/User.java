package com.example.movie.domain.entity;

import com.example.movie.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @Builder
    public User(String userName) {
        this.userName = userName;
    }
}
