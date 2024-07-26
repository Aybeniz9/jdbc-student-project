package az.edu.turing.entity;

public class Student {
    Integer studentId;
    String name;
    String surname;
    Integer birthDate;
    String studentNumber;

    public Student(int studentId, String name, String surname, Integer birthDate, String studentNumber) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.studentNumber = studentNumber;

    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
