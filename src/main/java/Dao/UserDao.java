package Dao;

import Modules.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static Utils.Constants.userFilePathName;
import static Utils.FileManager.InsertIntoJson;
import static Utils.FileManager.getFromJson;

public class UserDao implements Idao<User> {

    private List<User> users;
    private User user = User.getInstance();

    @Override
    public User create(User user) {
        List<Object> userList = new ArrayList<>();
        users = findAll();
        users.add(user);
        userList.addAll(users);
        InsertIntoJson(userList,userFilePathName);
        return user;
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
        users = new ArrayList<>();
        List<Object> objects = getFromJson(userFilePathName, user);
        Iterator it = objects.iterator();
        while (it.hasNext()){
            Object ob = it.next();
            if(ob instanceof User){
                users.add((User) ob);
            }
        }
        return users;
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
