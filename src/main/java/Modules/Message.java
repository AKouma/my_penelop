package Modules;

import java.util.List;
import java.util.Objects;

public class Message extends AbstractModule<Message> {

    //date format dd/MM/aaaa

    private int idMessage;
    private String messageText;
    private User messageSender;
    private List<User> messageSentTo;
    private String messageDate;
    private String messageobject;
    private boolean isRead;
    private boolean isDeleted;
    private String creationDate;
    private String deleteDate;
    private String updateDate;

    @Override
    public void myAbstractMethod() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"idMessage\":" + idMessage +
                ", \"messageText\":" + "\"" + messageText + "\"" +
                ", \"messageSender\":" + messageSender +
                ", \"messageSentTo\":" + messageSentTo +
                ", \"messageDate\":" + "\"" + messageDate + "\"" +
                ", \"messageobject\":" + "\"" + messageobject + "\"" +
                ", \"isRead\":" + isRead +
                ", \"isDeleted\":" + isDeleted +
                ", \"creationDate\":" + "\"" + creationDate + "\"" +
                ", \"deleteDate\":" + "\"" + deleteDate + "\"" +
                ", \"updateDate\":" + "\"" + updateDate + "\"" +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return idMessage == message.idMessage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMessage);
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public User getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(User messageSender) {
        this.messageSender = messageSender;
    }

    public List<User> getMessageSentTo() {
        return messageSentTo;
    }

    public void setMessageSentTo(List<User> messageSentTo) {
        this.messageSentTo = messageSentTo;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageobject() {
        return messageobject;
    }

    public void setMessageobject(String messageobject) {
        this.messageobject = messageobject;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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

    public Message sendMessage() {
        return null;
    }//todo implement later
}