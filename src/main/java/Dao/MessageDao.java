package Dao;

import Modules.Message;
import Modules.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static Utils.Constants.messageFilePathName;
import static Utils.FileManager.InsertIntoJson;
import static Utils.FileManager.getFromJson;

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
                Message current = (Message) it.next();
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
        if (message != null) {
            message.setDeleted(true);
            List<Object> messagesList = new ArrayList<>();
            messages = findAll();
            //users.add(user);
            messages.remove(message); //if we decide to delete definitively
            messagesList.addAll(messages);
            InsertIntoJson(messagesList, messageFilePathName);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Message update(Message message) {
        if (message != null) {
            List<Object> messageList = new ArrayList<>();
            messages = findAll();
            Iterator it = messages.iterator();
            boolean isFoundAndUpdate = false;
            while (it.hasNext() && !isFoundAndUpdate) {
                Message current = (Message) it.next();
                isFoundAndUpdate = current.equals(message);
                if (isFoundAndUpdate) {
                    it.remove();
                }
            }
            if (isFoundAndUpdate) {
                messages.add(message);
                updateUserMessage(message);
                messageList.addAll(messages);
                InsertIntoJson(messageList, messageFilePathName);
            } else {
                message = null;
            }
        }
        return message;
    }

    @Override
    public List<Message> findAll() {
        messages = new ArrayList<>();
        List<Object> objects = getFromJson(messageFilePathName, new Message());
        Iterator it = objects.iterator();
        while (it.hasNext()) {
            Object ob = it.next();
            if (ob instanceof Message) {
                messages.add((Message) ob);
            }
        }
        return messages;
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
        UserDao userDao = new UserDao();
        userDao.update(message.getMessageSender());
        for (User user : users) {
            List<Message> messages = new ArrayList<>();
            messages.add(message);
            user.setUserMessages(messages);
            userDao.update(user);
        }
    }
}
