package Dao;

import Modules.Groupe;

import java.util.List;

public class GroupeDao implements Idao<Groupe> {

    private static final String fileName = "Groupe.json";

    @Override
    public Groupe create() {
        return null;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public Groupe update(Groupe groupe) {
        return null;
    }

    @Override
    public List<Groupe> findAll() {
        return null;
    }

    @Override
    public List<Groupe> findByCriteria(String criteria, Object value) {
        return null;
    }

    @Override
    public List<Groupe> findById(Object id) {
        return null;
    }
}
