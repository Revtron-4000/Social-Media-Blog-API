package DAO;

import java.util.List;

import Model.Message;

public interface MessageDAO {
    public List<Message> getAllMessages();
    public Message insertMessage(Message m);
}
