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
        if (userList.add(user)) {
            return true;
        }
        return false;
    }

    public static boolean delUser(User user) {
        if (userList.remove(user)) {
            return true;
        }
        return false;
    }

    public static boolean delUser(int index) {
        if (userList.remove(index) != null) {
            return true;
        }
        return false;
    }

    public static ArrayList<User> getUser() {
        return userList;
    }

    public static boolean updateUser(int index, User user) {
        userList.set(index, user);
        return true;
    }

    public static void saveData() {

    }

    public static void loadData() {

    }
}
