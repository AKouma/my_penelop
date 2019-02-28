package Dao;

import Modules.Message;
import Modules.User;

import java.util.List;

public class MessageDao implements Idao<Message> {

    @Override
    public Message create(Message message) {
        return null;
    }

    @Override
    public boolean delete(Message message) {
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
