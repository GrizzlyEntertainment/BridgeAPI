package com.grizzly.api.dao;

import com.grizzly.api.model.Account;

import java.util.List;
import java.util.UUID;

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
    void create(final String username, final String email, final int roleId);

    /**
     * Retrieves the account within the specified UUID
     * @param uuid
     * @return the specified account object
     */
    Account get(UUID uuid);

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
