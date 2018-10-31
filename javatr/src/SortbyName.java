import java.util.*;

public class SortbyName implements Comparator<Employee> {
    
	public int compare(Employee o1,Employee o2) {
		int diff=o1.getName().compareTo(o2.getName());
		return diff;
	}
}
