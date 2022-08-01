package servlet;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.ClassNo;
import domain.PageBean;
import service.impl.ClassNoService;
import service.impl.ClassNoServiceImpl;

@WebServlet("/classno")
public class ClassNoServlet extends BaseServlet {
	
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
        ClassNoService service = new ClassNoServiceImpl();
        PageBean<ClassNo> pb = service.findClassNoByPage(currentPage,rows,condition);

        //System.out.println(pb);

        //3.��PageBean����request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //4.ת����list.jsp
        request.getRequestDispatcher("/classno_list.jsp").forward(request,response);
        
	}
	
	public void addClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
        request.setCharacterEncoding("UTF-8");
        //2.��ȡ����
        Map<String, String[]> map = request.getParameterMap();
        
        //3.��װ����
        ClassNo classNo = new ClassNo();

        try {
            BeanUtils.populate(classNo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    
        //4.����Service����
        ClassNoService service = new ClassNoServiceImpl();
        service.addClassNo(classNo);

        //5.��ת��userListServlet
        response.sendRedirect(request.getContextPath()+"/classno?method=findAll");
	}
	
	
	public void delClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
        String id = request.getParameter("id");
        //2.����serviceɾ��
        ClassNoService service = new ClassNoServiceImpl();
        service.deleteClassNo(id);

        //3.��ת����ѯ���е�Servlet
        response.sendRedirect(request.getContextPath()+"/classno?method=findAll");
	}
	
	public void delSelectedClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ���е�id
        String[] ids = request.getParameterValues("id");

        //2.����serviceɾ��
        ClassNoService service = new ClassNoServiceImpl();
        service.delSelectedClassNo(ids);

        //3.��ת����ѯ����Servlet
        response.sendRedirect(request.getContextPath()+"/classno?method=findAll");
	}
	
	public void updateClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
        request.setCharacterEncoding("utf-8");
        
        //2.��ȡmap
        Map<String, String[]> map = request.getParameterMap();
        //3.��װ����
        ClassNo classNo = new ClassNo();
        try {
            BeanUtils.populate(classNo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.����Service�޸�
        ClassNoService service = new ClassNoServiceImpl();
        service.updateClassNo(classNo);

        //5.��ת����ѯ����Servlet
        response.sendRedirect(request.getContextPath()+"/classno?method=findAll");
	}
	
	public void findClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
        String id = request.getParameter("id");
        //2.����Service��ѯ��
        ClassNoService service = new ClassNoServiceImpl();
        ClassNo classNo = service.findClassNoById(id);

        //3.��User����request
        request.setAttribute("classNo",classNo);
        //4.ת����update.jsp
        request.getRequestDispatcher("/classno_update.jsp").forward(request,response);
	}
	
	public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("classNoServlet��find����");
	}

}