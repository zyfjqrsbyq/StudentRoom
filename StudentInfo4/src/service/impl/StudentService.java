package service.impl;

import java.util.List;
import java.util.Map;

import domain.PageBean;
import domain.Student;

public interface StudentService {
	/**
     * ��ѯ����ѧ����Ϣ
     * @return
     */
    public List<Student> findAll();


    /**
     * ����Student
     * @param user
     */
    void addStudent(Student student);

    /**
     * ����idɾ��Student
     * @param id
     */
    void deleteStudent(String id);

    /**
     * ����id��ѯ
     * @param id
     * @return
     */
    Student findStudentById(String id);

    /**
     * �޸��û���Ϣ
     * @param user
     */
    void updateStudent(Student student);

    /**
     * ����ɾ���û�
     * @param ids
     */
    void delSelectedStudent(String[] ids);

    /**
     * ��ҳ������ѯ
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Student> findStudentByPage(String currentPage, String rows, Map<String, String[]> condition);
}
