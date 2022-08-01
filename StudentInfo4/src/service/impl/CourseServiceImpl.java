package service.impl;

import java.util.List;

import java.util.Map;

import dao.CourseDao;
import dao.impl.CourseDaoImpl;
import domain.Course;
import domain.PageBean;

public class CourseServiceImpl implements CourseService{
	
	private CourseDao dao = new CourseDaoImpl();

    @Override
    public List<Course> findAll() {
        //����Dao��ɲ�ѯ
        return dao.findAll();
    }

    @Override
    public void addCourse(Course course) {
        dao.add(course);
    }

    @Override
    public void deleteCourse(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public Course findCourseById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateCourse(Course course) {
        dao.update(course);
    }

    @Override
    public void delSelectedCourse(String[] ids) {
        if(ids != null && ids.length > 0){
            //1.��������
            for (String id : ids) {
                //2.����daoɾ��
                dao.delete(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PageBean<Course> findCourseByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.�����յ�PageBean����
        PageBean<Course> pb = new PageBean<Course>();
        //2.���ò���
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.����dao��ѯ�ܼ�¼��
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.����dao��ѯList����
        //���㿪ʼ�ļ�¼����
        int start = (currentPage - 1) * rows;
        List<Course> list = dao.findByPage(start,rows,condition);
        
        
        pb.setList(list);

        //5.������ҳ��
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }
}
