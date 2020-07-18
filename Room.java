package proj2KillMe;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Room {
	final static String ROOM_LIST[] = {"Haag 301", "Haag 206", "Royall 204", "Katz 209", "Flarsheim 310", "Flarsheim 260", "Bloc 0009"};
	final static Integer OCCUPANCY[] = {70, 30, 70, 50, 80, 25, 30};
	final private String roomName;
		Room(String name)
		{
			roomName = name;
		}
		Room()
		{
			Random rand = new Random();
			roomName = ROOM_LIST[rand.nextInt(7)];
		}
		
		boolean canOccupy(String className)
		{
			int expected = getExpected(className);
			for (int i = 0; i < ROOM_LIST.length; i++)
			{
				if (ROOM_LIST[i] == roomName)
				{
					if (OCCUPANCY[i] >= expected)
					{
						return true;
					}
				}
			}
			return false;
		}
		
		public Room getRandomRoom()
		{
			Random rand = new Random();
			Room r = new Room();
			return r;
		}
		
		public int getExpected(String className)
		{
			int expected = 0;
			if (className.contains("CS 101A") || className.contains("CS 291B") || className.contains("CS 341") || className.contains("CS 461"))
			{
				expected = 40;
			}
			else if (className.contains("CS 101B"))
			{
				expected = 25;
			}
			else if (className.contains("CS 201A") || className.contains("CS 201B"))
			{
				expected = 30;
			}
			else if (className.contains("CS 191A"))
			{
				expected = 60;
			}
			else if (className.contains("CS 191B") || className.contains("CS 291A"))
			{
				expected = 20;
			}
			else if (className.contains("CS 303"))
			{
				expected = 50;
			}
			else if (className.contains("CS 449"))
			{
				expected = 55;
			}
			return expected;
		}
		boolean canOccupyDouble(String className)
		{
			int expected = getExpected(className);
		
			
			for (int i = 0; i < ROOM_LIST.length; i++)
			{
				if (ROOM_LIST[i] == roomName)
				{
					if (OCCUPANCY[i] >= expected && OCCUPANCY[i] <= expected*2)
					{
						return true;
					}
				}
			}
			return false;
		}
		
		public String getName()
		{
			return roomName;
		}
	
}
