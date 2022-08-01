package dao;
import java.util.List;
import java.util.Map;

public interface Require {
	public List<Require> findAll();

	   
    void add(Require Require);

    void delete(String rpno);

    Require findById(String i);

    void update(Require Require);

    
    int findTotalCount(Map<String, String[]> condition);

    
    List<Require> findByPage(int start, int rows, Map<String, String[]> condition);

}
