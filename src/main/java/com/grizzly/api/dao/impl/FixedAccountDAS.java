package com.grizzly.api.dao.impl;

import com.grizzly.api.dao.AccountDAO;
import com.grizzly.api.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents the class for the 'Data Access Service'
 * Utilized for accessing our data, and process it for the appropriate request.
 */
@Repository("FixedDAO")
public class FixedAccountDAS implements AccountDAO {

    /**
     * Represents a list of all instanced accounts
     */
    private static final ArrayList<Account> accounts = new ArrayList<>();


    /**
     * Creates a new account with the provided information
     *
     * @param username
     * @param email
     * @param roleId
     */
    @Override
    public void create(String username, String email, int roleId) {
        Account account = new Account(1, username, email, roleId);//TODO result for the account will be the uuid
        accounts.add(account);
        System.out.println("Successfully created account: " + account.toString());
    }

    /**
     * Retrieves the account with the specified name
     *
     * @param username
     * @return the specified account object
     */
    @Override
    public Account get(String username) {
        return accounts.stream().filter(account -> account.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
    }

    /**
     * Retrieves a list of all accounts
     *
     * @return all accounts provided with their account object
     */
    @Override
    public List<Account> getAll() {
        return accounts;
    }
}
