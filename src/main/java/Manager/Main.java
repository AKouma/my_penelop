package Manager;

import Dao.GroupeDao;
import Dao.MessageDao;
import Dao.UserDao;
import Modules.Groupe;
import Modules.Message;
import Modules.User;
import Utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Utils.DateUtils.getDate;

public class Main {

    public static void main(String[] args) {
        List<Object> groupes = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        List<User> users = new ArrayList<>();
        UserDao userDao = new UserDao();
        User userToCreate = new User();
        userToCreate.setMatricule("uezgfygure");
        userToCreate.setUserProfil("developpeur");
        userToCreate.setUserpassword("lili");
        userToCreate.setUserName("LILIANE");
        userToCreate.setUserMail("elbacar08@gmail.com");
        userToCreate.setUserLogin("DEX");
        userToCreate.setUserFirstname("LILI");
        userToCreate.setUserContatcs(null);
        userToCreate.setUserBirth("16/02/1993");
        userToCreate.setUpdateDate(null);
        userToCreate.setIdGroup(3);
        userToCreate.setDeleteDate(null);
        userToCreate.setDeleted(false);
        userToCreate.setCreationDate(getDate(new Date()));
        userToCreate.setUserMessages(null);

        GroupeDao groupeDao = new GroupeDao();
        Groupe groupe = new Groupe();
        groupe.setIdGroup(1);
        groupe.setUpdateDate(null);
        groupe.setPrivilege("admin");
        groupe.setHasChief(false);
        groupe.setGroupName("administrateurs");
        groupe.setGroupChief(null);
        groupe.setDeleteDate(null);
        groupe.setDeleted(false);
        groupe.setCreationDate(getDate(new Date()));


        Message message = new Message();
        users.add(userToCreate);
        message.setIdMessage(1);
        message.setMessageText("ceci est un test");
        message.setRead(false);
        message.setMessageSentTo(users);
        message.setMessageSender(userToCreate);
        message.setMessageobject("test");
        message.setMessageDate(getDate(new Date()));
        message.setDeleteDate(null);
        message.setDeleted(false);
        message.setCreationDate(getDate(new Date()));
        message.setUpdateDate(null);

        Groupe groupe1 = groupeDao.findById(2);
        //System.out.println(groupe1);

        User user = userDao.create(userToCreate);
        //System.out.println(user);

        MessageDao messageDao = new MessageDao();
        Message message1 = messageDao.create(message);
        //System.out.println(message1);
        //FileManager.InsertIntoJson(groupes, userFilePathName);
        //List<User> users = userDao.findAll();
        /*for (Object user :  users) {
           System.out.println(user.toString());
        }*/
    }
}
