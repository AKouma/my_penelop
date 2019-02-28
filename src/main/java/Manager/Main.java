package Manager;

import Dao.UserDao;
import Modules.Message;
import Modules.User;
import Utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Object> groupes = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        UserDao userDao = new UserDao();
        User userToCreate = new User();
        userToCreate.setMatricule("fqshfgvaaaatyufgf");
        userToCreate.setUserProfil("developpeur");
        userToCreate.setUserpassword("passworddexter1111");
        userToCreate.setUserName("BENONI");
        userToCreate.setUserMail("elbacar08@gmail.com");
        userToCreate.setUserLogin("DEX");
        userToCreate.setUserFirstname("DEXTER");
        userToCreate.setUserContatcs(null);
        userToCreate.setUserBirth("16/02/1993");
        userToCreate.setUpdateDate(null);
        userToCreate.setIdGroup(3);
        userToCreate.setDeleteDate(null);
        userToCreate.setDeleted(false);
        userToCreate.setCreationDate(DateUtils.getDate(new Date()));
        userToCreate.setUserMessages(null);

        User user = userDao.findById("");
        System.out.println(user);
        //FileManager.InsertIntoJson(groupes, userFilePathName);
        //List<User> users = userDao.findAll();
        /*for (Object user :  users) {
           System.out.println(user.toString());
        }*/
    }
}
