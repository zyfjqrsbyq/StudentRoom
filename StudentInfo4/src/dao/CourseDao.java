package dao;

import java.util.List;
import java.util.Map;

import domain.Course;

/**
 * �γ̲�����DAO
 */
public interface CourseDao {


    public List<Course> findAll();

    void add(Course course);

    void delete(int id);

    Course findById(int i);

    void update(Course course);

    /**
     * ��ѯ�ܼ�¼��
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * ��ҳ��ѯÿҳ��¼
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<Course> findByPage(int start, int rows, Map<String, String[]> condition);
}
