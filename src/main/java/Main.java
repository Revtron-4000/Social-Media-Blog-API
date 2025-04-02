import Controller.SocialMediaController;
import io.javalin.Javalin;


// Delete later after testing
import Util.ConnectionUtil;
import DAO.AccountDAO;
import DAO.AccountDAOImplementation;
import DAO.MessageDAO;
import DAO.MessageDAOImplementation;

import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;


/**
 * This class is provided with a main method to allow you to manually run and test your application. This class will not
 * affect your program in any way and you may write whatever code you like here.
 */
public class Main {
    public static void main(String[] args) {
        ConnectionUtil.resetTestDatabase();
        AccountDAO accountDAO = new AccountDAOImplementation();
        AccountService as = new AccountService();
        MessageDAO messageDAO = new MessageDAOImplementation();
        MessageService ms = new MessageService();


        ms.postMessage(new Message(1, "Hello there", 2341252L));
        ms.postMessage(new Message(1, "shorter message", 2341252L));
        ms.postMessage(new Message(1, "sfasf", 12314L));
        System.out.println(ms.getAllMessages());

        as.createAccount(new Account("mr.big", "1231"));
        ms.postMessage(new Message(2, "I'm Mr.Big", 123111L));
        ms.postMessage(new Message(2, "The world is a big place!", 123111131L));


        System.out.println("Testing getAccountMessages\n");
        System.out.println(as.getAllAccounts());
        System.out.println();
        System.out.println(ms.getAllMessages());
        System.out.println();
        System.out.println("These are all the messages posted by testuser1: \n" + messageDAO.getAccountMessages(1));
        System.out.println();
        System.out.println("These are all the messages posted by mr.big: \n" + messageDAO.getAccountMessages(2));

        
        


        // SocialMediaController controller = new SocialMediaController();
        // Javalin app = controller.startAPI();
        // app.start(8080);
    }
}
