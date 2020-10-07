package com.grizzly.api.dao.impl;

import com.grizzly.api.APIConfiguration;
import com.grizzly.api.dao.AccountDAO;
import com.grizzly.api.model.Account;
import com.grizzly.api.utilities.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("Postgres")
public class PostgresAccountDAS implements AccountDAO {

    /**
     * Represents the JDBC Template, Spring Boot Connector to a Datasource.
     */
    private final JdbcTemplate jdbcTemplate;

    /**
     * Wires the JDBCTemplate to be dep injected  for the Postgres DAS
     *  and instantiates a new PostgresAccountDAS instance.
     * @param jdbcTemplate
     */
    @Autowired
    public PostgresAccountDAS(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Creates a new account with the provided information
     *
     * @param username
     * @param email
     * @param roleId
     */
    @Override
    public void create(final String username, final String email, final int roleId) {
        final StringBuilder sql = new StringBuilder();
        final String uuid = UUID.randomUUID().toString();

        sql.append("INSERT INTO accounts (id, username, email, role_id) ").append(SQLUtils.formatObjectsToValues(uuid, username, email, roleId));
        jdbcTemplate.execute(sql.toString());

        if (APIConfiguration.DEBUG_MODE)
            System.out.println("Successfully created a new Account(Id=" + uuid + ", Username=" + username + ", Email=" + email + ", RoleId=" + roleId + ")");

    }

    /**
     * Retrieves the account within the specified UUID
     *
     * @param uuid
     * @return the specified account object
     */
    @Override
    public Account get(final UUID uuid) throws EmptyResultDataAccessException {
        final String sql = "SELECT * FROM accounts WHERE id= ?";
        final Account account = jdbcTemplate.queryForObject(sql, new Object[] { uuid }, (resultSet, i)
                -> new Account(UUID.fromString(resultSet.getString("id")), resultSet.getString("username"), resultSet.getString("email"), resultSet.getInt("role_id")));
        return Optional.ofNullable(account).orElseThrow(() -> new EmptyResultDataAccessException(String.format("Account with the specified UUID `%s` was not found.", uuid), 1));
    }

    /**
     * Retrieves the account with the specified name
     *
     * @param username
     * @return the specified account object
     */
    @Override
    public Account get(final String username) throws EmptyResultDataAccessException {
        final String sql = "SELECT * FROM accounts WHERE username= ?";
        final Account account = jdbcTemplate.queryForObject(sql, new Object[] { username }, (resultSet, i)
                -> new Account(UUID.fromString(resultSet.getString("id")), resultSet.getString("username"), resultSet.getString("email"), resultSet.getInt("role_id")));
        return Optional.ofNullable(account).orElseThrow(() -> new EmptyResultDataAccessException(String.format("Account with the specified username `%s` was not found.", username), 1));
    }

    /**
     * Retrieves a list of all accounts
     *
     * @return all accounts provided with their account object
     */
    @Override
    public List<Account> getAll() {
        final String query = "SELECT * FROM accounts";
        return jdbcTemplate.query(query, (resultSet, i) ->
                new Account(UUID.fromString(resultSet.getString("id")), resultSet.getString("username"), resultSet.getString("email"), resultSet.getInt("role_id")));
    }
}
