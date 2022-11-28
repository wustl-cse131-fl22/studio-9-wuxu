package studio9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import assignment7.Student;


public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map map = new HashMap<String, Student>();
	
	
	public void addStudent(String accountName, Student student) {
			map.put(accountName, student);

	}

	public int getStudentCount() {
		return map.size();
	}

	public String lookupFullName(String accountName) {
		if (map.containsKey(accountName)) {
			Student a = (Student) map.get(accountName);
			return a.getFullName();
			
		} else {
			return null;
		}
	}

	public double getTotalBearBucks() {
		double sum = 0.0;
		
		for (String name : (Set<String>)map.keySet()) {
			name = (String)name;
			Student b = (Student) map.get(name);
			sum += b.getBearBucksBalance();
		}
//		for (Entry<String,Student> a : map.entrySet()) {
//			
//		}
		return sum;
	}
}
