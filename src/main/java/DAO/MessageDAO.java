package DAO;

import java.util.List;

import Model.Message;

public interface MessageDAO {
    public List<Message> getAllMessages();
    public Message getMessageById(int message_id);
    public Message insertMessage(Message m);
    public Message deleteMessageById(int message_id);
}
