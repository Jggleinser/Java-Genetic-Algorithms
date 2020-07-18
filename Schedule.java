package proj2KillMe;

import java.util.LinkedList;
import java.util.List;

public class Schedule {
	final static String[] COURSE_LIST = {"CS 101A", "CS 101B", "CS 201A", "CS 201B", "CS 191A", "CS 191B", "CS 291B", "CS 291A", "CS 303", "CS 341", "CS 449", "CS 461"};
	private List<Course> completeSchedule = new LinkedList<>();
	Schedule()
	{
		for (String courseName : COURSE_LIST)
		{
			completeSchedule.add(new Course(courseName));
		}
		
	}
	Schedule(Schedule a)
	{
		for (Course b : a.getCourses())
		{
			completeSchedule.add(b);
		}
	}
	
	public List<Course> getCourses()
	{
		return completeSchedule;
	}
	
	
	
}
