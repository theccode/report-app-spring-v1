package com.reporter.reportapp.account;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/report/accounts")
@AllArgsConstructor
@CrossOrigin
public class AccountController {

    private final  AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAccountOwners(){
        List<Account> accounts = accountService.getAccountOwners();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
