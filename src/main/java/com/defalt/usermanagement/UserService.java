package com.defalt.usermanagement;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService implements Serializable{

   private static ArrayList<User> userList = new ArrayList<>();
   private static User superAdmin = new User("super","super");
    static {
    }

    static User currentUser;
    public static boolean addUser(User user) {
        userList.add(user);
        saveData();
        return true;
    }

    public static boolean delUser(User user) {
        userList.remove(user);
        saveData();
        return true;
    }

    public static boolean delUser(int index) {
        userList.remove(index);
        saveData();
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
        saveData();
        return true;
    }

    public static void saveData() {
        File file = null;
        FileOutputStream fos= null;
        ObjectOutputStream oos = null;
        try{
            file  = new File("user.bin");
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
            fos.close();
        }catch(FileNotFoundException ex){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void loadData() {
        File file = null;
        FileInputStream fis= null;
        ObjectInputStream ois = null;
        try{
            file  = new File("user.bin");
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            userList = (ArrayList<User>) ois.readObject();
            ois.close();
            fis.close();
        }catch(FileNotFoundException ex){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
       }
    }public static User auth(String userName,String password){
        if(userName.equals("super")&&password.equals("super")){
            currentUser=superAdmin;
            return superAdmin;
        }
        for(int i=0;i<userList.size();i++){
            User user = userList.get(i);
            if(user.getUserName().equals(userName)&&user.getPassword().equals(password)){
                currentUser=user;
                return user;
            }
        }return null;
    }static public User getCurrentUser(){
        return currentUser;
    }
}
