package Service;

import java.util.List;

import DAO.AccountDAO;
import DAO.AccountDAOImplementation;
import Model.Account;

public class AccountService {
    private AccountDAO accDAO;

    public AccountService() {
        accDAO = new AccountDAOImplementation();
    }

    /*
     * The registration will be successful if and only if 
     * the username is not blank, 
     * the password is at least 4 characters long, 
     * and an Account with that username does not already exist. 
     */
    public Account createAccount(String username, String password) {
        if (username.isEmpty() || password.length() < 4 || accDAO.getAccountByUsername(username) != null) {
            return null;
        }
        return accDAO.insertAccount(new Account(username, password));
    }

    public Account createAccount(Account acc) {
        if (acc.getUsername().isEmpty() || acc.getPassword().length() < 4 || accDAO.getAccountByUsername(acc.getUsername()) != null) {
            return null;
        }
        return accDAO.insertAccount(acc);
    }

    public List<Account> getAllAccounts() {
        return accDAO.getAllAccounts(); 
    }
}
