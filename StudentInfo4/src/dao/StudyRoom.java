package dao;
import java.util.List;
import java.util.Map;

import domain.StudyRoom;

public interface StudyRoom {
	 public List<StudyRoom> findAll();

	   
	    void add(StudyRoom StudyRoom);

	    void delete(String srno);

	    StudyRoom findById(String i);

	    void update(StudyRoom StudyRoom);

	    
	    int findTotalCount(Map<String, String[]> condition);

	    
	    List<StudyRoom> findByPage(int start, int rows, Map<String, String[]> condition);
	
}
