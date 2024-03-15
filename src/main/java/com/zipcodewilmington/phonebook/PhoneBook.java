package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;
    private List<String> phoneNum;

    public PhoneBook(Map<String, List<String>> map) {
        //to 1return in order
        // is there a way to return it without LinkedHashmap<>()
        this.phonebook = new LinkedHashMap<>();


    }

    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        phonebook.putIfAbsent(name, new ArrayList<>());
        phonebook.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.putIfAbsent(name, new ArrayList<>());
        for (int i = 0; i < phoneNumbers.length; i++) {
            String phoneNumber = phoneNumbers[i];
            phonebook.get(name).add(phoneNumber);

        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        //Fix this
        boolean y = true;
        if (phonebook.containsKey(name)){
            return y;
        }
        return false;
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        //Fix this
        Boolean x = true;
        if(phonebook.containsKey(name) || phonebook.containsKey(phoneNumber)){
            return x;
        }
        return false;

    }
    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {

        for (String key : phonebook.keySet()) {
            ArrayList<String> name = (ArrayList<String>) phonebook.get(key);
            if (name.contains(phoneNumber)) {
                return key;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {

        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
