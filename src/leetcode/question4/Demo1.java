package leetcode.question4;

import java.util.ArrayList;
import java.util.HashSet;

class User{
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Demo1 {

    public static void main(String[] args) {

        ArrayList<User> list = new ArrayList<>();
        list.add(new User(1, "aaa", 12));
        list.add(new User(2, "bbb", 13));
        list.add(new User(3, "ccc", 14));
        list.add(new User(4, "ddd", 15));
        list.add(new User(5, "eee", 16));
        list.stream()
                .filter((user)->{return (user.getId()&1)!=0;})
                .filter((user)->{return user.getAge()>11;})
                .map((user)->{return user.getName().toUpperCase();})
                .sorted((u1,u2)->{return u2.compareTo(u1);})
                .limit(2)
                .forEach(System.out::println);


    }
}
