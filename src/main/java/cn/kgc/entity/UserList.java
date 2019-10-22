package cn.kgc.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mr
 * @Date 2019/10/15 19:00
 */
public class UserList implements Serializable {
    private static List<User> userList = new ArrayList<User> ();

    public static void save(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ("save.obj"));
            oos.writeObject (userList);
            oos.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static void read() {
        try {
            ObjectInputStream ois = new ObjectInputStream (new FileInputStream ("save.obj"));
            userList = (List) ois.readObject ();
            for (int i = 0; i < userList.size (); i++) {
                System.out.println (userList.get (i).getPwd ());
            }
        } catch (IOException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }
    public Object getUserList(int i) {
        return userList.get (i);
    }

    public int size() {
        return userList.size ();
    }

    public void addUserList(User user) {
        this.userList.add (user);
    }
}
