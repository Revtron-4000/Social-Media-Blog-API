package DAO;

import java.util.List;

import Model.Account;

public interface AccountDAO {
    public List<Account> getAllAccounts();
    public Account getAccountByUsername(String username);
    public Account getAccountByUsernameAndPassword(String username, String password);
    public Account insertAccount(Account acc);

}
