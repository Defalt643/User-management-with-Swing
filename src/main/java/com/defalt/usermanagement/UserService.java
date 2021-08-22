package com.defalt.usermanagement;

import java.util.*;

public class UserService {

   private static ArrayList<User> userList = null;
    static {
        userList = new ArrayList<>();
        userList.add(new User("admin", "password"));
        userList.add(new User("user1", "password"));
        userList.add(new User("user2", "password"));
    }


    public static boolean addUser(User user) {
        userList.add(user);
        return true;
    }

    public static boolean delUser(User user) {
        userList.remove(user);
        return true;
    }

    public static boolean delUser(int index) {
        userList.remove(index);
        return true;

    }

    public static ArrayList<User> getUser() {
        return userList;
    }

    public static User getUser(int index) {
        return userList.get(index);
    }

    public static boolean updateUser(int index, User user) {
        userList.set(index, user);
        return true;
    }

    public static void saveData() {

    }

    public static void loadData() {

    }public static User auth(String userName,String password){
        for(int i=0;i<userList.size();i++){
            User user = userList.get(i);
            if(user.getUserName().equals(userName)&&user.getPassword().equals(password)){
                return user;
            }
        }return null;
    }
}
