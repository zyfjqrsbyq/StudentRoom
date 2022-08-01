package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import domain.PageBean;
import domain.User;
import service.impl.UserService;
import service.impl.UserServiceImpl;


@WebServlet("/user")
public class UserServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage,rows,condition);

        //System.out.println(pb);

        //3.��PageBean����request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);//将查询条件存入request
        //4.ת����list.jsp
        request.getRequestDispatcher("/user_list.jsp").forward(request,response);
	}
	
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
        request.setCharacterEncoding("utf-8");
        //2.��ȡ����
        Map<String, String[]> map = request.getParameterMap();
        //3.��װ����
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.����Service����
        UserService service = new UserServiceImpl();
        service.addUser(user);

        //5.��ת��userListServlet
        response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	
	
	public void registUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
        request.setCharacterEncoding("utf-8");
        //2.��ȡ����
        Map<String, String[]> map = request.getParameterMap();
        //3.��װ����
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.����Service����
        UserService service = new UserServiceImpl();
        service.registUser(user);

        //5.��ת��userListServlet
        response.sendRedirect(request.getContextPath()+"/user_login.jsp");
	}
	
	public void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
        String id = request.getParameter("id");
        //2.����serviceɾ��
        UserService service = new UserServiceImpl();
        service.deleteUser(id);

        //3.��ת����ѯ���е�Servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
	}
	
	public void delSelectedUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ���е�id
        String[] ids = request.getParameterValues("uid");
        //2.����serviceɾ��
        UserService service = new UserServiceImpl();
        service.delSelectedUser(ids);

        //3.��ת����ѯ����Servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
	}
	
	
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
        request.setCharacterEncoding("utf-8");
        //2.��ȡmap
        Map<String, String[]> map = request.getParameterMap();
        //3.��װ����
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.����Service�޸�
        UserService service = new UserServiceImpl();
        service.updateUser(user);
        

        //5.��ת����ѯ����Servlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	public void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		
        //1.���ñ���
        request.setCharacterEncoding("utf-8");

        //2.��ȡ����
        //2.1��ȡ�û���д��֤��
        String verifycode = request.getParameter("verifycode");

        //3.��֤��У��
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//ȷ����֤��һ����
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //��֤�벻��ȷ
            //��ʾ��Ϣ
            request.setAttribute("login_msg","��֤�����");
            //��ת��¼ҳ��
            request.getRequestDispatcher("/user_login.jsp").forward(request,response);

            return;
        }

        Map<String, String[]> map = request.getParameterMap();
        //4.��װUser����
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //5.����Service��ѯ
        UserService service = new UserServiceImpl();
        User loginUser = service.loginUser(user);
        //6.�ж��Ƿ��¼�ɹ�
        if(loginUser != null){
            //��¼�ɹ�
            //���û�����session
            session.setAttribute("user",loginUser);
            //��תҳ��
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            //��¼ʧ��
            //��ʾ��Ϣ
            request.setAttribute("login_msg","�û������������");
            //��ת��¼ҳ��
            request.getRequestDispatcher("/user_login.jsp").forward(request,response);

        }
	}
	
	public void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡid
        String id = request.getParameter("id");
        //2.����Service��ѯ��
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);

        //3.��User����request
        request.setAttribute("user",user);
        //4.ת����update.jsp
        request.getRequestDispatcher("/user_update.jsp").forward(request,response);
	}
	
	public void destroyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //ɾ���û���Ϣ
        request.removeAttribute("user");
        //ת����update.jsp
        request.getRequestDispatcher("/user_login.jsp").forward(request,response);
	}
	
	
	
	public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userServlet��find����");
	}
	
	
}
	
	