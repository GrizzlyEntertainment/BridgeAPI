package com.grizzly.api.service;

import com.grizzly.api.dao.AccountDAO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Represents the Service used for distributing requests to the DAO.
 */
@Service
public class AccountService {

    /**
     * Represents the Account DAO associated with this Service
     */
    @Getter
    private final AccountDAO accountDAO;

    /**
     * Initializes the Account Service using the {@link AccountDAO} that utilizes the {@link org.springframework.stereotype.Component} name "FixedDAO"
     * @param accountDAO
     */
    @Autowired
    public AccountService(@Qualifier("Postgres") final AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }



}
