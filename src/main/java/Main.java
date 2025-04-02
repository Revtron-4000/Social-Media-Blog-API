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
        // ConnectionUtil.resetTestDatabase();
        // AccountDAO accountDAO = new AccountDAOImplementation();
        // AccountService as = new AccountService();
        // MessageDAO messageDAO = new MessageDAOImplementation();
        // MessageService ms = new MessageService();

        // System.out.println(messageDAO.getAllMessages());
        // System.out.println(messageDAO.insertMessage(new Message(1, "Hello there", 2341252L)));
        // System.out.println(messageDAO.getAllMessages());

        // System.out.println("TESTING AREA\n");        
        // ms.postMessage(new Message(1, "ep1qlojgfiqexlfxrpeghmwdmiwhfyazltanwpphjsfilndtxsuuqspsozjxjgazommmtoiasojawudvreprjxkcnlsspwkaizrmmxotgjgzqsobcjtfuquwjmrervaeikkjzyctifemllaukpitapbkbqzkglihitmikemoskfjtisaxglxeuushrsnsbkkintzgywmrgiiwlqnbmnexudpvebhyboucctziarqqvmbpukhchkcazrluqlehfr", 2341252L));
        // ms.postMessage(new Message(1, "sfasf", 12314L));
        // System.out.println(messageDAO.getAllMessages());
        // System.out.println();

        // System.out.println("Testing updateMessageById\n");
        // System.out.println(ms.getMessageById(3));
        // System.out.println(ms.updateMessageById(3, "Shorter message"));
        // System.out.println(ms.getAllMessages());
        // System.out.println();
        // System.out.println(ms.updateMessageById(10, "What's up everyone?"));
        // System.out.println(ms.getAllMessages());
        // System.out.println();
        // System.out.println(ms.updateMessageById(1, ""));
        // System.out.println(ms.getAllMessages());
        // System.out.println();
        // System.out.println(ms.updateMessageById(1, "                "));
        // System.out.println(ms.getAllMessages());
        // System.out.println();
        // System.out.println(ms.updateMessageById(1, "onxoulqglsvobqvzotqowokqxsvshrzsrrxysmlbydqrekplsneuzyxxjtflbhmdtvgqxcafxjlpmcfzewyawjthjgzqpnlskgxsmvlozavdrqerlbjuylmmynwlebszazmvlbaqjmyyhqdwkcsaczlxfszwuighadnhgksoxjnkcstzcmtrpzvgjqzqlmembvsdaathnhtbbxoospxlkjkfrjtieovytqmewmnswnyjsynoupgidkqrrnfdtyx"));
        // System.out.println(ms.getAllMessages());
        // System.out.println();
        // System.out.println(ms.updateMessageById(1, "9onxoulqglsvobqvzotqowokqxsvshrzsrrxysmlbydqrekplsneuzyxxjtflbhmdtvgqxcafxjlpmcfzewyawjthjgzqpnlskgxsmvlozavdrqerlbjuylmmynwlebszazmvlbaqjmyyhqdwkcsaczlxfszwuighadnhgksoxjnkcstzcmtrpzvgjqzqlmembvsdaathnhtbbxoospxlkjkfrjtieovytqmewmnswnyjsynoupgidkqrrnfdtyx"));
        // System.out.println(ms.getAllMessages());
        // System.out.println();

        // System.out.println();

    
        


        SocialMediaController controller = new SocialMediaController();
        Javalin app = controller.startAPI();
        app.start(8080);
    }
}
