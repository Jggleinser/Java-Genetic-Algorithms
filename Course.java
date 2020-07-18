package proj2KillMe;

import java.util.Random;

public class Course {

	final static String[] COURSE_TIME = {"10A", "11A", "12P", "1P", "2P", "3P", "4P"};
	private Room courseRoom;
	private Teacher courseTeacher;
	private String courseTime;
	private String courseName;
	Course(String name)
	{
		courseName = name;
		courseRoom = new Room();
		courseTeacher = new Teacher();
		courseTime = pickRandomTime();
	}
	
	private String pickRandomTime()
	{
		Random rand = new Random();
		return COURSE_TIME[rand.nextInt(7)];
	}
	
	public void printCourseInfo()
	{
		System.out.println("Name: " + courseName);
		System.out.println("Time: " + courseTime);
		System.out.println("Teacher: " + courseTeacher.getName());
		System.out.println("Room: " + courseRoom.getName());
		System.out.println();
	}
	
	public Teacher getTeacher()
	{
		return courseTeacher;
	}
	
	public void setTeacher(Teacher toSet)
	{
		courseTeacher = toSet;
	}
	
	public void setRoom(Room toSet)
	{
		courseRoom = toSet;
	}
	
	public void setTime (String toSet)
	{
		courseTime = toSet;
	}
	public String setTime ()
	{
		Random rand = new Random();
		return COURSE_TIME[rand.nextInt(7)];
	}
	
	public Room getRoom()
	{
		return courseRoom;
	}
	
	public String getName()
	{
		return courseName;
	}
	
	public String getTime()
	{
		return courseTime;
	}

	
	
	
}
