/*
search for student
compare GPA and name
*/
import java.util.*;

public class StudentSearch {
	static class Student {
		double GPA; String name;
		Student(double g, String n) { GPA = g; name = n; }		
		public String toString() { return String.format("%f, %s", GPA, name); }
	}

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		for(int i=0; i<10; i++) list.add(new Student((double)i/2, i + ""));

		Comparator<Student> comp = (s1, s2) -> {
			if(s1.GPA == s2.GPA) return s1.name.compareTo(s2.name);
			return Double.compare(s2.GPA, s1.GPA);
		};

		Collections.sort(list, comp);
		Student target = new Student(Double.parseDouble(args[0]), args[1]);
		System.out.println(Collections.binarySearch(list, target, comp));
		System.out.println(target);
		for(Student s : list) System.out.println(s);
	}
}