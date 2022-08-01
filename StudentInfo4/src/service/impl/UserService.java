package service.impl;


import java.util.List;
import java.util.Map;

import domain.PageBean;
import domain.User;


/**
 * �û������ҵ��ӿ�
 */
public interface UserService {

    /**
     * ��ѯ�����û���Ϣ
     * @return
     */
    public List<User> findAll();

    /**
     * ��¼����
     * @param user
     * @return
     */
    User loginUser(User user);

    /**
     * ����User
     * @param user
     */
    void addUser(User user);

    /**
     * ע��User
     * @param user
     */
    void registUser(User user);
    
    /**
     * ����idɾ��User
     * @param id
     */
    void deleteUser(String id);

    /**
     * ����id��ѯ
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * �޸��û���Ϣ
     * @param user
     */
    void updateUser(User user);

    /**
     * ����ɾ���û�
     * @param ids
     */
    void delSelectedUser(String[] ids);

    /**
     * ��ҳ������ѯ
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}

