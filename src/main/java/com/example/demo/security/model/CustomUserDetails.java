package com.example.demo.security.model;

import com.example.demo.entity.Account;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CustomUserDetails extends User {
    private Account account;
    private List<String> roles;

    public CustomUserDetails(Account account, List<GrantedAuthority> roles) {
        super(account.getUserId(), account.getPassword(), roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        this.account = account;
        this.roles = roles;
    }
    public String getEmail() {
        return account.getUserId();
    }
}
