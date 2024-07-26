package az.edu.turing;

import az.edu.turing.connection.DBConnection;
import az.edu.turing.entity.Student;
import az.edu.turing.process.DBProcess;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DBProcess.createStudent();// Create the student table if it doesn't exist

        Student student1 = new Student(1, "Aybani", "Kazimov", 2004, "j24nskfs");
        Student student2 = new Student(2, "Aydan", "Nezerli", 2003, "84sfjo5fs");
        Student student3 = new Student(3, "Nazrin", "Karimli", 2004, "j2sjdfkfs");
        Student student4 = new Student(4, "Aydin", "Esrefov", 2000, "843975fs");
        Student updateStudent1 = new Student(1, "Aybaniz", "Esrefova", 2004, "43ahdfs");
        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);
        listOfStudents.add(student4);

        DBProcess.insertStudent(listOfStudents); // Insert a student into the table
        DBProcess.updateStudent(updateStudent1);
        DBProcess.findStudentLikeName();
        //DBProcess.deleteStudent(2);
        //DBProcess.findStudentById();
        DBConnection.closeProject();
    }
}