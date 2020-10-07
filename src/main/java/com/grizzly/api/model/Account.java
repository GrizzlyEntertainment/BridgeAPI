package com.grizzly.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Represents the Account Model
 * Utilized for specifying which types we would wish to display for an account request service.
 */
@Data
@RequiredArgsConstructor
public class Account {

    /**
     * Represents the MySQL `Primary Index` key id that self registered to this account.
     */
    @JsonProperty("id")
    private final long id;

    /**
     * Represents the username associated with this account
     */
    @JsonProperty("username")
    private final String username;

    /**
     * Represents the email associated with this account
     */
    @JsonProperty("email")
    private final String email;

    /**
     * Represents the Administration level of the account
     * 0 = Default
     * 1 = Moderator
     * 2 = Administrator
     */
    @JsonProperty("roleId")
    private final int roleId;

}
