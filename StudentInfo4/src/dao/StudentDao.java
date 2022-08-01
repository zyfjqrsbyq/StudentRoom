package dao;

import java.util.List;
import java.util.Map;

import domain.Student;

public interface StudentDao {


    public List<Student> findAll();

   
    void add(Student student);

    void delete(String sno);

    Student findById(String i);

    void update(Student student);

    
    int findTotalCount(Map<String, String[]> condition);

    
    List<Student> findByPage(int start, int rows, Map<String, String[]> condition);
}
