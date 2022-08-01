package servlet;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import domain.PageBean;
import domain.Student;
import service.impl.StudentService;
import service.impl.StudentServiceImpl;

@WebServlet("/student")
public class StudentServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//��ѯ��������
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����service��ҵ�����
		request.setCharacterEncoding("utf-8");
		
        //1.��ȡ����
        String currentPage = request.getParameter("currentPage");//��ǰҳ��
        String rows = request.getParameter("rows");//ÿҳ��ʾ�ļ�¼��

        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }

        if(rows == null || "".equals(rows)){
            rows = "5";
        }
        
        //��ȡ������ѯ����
        Map<String, String[]> condition = request.getParameterMap();

        //2.����service������
        StudentService service = new StudentServiceImpl();
        PageBean<Student> pb = service.findStudentByPage(currentPage,rows,condition);

        //System.out.println(pb);

        //3.��PageBean����request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //4.ת����list.jsp
        request.getRequestDispatcher("/student_list.jsp").forward(request,response);
        

	}

	
	public void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
        request.setCharacterEncoding("UTF-8");
        //2.��ȡ����
        Map<String, String[]> map = request.getParameterMap();
        
        System.out.println(request.getParameter("gender"));
        //3.��װ����
        Student student = new Student();

        try {
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    
        //4.����Service����
        StudentService service = new StudentServiceImpl();
        service.addStudent(student);

        //5.��ת��userListServlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	
	public void delStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
        String id = request.getParameter("id");
        //2.����serviceɾ��
        StudentService service = new StudentServiceImpl();
        service.deleteStudent(id);

        //3.��ת����ѯ���е�Servlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	public void delSelectedStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ���е�id
        String[] ids = request.getParameterValues("id");

        //2.����serviceɾ��
        StudentService service = new StudentServiceImpl();
        service.delSelectedStudent(ids);

        //3.��ת����ѯ����Servlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        //2.��ȡmap
        Map<String, String[]> map = request.getParameterMap();
        //3.��װ����
        Student student = new Student();
        try {
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.����Service�޸�
        StudentService service = new StudentServiceImpl();
        service.updateStudent(student);

        //5.��ת����ѯ����Servlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	public void findStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
        String id = request.getParameter("id");
        //2.����Service��ѯ��
        StudentService service = new StudentServiceImpl();
        Student student = service.findStudentById(id);

        //3.��User����request
        request.setAttribute("student",student);
        //4.ת����update.jsp
        request.getRequestDispatcher("/student_update.jsp").forward(request,response);
	}
	
	public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userServlet��find����");
	}

}