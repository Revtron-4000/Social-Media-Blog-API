package DAO;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

import Model.Message;
import Util.ConnectionUtil;

public class MessageDAOImplementation implements MessageDAO {
    @Override
    public List<Message> getAllMessages() {
        Connection conn = ConnectionUtil.getConnection();
        List<Message> messages = new ArrayList<>();

        try {
            String sql = "SELECT * FROM message";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Message m = new Message(rs.getInt("message_id"),
                rs.getInt("posted_by"),
                rs.getString("message_text"),
                rs.getLong("time_posted_epoch")
                );

                messages.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    @Override
    public Message insertMessage(Message m) {
        Connection conn = ConnectionUtil.getConnection();

        try {
            String sql = "INSERT INTO message(posted_by, message_text, time_posted_epoch) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, m.getPosted_by());
            ps.setString(2, m.getMessage_text());
            ps.setLong(3, m.getTime_posted_epoch());

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();

            while (generatedKeys.next()) {
                int generatedMessageId = generatedKeys.getInt("message_id");

                return new Message(generatedMessageId, m.getPosted_by(), m.getMessage_text(), m.getTime_posted_epoch());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
