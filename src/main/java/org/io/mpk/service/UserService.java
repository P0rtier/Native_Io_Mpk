package org.io.mpk.service;

import org.io.mpk.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserService {

    private List<User> userList = new ArrayList<>();

    public UserService() {
    }

    public UserService(List<User> userList) {
        this.userList = userList;
    }

    public Long autoIncrementIdx(){
        if(userList.isEmpty())
            return 1L;
        return userList.get(userList.size()-1).getUserId()+1;
    }

    public boolean loginUser(String email, String password){
        User userToBeChecked = findUserByEmail(email);
        return userToBeChecked != null && userToBeChecked.getPassword().equals(password);
    }

    public void registerUser(String name, String surname, String username, String password, String email, Integer cardNumber, String ccv, LocalDateTime cardExpireDate){
        Long userToBeSavedId = autoIncrementIdx();
        User userToBeSaved = new User(userToBeSavedId ,name, surname, username,password, email, cardNumber, ccv, cardExpireDate);
        userList.add(userToBeSaved);
    }

    public User findUserByEmail(String email){
        return userList.stream()
                .filter(t -> t.getEmail().equals(email))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }


    private void addUser(User user){
        userList.add(user);
    }
}
