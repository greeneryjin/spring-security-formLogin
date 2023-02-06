package com.example.demo.controller;

import com.example.demo.dto.request.AccountApiRequest;
import com.example.demo.entity.Role;
import com.example.demo.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountApiController {

    private final AccountService accountService;

    @PostMapping("/save")
    public String saveAccount(@RequestBody AccountApiRequest accountApiRequest){

        String role = Role.USER.getGrantedAuthority();
        accountService.saveAccount(accountApiRequest, role);
        return "signUp success!";
    }

    //로그인
    @GetMapping("/login")
    public void signInAccount(){ }
}
