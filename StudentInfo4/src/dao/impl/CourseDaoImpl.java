package dao.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.CourseDao;
import domain.Course;
import util.JDBCUtils;

public class CourseDaoImpl implements CourseDao{
	
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Course> findAll() {
        //ʹ��JDBC�������ݿ�...
        //1.����sql
        String sql = "select * from course";
        List<Course> course = template.query(sql, new BeanPropertyRowMapper<Course>(Course.class));

        return course;
    }

    

    @Override
    public void add(Course course) {
        //1.����sql
        String sql = "insert into course values(null,?,?,?,?,?)";
        //2.ִ��sql
        template.update(sql,course.getCourseno(), course.getCoursename(), course.getType(), course.getPeriod(), course.getCredit());
    }
    
    @Override
    public Course findById(int id) {
        String sql = "select * from course where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Course>(Course.class), id);
    }

    @Override
    public void update(Course course) {
        String sql = "update student set courseno = ?,coursename = ? ,type = ? , period = ? , credit = ? where id = ?";
        template.update(sql, course.getCourseno(), course.getCoursename(), course.getType(),course.getPeriod(), course.getCredit(),course.getId());
    }
    

    @Override
    public void delete(int id) {
        //1.����sql
        String sql = "delete from course where id = ?";
        //2.ִ��sql
        template.update(sql, id);
    }


    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.����ģ���ʼ��sql
        String sql = "select count(*) from course where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.����map
        Set<String> keySet = condition.keySet();
        //��������ļ���
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //�ų���ҳ��������
            if("method".equals(key) || "currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //��ȡvalue
            String value = condition.get(key)[0];
            //�ж�value�Ƿ���ֵ
            if(value != null && !"".equals(value)){
                //��ֵ
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//��������ֵ
            }
        }
        //System.out.println(sb.toString());
        //System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Course> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from course  where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //2.����map
        Set<String> keySet = condition.keySet();
        //��������ļ���
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //�ų���ҳ��������
            if("method".equals(key)||"currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //��ȡvalue
            String value = condition.get(key)[0];
            //�ж�value�Ƿ���ֵ
            if(value != null && !"".equals(value)){
                //��ֵ
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//��������ֵ
            }
        }

        //��ӷ�ҳ��ѯ
        sb.append(" limit ?,? ");
        //��ӷ�ҳ��ѯ����ֵ
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params);

        return template.query(sql,new BeanPropertyRowMapper<Course>(Course.class),params.toArray());
    }

	
}