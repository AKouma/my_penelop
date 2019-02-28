package Utils;

import Modules.Contact;
import Modules.Groupe;
import Modules.Message;
import Modules.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import static Utils.Constants.*;

public class FileManager {

    public static List<Object> getFromJson(String filePath, Object object) {
        List<Object> objects = new ArrayList<>();
        String jsonType = getObjectType(object);
        JSONParser jsonParser = new JSONParser();
        try (FileReader fileReader = new FileReader(filePath)) {
            JSONObject jsonContent = (JSONObject) jsonParser.parse(fileReader);
            JSONArray contentArray = (JSONArray) jsonContent.get(jsonType);
            for (Object obj : contentArray) {
                Object objectFormed = (Object) getFromJsonObject((JSONObject) obj, object);
                if (objectFormed != null) {
                    objects.add(objectFormed);
                }
            }
        } catch (FileNotFoundException e) {
            Logger.getAnonymousLogger(e.getMessage());
        } catch (IOException e) {
            Logger.getAnonymousLogger(e.getMessage());
        } catch (ParseException e) {
            Logger.getAnonymousLogger(e.getMessage());
        }
        return objects;
    }

    public static void InsertIntoJson(List<Object> objects, String filePath) {
        PrintWriter myWriter = null;
        String jsonType = getObjectType(objects.get(0));
        if (objects.isEmpty() || jsonType == null)
            return;

        try {
            myWriter = new PrintWriter(new FileWriter(filePath, false));
            myWriter.write("{" + "\"" + jsonType + "\":[");
            Iterator it = objects.iterator();
            while (it.hasNext()) {
                Object current = it.next();
                myWriter.write(current.toString());
                myWriter.write(it.hasNext() ? ",\n" : "\n");
            }
            myWriter.write("]}");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            myWriter.flush();
            myWriter.close();
        }

    }

    public static String getObjectType(Object object) {
        if (object instanceof User) {
            return objectType.USERS.getType();
        } else if (object instanceof Contact) {
            return objectType.CONTACTS.getType();
        } else if (object instanceof Groupe) {
            return objectType.GROUPES.getType();
        } else if (object instanceof Message) {
            return objectType.MESSAGES.getType();
        } else {
            return null;
        }
    }

     enum objectType {
        USERS("users"),
        CONTACTS("contacts"),
        GROUPES("groupes"),
        MESSAGES("messages");

        String type;

        objectType(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public static Object getFromJsonObject(JSONObject jsonObjectPersonn, Object module) {
        if (module instanceof User) {
            return createUserObject(jsonObjectPersonn);
        } else if (module instanceof Message) {
            return null;
        } else if (module instanceof Groupe) {
            return null;
        } else if (module instanceof Contact) {
            return null;
        } else {
            return null;
        }
    }

    public static User createUserObject(JSONObject jsonObjectUser) {
        User user = User.getInstance();
        user.setMatricule(getValueFromJsonObject(jsonObjectUser, USER_MATRICULE_FIELD));
        user.setUserFirstname(getValueFromJsonObject(jsonObjectUser, USER_FIRST_NAME_FIELD));
        user.setUserName(getValueFromJsonObject(jsonObjectUser, USER_NAME_FIELD));
        user.setUserBirth(getValueFromJsonObject(jsonObjectUser, USER_BIRTH_FIELD));
        user.setUserLogin(getValueFromJsonObject(jsonObjectUser, USER_LOGIN_FIELD));
        user.setUserpassword(getValueFromJsonObject(jsonObjectUser, USER_PASSWORD_FIELD));
        user.setUserMail(getValueFromJsonObject(jsonObjectUser, USER_MAIL_FIELD));
        user.setUserProfil(getValueFromJsonObject(jsonObjectUser, USER_PROFIL_FIELD));
        user.setIdGroup((Long) jsonObjectUser.get(USER_GROUP_ID_FIELD));
        user.setDeleted((Boolean) jsonObjectUser.get(USER_DELETED_FIELD));
        user.setCreationDate(getValueFromJsonObject(jsonObjectUser, USER_CREATION_DATE_FIELD));
        user.setDeleteDate(getValueFromJsonObject(jsonObjectUser, USER_DELETED_DATE_FIELD));
        user.setUpdateDate(getValueFromJsonObject(jsonObjectUser, USER_UPDATE_DATE_FIELD));
        user.setUserContatcs((List<Contact>) jsonObjectUser.get(USER_CONTATCS_FIELD));
        user.setUserMessages((List<Message>) jsonObjectUser.get(USER_MESSAGES_FIELDS));
        return user;
    }

    private static String getValueFromJsonObject(JSONObject jsonObjectPerson, String field) {
        return (jsonObjectPerson != null ? ((String) jsonObjectPerson.get(field)) : null);
    }
}
