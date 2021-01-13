package com.student.repository;

import com.student.entity.Student;
import com.student.utils.JDBCTools;
import jdk.nashorn.internal.scripts.JD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select * from student";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            Student student = null;
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int score = rs.getInt("score");
                //System.out.println(id + " " + name + " " + score);
                student = new Student(id, name, score);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, rs);
        }
        return list;
    }

    public void add(int id, String name, int score) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "insert into student(id, name, score) values (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, score);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, null);
        }
    }

    public void deleteById(int id) {
        Connection connection = JDBCTools.getConnection();
        String sql = "delete from student where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCTools.release(connection, preparedStatement, null);
    }

    public Student findById(int id) {
        Student student = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "select * from student where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                int score = rs.getInt("score");
                student = new Student(id, name, score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCTools.release(connection, preparedStatement, rs);
        return student;
    }

    public void updateById(int id, String name, int score) {
        Connection connection = JDBCTools.getConnection();
        String sql = "update student set name = ?, score = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(3, id);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCTools.release(connection, preparedStatement, null);
    }

//    public static void main(String[] args) { //测试
//        StudentRepository studentRepository = new StudentRepository();
//        studentRepository.add(3, "张三", 18);
//    }
}
