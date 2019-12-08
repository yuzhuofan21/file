package test;

public class Teacher extends Personal {
	Course course;
	public String toString(){
		System.out.println("teacher toString is operating");
		return id+name+sex+course;
	}
	public Teacher(int id, String name, String sex,Course course) {
		super(id, name, sex);
		this.course=course;
	}

}
