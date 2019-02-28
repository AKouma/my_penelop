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
        User userToCreate = User.getInstance();
        userToCreate.setMatricule("fqshfgvqgufgf");
        userToCreate.setUserProfil("developpeur");
        userToCreate.setUserpassword("password");
        userToCreate.setUserName("KOUMARE");
        userToCreate.setUserMail("elbacar08@gmail.com");
        userToCreate.setUserLogin("AKouma");
        userToCreate.setUserFirstname("Aboubacar");
        userToCreate.setUserContatcs(null);
        userToCreate.setUserBirth("16/02/1993");
        userToCreate.setUpdateDate(null);
        userToCreate.setIdGroup(3);
        userToCreate.setDeleteDate(null);
        userToCreate.setDeleted(false);
        userToCreate.setCreationDate(DateUtils.getDate(new Date()));
        userToCreate.setUserMessages(null);

        userDao.create(userToCreate);
        //System.out.println(userDao.create(userToCreate));
        //FileManager.InsertIntoJson(groupes, userFilePathName);
        //List<User> users = userDao.findAll();
        /*for (Object user :  users) {
           System.out.println(user.toString());
        }*/
    }
}
