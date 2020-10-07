package com.grizzly.api.controller;

import com.grizzly.api.model.Account;
import com.grizzly.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/account")
public class AccountController {


    /**
     * Represents the Account Service for Controller
     */
    private final AccountService accountService;


    /**
     * Creates a constructor using Dep Injecting for the beans to initialize.
     * @param accountService
     */
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    /**
     * Represents the Request for Account Creation
     * @param account
     */
    @PostMapping
    public void createAccount(@RequestBody Account account) {
        System.out.println("Incoming Create Account Request: " + account.toString());
        accountService.getAccountDAO().create(account.getUsername(), account.getEmail(), account.getRoleId());
    }

    /**
     * The Request for fetching all accounts
     * @return a list of all accounts
     */
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAccountDAO().getAll();
    }

    /**
     * The Request for fetching a single account object
     * @param username
     * @return the selected account with the provided username
     */
    @GetMapping(path = "{username}")
    public Account getAccount(@PathVariable("username") String username) {
        return accountService.getAccountDAO().get(username).orElse(null);
    }

}
