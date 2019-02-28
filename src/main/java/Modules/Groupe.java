package Modules;

import java.util.Objects;

public class Groupe extends AbstractModule<Groupe> {

    //date format dd/MM/aaaa

    private long idGroup;
    private String groupName;
    private String groupChief;
    private String privilege;
    private boolean isDeleted;
    private boolean hasChief;
    private String creationDate;
    private String deleteDate;
    private String updateDate;

    @Override
    public void myAbstractMethod() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"idGroup\":" + idGroup +
                ", \"groupName\":" + "\"" + groupName + "\"" +
                ", \"groupChief\":" + "\"" + groupChief + "\"" +
                ", \"privilege\":" + "\"" + privilege + "\"" +
                ", \"isDeleted\":" + isDeleted +
                ", \"hasChief\":" + hasChief +
                ", \"creationDate\":" + "\"" + creationDate + "\"" +
                ", \"deleteDate\":" + "\"" + deleteDate + "\"" +
                ", \"updateDate\":" + "\"" + updateDate + "\"" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groupe groupe = (Groupe) o;
        return idGroup == groupe.idGroup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGroup);
    }

    public long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(long idGroup) {
        this.idGroup = idGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupChief() {
        return groupChief;
    }

    public void setGroupChief(String groupChief) {
        this.groupChief = groupChief;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isHasChief() {
        return hasChief;
    }

    public void setHasChief(boolean hasChief) {
        this.hasChief = hasChief;
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
