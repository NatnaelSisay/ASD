package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private String firstName;
    private String lastName;
    private String company;
    private String jobTitle;
    private List<Phone> phoneNumbers = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();

    public Contact(String firstName, String lastName, String company, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
    }

    public void addPhone(Phone newPhone) {
        phoneNumbers.add(newPhone);
    }

    public void addEmail(Email newEmail) {
        emails.add(newEmail);
    }
}
