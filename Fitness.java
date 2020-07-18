package proj2KillMe;

import java.util.LinkedList;
import java.util.List;

public class Fitness {
	private int points;
	private int minusFivePercent;
	private int minusTenPercent;
	private int plusFivePercent;
	private int minusThreePercent;
	private boolean shouldPrint;
	Fitness(Schedule test, Boolean b)
	{
		shouldPrint = b;
		points = 0;
		minusFivePercent = 0;
		minusTenPercent = 0;
		minusThreePercent = 0;
		plusFivePercent = 0;
		teachersQualified(test);
		roomsOccupied(test);
		roomBigEnough(test);
		teacherBusy(test);
		teacherWorkLoad(test);
		cs101cs191Exceptions(test);
		applyModifiers();
	}
	
public int getScore()
{
	return points;
}

public void applyModifiers()
{
	double pointTotal = (double) points;
	int percent = minusFivePercent * -5 + minusTenPercent * -10 + minusThreePercent * -3 + plusFivePercent * 5;
	if (percent > 0)
	{
		pointTotal = (double) points;
		pointTotal = pointTotal * (1.00+percent/100.0);
	}
	else if (percent < 0)
	{
		pointTotal = (double) points;
		pointTotal = pointTotal * (1.00-percent*-1.0/100.0);
	}
	points = (int) pointTotal;
}
public void teachersQualified(Schedule test)
{
	for (Course s : test.getCourses())
	{
	
		if (s.getTeacher().canTeach(s.getName()))
		{
			points = points + 3;
		}
		else
		{
			if (shouldPrint)
			{
				System.out.println("Instructor not qualified to teach a course");
			}
		}
	
	}
}

public void roomsOccupied(Schedule test)
{
	int pointsToDistribute = 60;
	for (int i = 0; i < test.getCourses().size(); i++)
	{
		for (int j = i+1; j < test.getCourses().size(); j++)
		{
			if (test.getCourses().get(i).getRoom().getName().contentEquals(test.getCourses().get(j).getRoom().getName()))
			{
				if (test.getCourses().get(i).getTime().contentEquals(test.getCourses().get(j).getTime()))
				{
					pointsToDistribute -= 5;
				}
				else
				{
				}
			}
		}
	}
	
	points += pointsToDistribute;
}

public void roomBigEnough(Schedule test)
{
	for (Course s : test.getCourses())
	{
		if (s.getRoom().canOccupy(s.getName()))
		{
			points+=5;
			if (s.getRoom().canOccupyDouble(s.getName()))
			{
				points += 2;
			}
		}
		else
		{
			if (shouldPrint)
			{
				System.out.println("Room is not big enough");
			}
		}
	}
}

public void teacherBusy(Schedule test)
{
	int pointsToDistribute = 60;
	for (int i = 0; i < test.getCourses().size(); i++)
	{
		for (int j = i+1; j < test.getCourses().size(); j++)
		{
			if (test.getCourses().get(i).getTeacher().getName().contentEquals(test.getCourses().get(j).getTeacher().getName()))
			{
				if (test.getCourses().get(i).getTime().contentEquals(test.getCourses().get(j).getTime()))
				{
					pointsToDistribute -= 5;
				}
				
			}
		}
	}
	points += pointsToDistribute;
}

public void teacherWorkLoad(Schedule test)
{
	int kuhailCount = 0;
	int mitchellCount = 0;
	int binghamCount = 0;
	int hareCount = 0;
	int raoCount = 0;
	
	for (Course s : test.getCourses())
	{
		if (s.getTeacher().getName().contains("Rao"))
		{
			raoCount++;
		}
		else if (s.getTeacher().getName().contains("Bingham"))
		{
			binghamCount++;
		}
		else if (s.getTeacher().getName().contains("Mitchell"))
		{
			mitchellCount++;
		}
		else if (s.getTeacher().getName().contains("Hare"))
		{
			hareCount++;
		}
		else if (s.getTeacher().getName().contains("Kuhail"))
		{
			kuhailCount++;
		}
	}
	
	if (kuhailCount > 4)
	{
		for (int i = 4; i < kuhailCount; i++)
		{
			points-=5;
			if (shouldPrint)
			{
				System.out.println("Instructor has too many courses");
			}
		}
	}
	if (raoCount > 4)
	{
		for (int i = 4; i < raoCount; i++)
		{
			points-=5;
			if (shouldPrint)
			{
				System.out.println("Instructor has too many courses");
			}
		}
	}
	if (hareCount > 4)
	{
		for (int i = 4; i < hareCount; i++)
		{
			points-=5;
			if (shouldPrint)
			{
				System.out.println("Instructor has too many courses");
			}
		}
	}
	if (mitchellCount > 4)
	{
		for (int i = 4; i < mitchellCount; i++)
		{
			points-=5;
			if (shouldPrint)
			{
				System.out.println("Instructor has too many courses");
			}
		}
	}
	if (binghamCount > 4)
	{
		for (int i = 4; i < binghamCount; i++)
		{
			points-=5;
			if (shouldPrint)
			{
				System.out.println("Instructor has too many courses");
			}
		}
	}
	
	if (raoCount + mitchellCount > hareCount + binghamCount)
	{
		minusFivePercent++;
	}
	
}

public void binghamMorningPreference(Schedule test)
{
	for (int i = 0; i < test.getCourses().size(); i++)
	{
		if (test.getCourses().get(i).getTeacher().getName().contentEquals("Bingham") )
		{
			if (test.getCourses().get(i).getTime().contentEquals("10A") || test.getCourses().get(i).getTime().contentEquals("11A") )
			{
				points+=5;
			}
		}
	}
}

public void hareDislikesRoyall(Schedule test)
{
	for (int i = 0; i < test.getCourses().size(); i++)
	{
		if (test.getCourses().get(i).getTeacher().getName().contentEquals("Hare") )
		{
			if (test.getCourses().get(i).getRoom().getName().contains("Royall") )
			{
				points-=5;
				
			}
		}
	}
}

public void cs101cs191Exceptions(Schedule test)
{
	for (int i = 0; i < test.getCourses().size(); i++)
	{
		for (int j = i+1; j < test.getCourses().size(); j++)
		{
			if (test.getCourses().get(i).getName().contains("CS 101") && test.getCourses().get(j).getName().contains("CS 191"))
			{
				String time1 = test.getCourses().get(i).getTime();
				String time2 = test.getCourses().get(j).getTime();
				String room1 = test.getCourses().get(i).getRoom().getName();
				String room2 = test.getCourses().get(i).getRoom().getName();
				
				if (time1.contentEquals(time2))
				{
					minusTenPercent++;
					if (shouldPrint)
					{
						System.out.println ("There is more than 1 class in the same room at the same time");
						
					}
					
				}
				if (time1.contentEquals("10A") && time2.contentEquals("11A"))
				{
					buildingCheck(room1, room2);
					plusFivePercent++;
				}
				else if (time1.contentEquals("11A") && time2.contentEquals("12P"))
				{
					buildingCheck(room1, room2);
					plusFivePercent++;
				}
				else if (time1.contentEquals("12P") && time2.contentEquals("1P"))
				{
					buildingCheck(room1, room2);
					plusFivePercent++;
				}
				else if (time1.contentEquals("1P") && time2.contentEquals("2P"))
				{
					buildingCheck(room1, room2);
					plusFivePercent++;
				}
				else if (time1.contentEquals("2P") && time2.contentEquals("3P"))
				{
					buildingCheck(room1, room2);
					plusFivePercent++;
				}
				else if (time1.contentEquals("3P") && time2.contentEquals("4P"))
				{
					buildingCheck(room1, room2);
					plusFivePercent++;
				}
				
			}
		}
	}
}

public void buildingCheck(String roomA, String roomB)
{
	if (roomA.contentEquals(roomB))
	{
		points+=5;
		
	}
	else if (roomA.contains("Katz"))
	{
	
		if (roomB.contains("Bloch"))
		{
			minusThreePercent++;
		}
		if (!roomB.contains("Katz"))
		{
			minusThreePercent++;
		}
	}
	else if (roomA.contains("Bloch") )
	{
		if (roomB.contains("Katz"))
		{
			minusThreePercent++;
		}
		if (!roomB.contains("Bloch"))
		{
			minusThreePercent++;
		}
	}
}

}