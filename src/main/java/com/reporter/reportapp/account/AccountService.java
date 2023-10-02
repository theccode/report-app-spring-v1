package com.reporter.reportapp.account;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountDataService accountDataService;
    public List<Account> getAccountOwners() {
        return accountDataService.getAccountOwners();
    }
}
