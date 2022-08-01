package service.impl;

import java.util.List;
import java.util.Map;

import domain.Course;
import domain.PageBean;
public interface CourseService {
	
	/**
     * ��ѯ���пγ���Ϣ
     * @return
     */
    public List<Course> findAll();


    /**
     * ����Course
     * @param course
     */
    void addCourse(Course course);

    /**
     * ����idɾ��Course
     * @param id
     */
    void deleteCourse(String id);

    /**
     * ����id��ѯ
     * @param id
     * @return
     */
    Course findCourseById(String id);

    /**
     * �޸Ŀγ���Ϣ
     * @param course
     */
    void updateCourse(Course course);

    /**
     * ����ɾ���γ�
     * @param ids
     */
    void delSelectedCourse(String[] ids);

    /**
     * ��ҳ������ѯ
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Course> findCourseByPage(String currentPage, String rows, Map<String, String[]> condition);
}
