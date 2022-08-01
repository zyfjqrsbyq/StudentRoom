package dao;
import java.util.List;
import java.util.Map;

import domain.Student;
public interface RoomProperty {
	public List<RoomProperty> findAll();

	   
    void add(RoomProperty RoomProperty);

    void delete(String rpno);

    Student findById(String i);

    void update(RoomProperty RoomProperty);

    
    int findTotalCount(Map<String, String[]> condition);

    
    List<RoomProperty> findByPage(int start, int rows, Map<String, String[]> condition);



}
