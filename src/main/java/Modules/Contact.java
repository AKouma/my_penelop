package Modules;

import java.util.Objects;

public class Contact extends AbstractModule<Contact> {

    private int idContact;
    private String contactFullName;
    private String contact1;
    private String contact2;
    private String cityOrTown;
    private String department;
    private String country;
    private String address;
    private String isAvailable;

    @Override
    public String toString() {// todo adapt to add in a json file
        return "Contact{" +
                "idContact=" + idContact +
                ", contactFullName='" + contactFullName + '\'' +
                ", contact1='" + contact1 + '\'' +
                ", contact2='" + contact2 + '\'' +
                ", cityOrTown='" + cityOrTown + '\'' +
                ", department='" + department + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", isAvailable='" + isAvailable + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return idContact == contact.idContact;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContact);
    }

    private static class ContactHolder {
        private static Contact contact = new Contact();
    }

    @Override
    public void myAbstractMethod() {
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public String getContactFullName() {
        return contactFullName;
    }

    public void setContactFullName(String contactFullName) {
        this.contactFullName = contactFullName;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public void setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

}
