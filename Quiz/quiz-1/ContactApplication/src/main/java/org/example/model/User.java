package org.example.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private List<Contact> contactList = new ArrayList<>();

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addContact(Contact newContact) {
//        add contact
        contactList.add(newContact);
    }

    public void deleteContact(long id) {
//        delete contact
    }

    public List<Contact> searchContactByFirstName(String firstName) {
//        search
        return Collections.emptyList();
    }

    public void uploadContacts(List<Contact> newContacts) {
//        upload contacts
    }

    public void mergeDuplicateContacts() {
//        merge duplicate contacts
    }


    public void displayContactsSortedByLastName() {
        List<Contact> sortedContact = contactList.stream()
                .sorted(Comparator.comparing(Contact::getFirstName))
                .toList();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(sortedContact);
        System.out.println(result);
    }
}
