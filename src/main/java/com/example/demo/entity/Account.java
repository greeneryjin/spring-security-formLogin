package com.example.demo.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"userRoles","boards"})
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    private String nickName;
    private boolean adAgree;

    @Enumerated(EnumType.STRING)
    private Role userRoles;

    public Account(String userId, String password, GenderEnum gender, String nickName, boolean adAgree, Role userRoles) {
        this.userId = userId;
        this.password = password;
        this.gender = gender;
        this.nickName = nickName;
        this.adAgree = adAgree;
        this.userRoles = userRoles;
    }
}
