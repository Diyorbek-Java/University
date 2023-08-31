package uz.university;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import com.github.javafaker.Faker;
import uz.university.exceptions.WrongLoginException;
import uz.university.exceptions.WrongPasswordException;

public class University {
    static Scanner textScanner=new Scanner(System.in);
    static Scanner numScanner=new Scanner(System.in);
    static Set<Student> students=new HashSet<>(100);
    public static void main(String[] args) {
        fulfillStudentWithFaker(students);
        while (true){
            menu();
            int scanning= numScanner.nextInt();
            switch (scanning){
                case 1-> System.out.println(students);
                case 2 -> getStudentById();
                case 3->getStudentByUniversity();
                case 4->getStudentByPhoneNumber();
                default -> {
                    return;
                }
            }
        }
    }
    public static void fulfillStudentWithFaker(Set<Student> students){
        Faker faker=new Faker();
        for (int i = 0; i <100 ; i++) {
            String sureName=faker.name().firstName();
            String name=faker.name().lastName();
            String id=faker.idNumber().invalid();
            String phoneNumber=faker.phoneNumber().phoneNumber();
            String university=faker.university().name();
            Student student=new Student(sureName,name,id,phoneNumber,university);
            students.add(student);
        }
    }
    public static void getStudentByPhoneNumber(){
        System.out.println("Enter phone number");
        String phoneNumber= textScanner.nextLine();
        Optional<Student> studentOptional = getStudentByPhoneNumber(students, phoneNumber);
        if (studentOptional.isPresent()){
            Student student=studentOptional.get();
            System.out.println(student);
        }else{
            System.out.println("Student didn't found");
        }
    }
    public static void getStudentById(){
        System.out.println("Enter id");
        String id= textScanner.nextLine();
        Optional<Student> studentOptional = getStudentByIdNumber(students, id);
        if (studentOptional.isPresent()){
            Student student=studentOptional.get();
            System.out.println(student);
        }else{
            System.out.println("Student didn't found");
        }
    }
    public static void getStudentByUniversity(){
        System.out.println("enter university");
        String university= textScanner.nextLine();
        Optional<Student> studentOptional = getUniversityStudents(students, university);
        if (studentOptional.isPresent()){
            Student student=studentOptional.get();
            System.out.println(student);
        }else{
            System.out.println("Student didn't find");
        }

    }
    private static void menu() {
        System.out.println("""
                1-see all Students
                2-get Student by Id number
                3-get Students by University
                4-get Student by Phone Number
                if you input anything other than those application will stop
                """);
    }
    public static Optional<Student> getUniversityStudents(Set<Student> students, String universityName) {
        for (Student student : students) {
            if (student.getUniversity().equalsIgnoreCase(universityName)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }
    public static Optional<Student> getStudentByIdNumber(Set<Student> students, String idNumber) {
        for (Student student : students) {
            if (student.getId().equals(idNumber)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }
    public static boolean isLoginAndPasswordCorrect(String login,String password,String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length()>20) throw new WrongLoginException();
        if (password.length()<4||password.length()>20) throw new WrongPasswordException();
        if (password.equals(confirmPassword)){
            return true;
        }
        return false;
    }
    public static Optional<Student> getStudentByPhoneNumber(Set<Student> students, String phoneNumber) {
        for (Student student : students) {
            if (student.getPhoneNumber().equals(phoneNumber)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

}
