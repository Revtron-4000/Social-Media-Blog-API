import Controller.SocialMediaController;
import io.javalin.Javalin;


// Delete later after testing
import Util.ConnectionUtil;
import DAO.AccountDAOImplementation;
import Model.Account;
import Service.AccountService;


/**
 * This class is provided with a main method to allow you to manually run and test your application. This class will not
 * affect your program in any way and you may write whatever code you like here.
 */
public class Main {
    public static void main(String[] args) {
        ConnectionUtil.resetTestDatabase();
        AccountDAOImplementation accountDAO = new AccountDAOImplementation();
        AccountService as = new AccountService();

        System.out.println(accountDAO.getAllAccounts());
        System.out.println();

        Account mrBig = as.createAccount(new Account("mr.big", "123451668"));
        System.out.println("THIS IS mrBig!!!!: " + mrBig);
        as.createAccount(new Account("mr.mid", "56789"));
        as.createAccount(new Account("mr.small", "12345"));
        as.createAccount(new Account("mr.x", "56789"));
        as.createAccount("mr.bigshot", "as14");

        System.out.println(as.getAllAccounts());
        System.out.println("TESTING AREA\n");
        System.out.println(accountDAO.getAccountByUsernameAndPassword("asfafaf", "alsfjlajflkajlkj"));
        System.out.println(accountDAO.getAccountByUsernameAndPassword("mr.big", "123451668"));


        


        // SocialMediaController controller = new SocialMediaController();
        // Javalin app = controller.startAPI();
        // app.start(8080);
    }
}
