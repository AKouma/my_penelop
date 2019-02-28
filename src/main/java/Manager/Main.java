package Manager;

import Modules.Message;
import Modules.User;
import Utils.FileManager;

import java.util.ArrayList;
import java.util.List;

import static Utils.Constants.userFilePathName;

public class Main {

    public static void main(String[] args) {
        List<Object> groupes = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        for(int i = 0; i <=10; i ++){
            String groupe = "groupe" + i;
            Message gr = new Message();
            gr.setIdMessage(i);
            gr.setMessageText("message"+1);
            gr.setUpdateDate(null);
            gr.setDeleteDate(null);
            gr.setDeleted(false);
            gr.setCreationDate(null);
            messages.add(gr);
        }
        for(int i = 0; i <=10; i ++){
            String user = "user" + i;
            User gr = User.getInstance();
            gr.setIdGroup(i);
            gr.setMatricule("metricule"+1);
            gr.setUpdateDate(null);
            gr.setDeleteDate(null);
            gr.setDeleted(false);
            gr.setCreationDate(null);
            gr.setUserMessages(messages);
            groupes.add(gr);
        }
        FileManager.InsertIntoJson(groupes, userFilePathName);
        List<Object> users = FileManager.getFromJson(userFilePathName, User.getInstance());
        for (Object user :  users) {
           System.out.println(user.toString());
        }
    }
}
