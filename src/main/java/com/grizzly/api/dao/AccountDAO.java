package com.grizzly.api.dao;

import com.grizzly.api.model.Account;

import java.util.List;

/**
 * Represents the AccountDAO Interfaces, which is used for storing each and every individual request.
 * Provides specific data operations from the database without exposing details of the database.
 */
public interface AccountDAO {


    /**
     * Creates a new account with the provided information
     * @param username
     * @param email
     * @param roleId
     */
    void create(String username, String email, int roleId);

    /**
     * Retrieves the account with the specified name
     * @param username
     * @return the specified account object
     */
    Account get(String username);

    /**
     * Retrieves a list of all accounts
     * @return all accounts provided with their account object
     */
    List<Account> getAll();



}
