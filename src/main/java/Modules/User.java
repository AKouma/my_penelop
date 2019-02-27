package Modules;

import java.util.List;
import java.util.Objects;

public class User extends AbstractModule<User> {

    //date format dd/MM/aaaa

    private String matricule;
    private String userLogin;
    private String userpassword;
    private String userName;
    private String userFirstname;
    private String userBirth;
    private String userProfil;
    private String userMail;
    private boolean isDeleted;
    private int idGroup;
    private List<Contact> userContatcs;
    private List<Message> userMessages;
    private String creationDate;
    private String deleteDate;
    private String updateDate;

    @Override
    public String toString() {
        return "{" +
                "\"matricule\":" + matricule +'\"' +
                ", \"userLogin\":" + userLogin + '\"' +
                ", \"userpassword\":" + userpassword + '\"' +
                ", \"userName\":" + userName + '\"' +
                ", \"userFirstname\":" + userFirstname + '\"' +
                ", \"userBirth\":" + userBirth + '\"' +
                ", \"userProfil\":" + userProfil + '\"' +
                ", \"userMail\":" + userMail + '\"' +
                ", \"isDeleted\":" + isDeleted +
                ", \"idGroup\":" + idGroup +
                ", \"userContatcs\":" + userContatcs +
                ", \"userMessages\":" + userMessages +
                ", \"creationDate\":" + creationDate + '\"' +
                ", \"deleteDate\":" + deleteDate + '\"' +
                ", \"updateDate\":" + updateDate + '\"' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return matricule.equals(user.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }

    private static class UserHolder{
        private static User user = new User();
    }

    private User(){}

    public static User getInstance(){
        return UserHolder.user;
    }

    @Override
    public void myAbstractMethod() {
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserProfil() {
        return userProfil;
    }

    public void setUserProfil(String userProfil) {
        this.userProfil = userProfil;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public List<Contact> getUserContatcs() {
        return userContatcs;
    }

    public void setUserContatcs(List<Contact> userContatcs) {
        this.userContatcs = userContatcs;
    }

    public List<Message> getUserMessages() {
        return userMessages;
    }

    public void setUserMessages(List<Message> userMessages) {
        this.userMessages = userMessages;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}