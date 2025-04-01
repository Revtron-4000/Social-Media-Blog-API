package Service;

import DAO.AccountDAO;
import DAO.AccountDAOImplementation;
import DAO.MessageDAO;
import DAO.MessageDAOImplementation;
import Model.Message;

public class MessageService {
    MessageDAO messageDAO = new MessageDAOImplementation();
    AccountDAO accDAO = new AccountDAOImplementation();

    public Message postMessage(Message m) {
        int accountId = m.getPosted_by();
        
        if (accDAO.getAccountById(accountId) == null || m.getMessage_text().length() > 255 || m.getMessage_text().isBlank()) {
            return null;
        }
        
        return messageDAO.insertMessage(m);
    }
}
