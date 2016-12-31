/*
search for student List<Student> assume sorted
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
		
	}
}