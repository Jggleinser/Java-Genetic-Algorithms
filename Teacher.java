package proj2KillMe;

import java.util.Random;

public class Teacher {
	final static String TEACHER_LIST[] = {"Hare", "Bingham", "Kuhail", "Mitchell", "Rao"};
	private String teacherName;
	Teacher(String name)
	{
		teacherName = name;
	}
	
	Teacher()
	{
		Random rand = new Random();
		teacherName = TEACHER_LIST[rand.nextInt(5)];
	}
	
	public boolean canTeach(String courseName)
	{
		courseName = courseName.substring(0, 6);
		if (teacherName == "Hare")
		{
			if (courseName.contentEquals("CS 101") || courseName.contains("CS 201") || courseName.contains("CS 291") || courseName.contains("CS 303") || courseName.contains("CS 449") || courseName.contains("CS 461"))
			{
				return true;
			}
			else
			{
				return false;
			}
				
		}
		if (teacherName == "Bingham")
		{
			if (courseName.contentEquals("CS 101") || courseName.contains("CS 201")  || courseName.contains("CS 191") || courseName.contains("CS 291") || courseName.contains("CS 449"))
			{
				return true;
			}
			else
			{
				return false;
			
			}
				
		}
		if (teacherName == "Kuhail")
		{
			if (courseName.contains("CS 303") || courseName.contains("CS 351"))
			{
				return true;
			}
			else
			{
				return false;
			}
				
		}
		if (teacherName == "Mitchell")
		{
			if (courseName.contains("CS 191") || courseName.contains("CS 303") || courseName.contains("CS 341") || courseName.contains("CS 461"))
			{
				return true;
			}
			else
			{
			
				return false;
			}
		}
		if (teacherName == "Rao")
		{
			if (courseName.contains("CS 291") || courseName.contains("CS 303") || courseName.contains("CS 341") || courseName.contains("CS 461"))
			{
				return true;
			}
			else
				return false;
		}
		return false;
	}
	
	public String getName()
	{
		return teacherName;
	}
	

}
