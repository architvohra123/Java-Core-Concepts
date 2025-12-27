package Comparable_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
    int age;
    String name;

    public Student (int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        return this.age - other.age; // natural sorting order based on age
    }
}

public class Main {
    public static void main(String[] args) {

        // comparator is an interface used to define custom sorting order

        // custom comparator for sorting based on last digit
        Comparator com = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return (a%10) - (b%10);
            }
         };

        List<Integer> nums = new ArrayList<>();
        nums.add(14);
        nums.add(23);
        nums.add(7);
        nums.add(90);

        Collections.sort(nums, com);
        // System.out.println(nums);


        List<Student> students = new ArrayList<>();
        students.add(new Student(22, "Alice"));
        students.add(new Student(20, "Bob"));
        students.add(new Student(23, "Charlie"));
        // now in order to sort students we can use comparator, for that we need to define comparator for student class, but if we want to have a natural sorting order we can implement comparable interface in student class
         Collections.sort(students); // uses compareTo method of Student class
         System.out.println(students);

         // NOTE: comparator can override the natural sorting order which is defined by comparable
    }
}

