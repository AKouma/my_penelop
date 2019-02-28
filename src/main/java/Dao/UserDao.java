package Dao;

import Modules.Contact;
import Modules.User;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static Utils.Constants.userFilePathName;
import static Utils.FileManager.InsertIntoJson;
import static Utils.FileManager.getFromJson;

public class UserDao implements Idao<User> {

    private List<User> users;
    // private User user = User.getInstance();

    @Override
    public User create(User user) {
        if (user != null) {
            List<Object> userList = new ArrayList<>();
            users = findAll();
            boolean isAlreadyExist = false;
            Iterator it = users.iterator();
            while (it.hasNext() && !isAlreadyExist) {
                User current = (User) it.next();
                isAlreadyExist = current.equals(user);
            }
            if (!isAlreadyExist) {
                updateContac(user);
                users.add(user);
                userList.addAll(users);
                InsertIntoJson(userList, userFilePathName);
            }
        }
        return user;
    }

    @Override
    public boolean delete(User user) {
        if (user != null) {
            user.setDeleted(true);
            List<Object> userList = new ArrayList<>();
            users = findAll();
            //users.add(user);
            users.remove(user); //if we decide to delete definitively
            userList.addAll(users);
            InsertIntoJson(userList, userFilePathName);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User update(User user) {
        if (user != null) {
            List<Object> userList = new ArrayList<>();
            users = findAll();
            Iterator it = users.iterator();
            boolean isFoundAndUpdate = false;
            while (it.hasNext() && !isFoundAndUpdate) {
                User current = (User) it.next();
                isFoundAndUpdate = current.equals(user);
                if (isFoundAndUpdate) {
                    it.remove();
                }
            }
            if (isFoundAndUpdate) {
                users.add(user);
                updateContac(user);
                userList.addAll(users);
                InsertIntoJson(userList, userFilePathName);
            } else {
                user = null;
            }
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        users = new ArrayList<>();
        List<Object> objects = getFromJson(userFilePathName, new User());
        Iterator it = objects.iterator();
        while (it.hasNext()) {
            Object ob = it.next();
            if (ob instanceof User) {
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
    public User findById(Object id) {
        if (id instanceof String) {
            List<Object> userList = new ArrayList<>();
            users = findAll();
            Iterator it = users.iterator();
            boolean isFoundAndUpdate = false;
            while (it.hasNext() && !isFoundAndUpdate) {
                User current = (User) it.next();
                isFoundAndUpdate = id.equals(current.getMatricule());
                if (isFoundAndUpdate) {
                    return current;
                }
            }
        }
        return null;
    }

    private void updateContac(User user){
        ContactDao contactDao = new ContactDao();
        if(user.getUserContatcs() != null && !user.getUserContatcs().isEmpty()){
            for (Contact contact : user.getUserContatcs()) {
                contactDao.create(contact);
            }
        }
    }
}
