package dao.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.StudentDao;
import domain.Student;
import util.JDBCUtils;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Student> findAll() {
        //ʹ��JDBC�������ݿ�...
        //1.����sql
        String sql = "select * from student";
        List<Student> student = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        return student;
    }

    

    @Override
    public void add(Student student) {
        //1.����sql
        String sql = "insert into student values(null,?,?,?,?,?,?)";
        //2.ִ��sql
        template.update(sql,student.getName(), student.getGender(), student.getAge(), student.getClassno(), student.getPhone(), student.getEmail());
    }
    
    @Override
    public Student findById(int id) {
        String sql = "select * from student where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
    }

    @Override
    public void update(Student student) {
        String sql = "update student set name = ?,gender = ? ,age = ? , classno = ? , phone = ?, email = ? where id = ?";
        template.update(sql, student.getName(), student.getGender(), student.getAge(), student.getClassno(), student.getPhone(), student.getEmail(), student.getId());
    }
    

    @Override
    public void delete(int id) {
        //1.����sql
        String sql = "delete from student where id = ?";
        //2.ִ��sql
        template.update(sql, id);
    }

  

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.����ģ���ʼ��sql
        String sql = "select count(*) from student where 1 = 1 ";
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
    public List<Student> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from student  where 1 = 1 ";

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

        return template.query(sql,new BeanPropertyRowMapper<Student>(Student.class),params.toArray());
    }

	
}
