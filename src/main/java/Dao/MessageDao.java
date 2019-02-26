package Dao;

import Modules.Message;

import java.util.List;

public class MessageDao implements Idao<Message> {

    private static final String fileName = "Message.json";

    @Override
    public Message create() {
        return null;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public Message update(Message message) {
        return null;
    }

    @Override
    public List<Message> findAll() {
        return null;
    }

    @Override
    public List<Message> findByCriteria(String criteria, Object value) {
        return null;
    }

    @Override
    public List<Message> findById(Object id) {
        return null;
    }
}
