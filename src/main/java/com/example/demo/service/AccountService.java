package com.example.demo.service;

import com.example.demo.dto.request.AccountApiRequest;
import com.example.demo.entity.Account;
import com.example.demo.entity.Role;
import com.example.demo.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account saveAccount(AccountApiRequest accountApiRequest, String role) {
        Account account = new Account(
                accountApiRequest.getUserId(),
                accountApiRequest.getPassword(),
                accountApiRequest.getGender(),
                accountApiRequest.getNickName(),
                accountApiRequest.isAdAgree(),
                Role.valueOf(role)
        );
        return accountRepository.save(account);
    }

    public Account findUser() {

        //사용자 가지고 오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account accountId = (Account) authentication.getPrincipal();

        Optional<Account> account = accountRepository.findById(accountId.getId());
        return account.get();
    }
}
