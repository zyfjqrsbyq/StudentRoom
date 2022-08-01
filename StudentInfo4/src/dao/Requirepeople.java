package dao;
import java.util.List;
import java.util.Map;

import domain.Requirepeople;
public interface Requirepeople {
	public List<Requirepeople> findAll();

	   
    void add(Requirepeople Requirepeople);

    void delete(String reno);

    Requirepeople findById(String i);

    void update(Require Require);

    
    int findTotalCount(Map<String, String[]> condition);

    
    List<Requirepeople> findByPage(int start, int rows, Map<String, String[]> condition);

}


