package dao;


import java.util.List;

import java.util.Map;

import domain.User;

public interface UserDao {


    public List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);
    
    void registUser(User user);

    void delete(int id);

    User findById(int i);

    void update(User user);

  
    int findTotalCount(Map<String, String[]> condition);

   
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}

