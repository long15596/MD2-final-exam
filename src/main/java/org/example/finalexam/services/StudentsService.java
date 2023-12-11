package org.example.finalexam.services;

import org.example.finalexam.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsService implements IService<Student>{
    List<Student> studentList;

    public StudentsService() {
        this.studentList = new ArrayList<>();
    }

    @Override
    public List<Student> showAll() {
        return studentList = readData();
    }

    @Override
    public void create(Student o) {
        studentList.add(o);
        writeData(studentList);
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) index = i;
        }
        return index;
    }

    @Override
    public Student findById(int id) {
        for (Student student: studentList){
            if(student.getId() == id) return student;
        }
        return null;
    }

    @Override
    public Student findByName(String str) {
        for (Student student: studentList){
            if (student.getName().contains(str)) return student;
        }
        return null;
    }

    @Override
    public void delete(int id) {
        studentList.remove(findIndexById(id));
        writeData(studentList);
    }

    @Override
    public void update(int id, Student o) {
        studentList.set(findIndexById(id), o);
        writeData(studentList);
    }
    public static void writeData(List<Student> studentList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\CodeGym\\MD2\\final-exam\\src\\main\\java\\org\\example\\finalexam\\data\\studentData.csv"));
            String line = "ID, Name, Age, Gender, GPA\n";
            for (Student student: studentList) {
                line += student.getId() + ","
                        + student.getName() + ","
                        + student.getAge() + ","
                        + student.getGender() + ","
                        + student.getGpa() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static List<Student> readData() {
        List<Student> students = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\CodeGym\\MD2\\final-exam\\src\\main\\java\\org\\example\\finalexam\\data\\studentData.csv"));
            String content = bufferedReader.readLine();
            while ((content = bufferedReader.readLine()) != null){
                String[] value = content.split(",");
                int id = Integer.parseInt(value[0]);
                String name = value[1];
                int age = Integer.parseInt(value[2]);
                String gender = value[3];
                double gpa = Double.parseDouble(value[4]);
                students.add(new Student(id,name,age,gender,gpa));
            }
            bufferedReader.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return students;
    }
}
