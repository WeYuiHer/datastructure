package hekui.se;

import java.util.HashSet;

class Student {
    String name;
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        if (s.name.equals(this.name) && s.age == this.age)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.age;
    }
}

public class Demo1 {

    public static void main(String[] args) {
     /*   String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println("s1==s2:" + (s1 == s2));
        System.out.println("s1==s2:" + (s1 == s3));
        System.out.println("equals :" + (s1.equals(s3)));
*/
        new Object();
        Student s1 = new Student("a", 12);
        Student s2 = new Student("a", 12);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("equls : " + s1.equals(s2));
        System.out.println("== :" + (s1 == s2));

        HashSet<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        System.out.println(set.size());


    }

}
