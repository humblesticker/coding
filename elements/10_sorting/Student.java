// sort by name default, sort by GPA
import java.util.*;

public class Student implements Comparable<Student> {
	String name; double GPA;
	public Student(String n, double gpa) { name = n; GPA = gpa; }

	@Override
	public int compareTo(Student other) { return name.compareTo(other.name); }

	@Override 
	public String toString() { return name + ":" + GPA; }

	public static void main(String[] args) {
		List<Student> list = new LinkedList<>();
		list.add(new Student("brian", 4.0));
		list.add(new Student("ben", 2.0));
		list.add(new Student("susana", 3.0));
		Collections.sort(list);
		System.out.println(list);

		Collections.sort(list, (s1, s2) -> Double.compare(s2.GPA, s1.GPA));
		System.out.println(list);
	}
}