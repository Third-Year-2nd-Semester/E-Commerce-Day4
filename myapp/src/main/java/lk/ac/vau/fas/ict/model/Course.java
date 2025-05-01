package lk.ac.vau.fas.ict.model;

public class Course {
	private int CourseId;
	private String Coursename;
	public Course(int courseId, String coursename) {
		super();
		CourseId = courseId;
		Coursename = coursename;
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getCoursename() {
		return Coursename;
	}
	public void setCoursename(String coursename) {
		Coursename = coursename;
	}
	
}
