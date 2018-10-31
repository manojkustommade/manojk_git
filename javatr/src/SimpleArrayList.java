import java.util.*;

public class SimpleArrayList {
      public static void main(String[] args) {
    	  
    	  ArrayList<Employee> items=new ArrayList<Employee>();
          items.add(new Employee("aaa",1239,200.99));
          items.add(new Employee("xaa",1239,33.88)); 
          items.add(new Employee("baa",1239,200.99));
          items.sort(new SortbyName());
       
          
          for(Employee e: items) {
        	  System.out.println(e.getName()+" "+e.getCode()+" "+e.getSalary());
          }
          /* 
          Iterator it=items.listIterator();
    	  while(it.hasNext()) { 
    		  Object obj=it.hasNext();
    		  if(obj instanceof Integer)
    		    System.out.print(obj);
    	  }*/
      }
}
