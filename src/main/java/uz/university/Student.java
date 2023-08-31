package uz.university;

public class Student implements Comparable<Student> ,Cloneable{
    private String university;
    private String surName;
    private String name;
    private String id;
    private String phoneNumber;

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Student o) {
        return this.surName.compareTo(o.surName);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String toString() {
        return "Student{" +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                "id= "+id+'\''+
                ", phoneNumber='" + phoneNumber +'\''
                +"university='" + university + '\'' +
                '}';
    }

    public Student(String surName, String name, String id, String phoneNumber,String university) {
        this.university = university;
        this.surName = surName;
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }
}
