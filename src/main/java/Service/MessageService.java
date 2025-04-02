package Service;

import java.util.List;

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

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Message getMessageById(int message_id) {
        return messageDAO.getMessageById(message_id);
    }

    public Message deleteMessageById(int message_id) {
        return messageDAO.deleteMessageById(message_id);
    }

    public Message updateMessageById(int message_id, String newMessage) {
        if (getMessageById(message_id) == null || newMessage.isBlank() || newMessage.length() > 255) {
            return null;
        }

        return messageDAO.updateMessageById(message_id, newMessage);
    }
}
