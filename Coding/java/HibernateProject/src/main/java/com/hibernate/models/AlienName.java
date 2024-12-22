package com.hibernate.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class AlienName {

    private String firstName;
    private String middleName;
    private String lastName;

    public AlienName(){}

    public AlienName(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AlienName{");
        sb.append("firstName=").append(firstName);
        sb.append(", middleName=").append(middleName);
        sb.append(", lastName=").append(lastName);
        sb.append('}');
        return sb.toString();
    }
}
