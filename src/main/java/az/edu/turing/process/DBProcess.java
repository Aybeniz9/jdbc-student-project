package az.edu.turing.process;

import az.edu.turing.connection.DBConnection;
import az.edu.turing.entity.Student;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class DBProcess {
    private static PreparedStatement preparedStatement = null;
    private static Connection connection = DBConnection.getConnection();
    private static ResultSet resultSet = null;

    public static void createStudent() {
        try {
            String query = "DROP TABLE IF EXISTS student; " +
                    "CREATE TABLE student (" +
                    "studentId SERIAL PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "surname VARCHAR(255), " +
                    "birhdate INT, " + // Corrected typo here to match the table creation query
                    "studentNumber VARCHAR(30))";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            System.out.println("Student table has been created successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void insertStudent(List<Student> listOfStudents) {
        String query = "INSERT INTO student(name, surname, birhdate, studentNumber,studentid) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            for (Student student : listOfStudents) {

                preparedStatement.setInt(5, student.getStudentId());
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getSurname());
                preparedStatement.setInt(3, student.getBirthDate());
                preparedStatement.setString(4, student.getStudentNumber());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void updateStudent(Student student) {
        String query = "UPDATE student SET name=? ,surname=? ,birhdate=?,studentNumber=? WHERE studentId=? ";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(5, student.getStudentId());
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getBirthDate());
            preparedStatement.setString(4, student.getStudentNumber());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        
    }
    public static void deleteStudent(Integer studentId) {
        String query = "DELETE FROM student WHERE studentId=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
            System.out.println("Student delete from dataBase !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void findStudentById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("id daxil edin");
        int studentId = sc.nextInt();
        String query = "SELECT *FROM student where studentId=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                Integer birthDate = resultSet.getInt(4);
                String studentNumber = resultSet.getString(5);
                System.out.println(id + " " + name + " " + surname + " " + birthDate + " " + studentNumber);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void findStudentLikeName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the letter");
        String letter = scanner.nextLine();
        String query = " SELECT *FROM student WHERE name LIKE'" + letter + "%' ";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String surname = resultSet.getString(2);
                System.out.println(name + " " + surname);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

