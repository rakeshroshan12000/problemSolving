import java.util.*;
/* question 
find the weight of the given list with depth
eg :- {{1,1},2,{1,1}} = 10
		
		 2   			level = 1     1*2 = 2
		/ \
	   /   \
	(1,1)  (1,1)		level = 2      2 * ((1+1) + (1+1)) = 8

	total depth =10

eg 2 :- {2,{3,{4}}} 

		2		level 1       1 * 2 = 2
	   /		
	  /
	 3			level 2		  2 * 3 = 6
    /
   /
  4				level 3		  3 * 4 = 12


  total depth = 2 + 6 + 12 = 20

  */


  class depth {

	public static void main(String[] args) {
		List<Object> in = new ArrayList<>();
		in.add(new Integer(4));
		List<Object> in1 = new ArrayList<>();
		in1.add(new Integer(3));
		in1.add(in);
		List<Object> in2 = new ArrayList<>();
		in2.add(new Integer(2));
		in2.add(in1);
		findDepth(in2);



		
		List<Object> in4 = new ArrayList<>();
		in4.add(new Integer(1));
		in4.add(new Integer(1));

		List<Object> in5 = new ArrayList<>();
		in5.add(new Integer(1));
		in5.add(new Integer(1));

		List<Object> in3 = new ArrayList<>();
		in3.add(new Integer(2));
		in3.add(in4);
		in3.add(in5);
		findDepth(in3);		
	}
    public static void findDepth(List<Object> input) {
    	if(input == null && input.isEmpty()) {
    		System.out.println("Wrong input");
    	}
        System.out.println("Final sum :- " + calculateDepth(input,1,0));
    }

    public static int calculateDepth(List<Object> ip , int level , int sum) {
    	for(Object i : ip) {
    		if(isInteger(i)) {
    			sum = sum + (level * getInteger(i));
    			System.out.println("Recursive sum :- " +sum);
    			continue;
    		}
    		List<Object> t = getList(i);
    		sum = calculateDepth(t,level + 1 , sum);
    	}
    	return sum;
    }

    public static boolean isInteger(Object obj) {
    	if(obj instanceof Integer) {
    		return true;
    	}
    	return false;
    }

    public static boolean isList(Object obj) {
    	if(obj instanceof List) {
    		return true;
    	}
    	return false;
    }

    public static Integer getInteger(Object obj) {
    	return (Integer) obj;
    }

@SuppressWarnings("unchecked")
    public static List<Object> getList(Object obj) {
    	return (List) obj;
    }
}
