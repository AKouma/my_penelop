package Dao;

import Modules.User;

import java.util.List;

public class UserDao implements Idao<User> {

    @Override
    public User create() {
        return null;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findByCriteria(String criteria, Object value) {
        return null;
    }

    @Override
    public List<User> findById(Object id) {
        return null;
    }
}
