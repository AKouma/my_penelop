package Dao;

import Modules.Contact;

import java.util.List;

public class ContactDao implements Idao<Contact> {

    @Override
    public Contact create() {
        return null;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return null;
    }

    @Override
    public List<Contact> findByCriteria(String criteria, Object value) {
        return null;
    }

    @Override
    public List<Contact> findById(Object id) {
        return null;
    }
}
