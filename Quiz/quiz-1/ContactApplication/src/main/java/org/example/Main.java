package org.example;

import org.example.model.Contact;
import org.example.model.Email;
import org.example.model.Phone;
import org.example.model.User;

public class Main {
    public static void main(String[] args) {
//        SAMPLE DATA
        User java = new User("Natnael", "Kagnaw");
//
        Contact david = new Contact("David", "Sangar", "Argos LLC", "Sales Manager");
        Contact carlos = new Contact("Carlos", "Jimenez", null, null);
        Contact ali = new Contact("Ali", "Gafar", "BMI Services", "HR Manager");
//
        Phone davidP1 = new Phone("Home", "240-133-0011");
        Phone davidP2 = new Phone("Mobile", "240-112-0123");
        Phone carlosP1 = new Phone("Mobile", "412-116-9988 ");
//
        Email davidE1 = new Email("Home", "dave.sang@gmail.com");
        Email davidE2 = new Email("Work", "dsang@agros.com");
        Email aliE1 = new Email("Work", "ali@bmi.com");
//
        david.addPhone(davidP1);
        david.addPhone(davidP2);
        david.addEmail(davidE1);
        david.addEmail(davidE2);

        carlos.addPhone(carlosP1);

        ali.addEmail(aliE1);
//
        java.addContact(david);
        java.addContact(carlos);
        java.addContact(ali);
//
        System.out.println("---- User Contact --- ");
        java.displayContactsSortedByLastName();
    }
}