package Dao;

import Modules.Groupe;
import Modules.Message;
import Modules.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static Utils.Constants.messageFilePathName;
import static Utils.Constants.userFilePathName;
import static Utils.FileManager.InsertIntoJson;

public class MessageDao implements Idao<Message> {

    private List<Message> messages;

    @Override
    public Message create(Message message) {
        if (message != null) {
            List<Object> messagesList = new ArrayList<>();
            messages = findAll();
            boolean isAlreadyExist = false;
            Iterator it = messages.iterator();
            while (it.hasNext() && !isAlreadyExist) {
                User current = (User) it.next();
                isAlreadyExist = current.equals(message);
            }
            if (!isAlreadyExist) {
                updateUserMessage(message);
                messages.add(message);
                messagesList.addAll(messages);
                InsertIntoJson(messagesList, messageFilePathName);
            }
        }
        return message;
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
    public Message findById(Object id) {
        return null;
    }

    private void updateUserMessage(Message message){
        List<User> users = message.getMessageSentTo();
        users.add(message.getMessageSender());
        UserDao userDao = new UserDao();
        for (User user : users) {
            List<Message> messages = new ArrayList<>();
            messages.add(message);
            user.setUserMessages(messages);
            userDao.update(user);
        }
    }
}
