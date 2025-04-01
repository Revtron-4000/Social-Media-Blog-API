package DAO;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import Util.ConnectionUtil;
import Model.Account;


public class AccountDAOImplementation implements AccountDAO {
    public List<Account> getAllAccounts() {
        Connection conn = ConnectionUtil.getConnection();
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM account";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Account acc = new Account(rs.getInt("account_id"), 
                rs.getString("username"), 
                rs.getString("password")
                );

                accounts.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    /*
     * Only 1 username will be returned because of the 'account' table's username column has the UNIQUE constraint
     */
    @Override
    public Account getAccountByUsername(String username) {
        Connection conn = ConnectionUtil.getConnection();
        try {
            String sql = "SELECT * FROM account WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("account_id"), 
                rs.getString("username"), 
                rs.getString("password")
                );
                
                return acc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getAccountByUsernameAndPassword(String username, String password) {
        Connection conn = ConnectionUtil.getConnection();

        try {
            String sql = "SELECT * FROM account WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Account acc = new Account(rs.getInt("account_id"), 
                rs.getString("username"), 
                rs.getString("password")
                );

                return acc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Account insertAccount(Account acc) {
        Connection conn = ConnectionUtil.getConnection();

        String sql = "INSERT INTO account(username, password) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedAccountId = generatedKeys.getInt("account_id");
                return new Account(generatedAccountId, acc.getUsername(), acc.getPassword());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
