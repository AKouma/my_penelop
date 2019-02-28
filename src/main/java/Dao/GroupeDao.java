package Dao;

import Modules.Groupe;
import Modules.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static Utils.Constants.groupeFilePathName;
import static Utils.Constants.userFilePathName;
import static Utils.FileManager.InsertIntoJson;
import static Utils.FileManager.getFromJson;

public class GroupeDao implements Idao<Groupe> {

    private List<Groupe> groupes;

    @Override
    public Groupe create(Groupe groupe) {
        if (groupe != null) {
            List<Object> groupeList = new ArrayList<>();
            groupes = findAll();
            boolean isAlreadyExist = false;
            Iterator it = groupes.iterator();
            while (it.hasNext() && !isAlreadyExist) {
                Groupe current = (Groupe) it.next();
                isAlreadyExist = current.equals(groupe);
            }
            if (!isAlreadyExist) {
                groupes.add(groupe);
                groupeList.addAll(groupes);
                InsertIntoJson(groupeList, groupeFilePathName);
            }
        }
        return groupe;
    }

    @Override
    public boolean delete(Groupe groupe) {
        return false;
    }

    @Override
    public Groupe update(Groupe groupe) {
        if (groupe != null) {
            List<Object> groupList = new ArrayList<>();
            groupes = findAll();
            Iterator it = groupes.iterator();
            boolean isFoundAndUpdate = false;
            while (it.hasNext() && !isFoundAndUpdate) {
                Groupe current = (Groupe) it.next();
                isFoundAndUpdate = current.equals(groupe);
                if (isFoundAndUpdate) {
                    it.remove();
                }
            }
            if (isFoundAndUpdate) {
                groupes.add(groupe);
                groupList.addAll(groupes);
                InsertIntoJson(groupList, groupeFilePathName);
            } else {
                groupe = null;
            }
        }
        return groupe;
    }

    @Override
    public List<Groupe> findAll() {
        groupes = new ArrayList<>();
        List<Object> objects = getFromJson(groupeFilePathName, new Groupe());
        Iterator it = objects.iterator();
        while (it.hasNext()) {
            Object ob = it.next();
            if (ob instanceof Groupe) {
                groupes.add((Groupe) ob);
            }
        }
        return groupes;
    }

    @Override
    public List<Groupe> findByCriteria(String criteria, Object value) {
        return null;
    }

    @Override
    public Groupe findById(Object id) {
        return null;
    }
}
