package proj2KillMe;

import java.util.LinkedList;
import java.util.List;


public class Client {
	private static List<Schedule> schedules = new LinkedList<>();
	public static int trueMax;
	public static int count;
	private static Schedule bestSchedule;
	public static int generation;
	
	public static void main (String args[])
	{
		trueMax = 0;
		count = 0;
		populate();
		
		Breeding a = new Breeding(schedules);
	
		
		while (count < 3)
		{
			generation++;
			a.breedPopulation();
			a = new Breeding(a.getPop());
			getMetrics(a.getPop());
		}
		finalSchedule();
	}
	
	public static void populate()
	{
		for (int i = 0; i < 500; i++)
		{
			schedules.add(new Schedule());
		}
	}
	
	public static void finalSchedule()
	{
		Fitness j = new Fitness(bestSchedule, true);
		
	}
	
	public static int getMetrics(List<Schedule> sched)
	{
		int max = 0;
		int average = 0;
		for (Schedule nu : sched)
		{
			
			Fitness j = new Fitness(nu, false);
			if (j.getScore() > trueMax)
			{
				bestSchedule = nu;
			}
			if (j.getScore() > max)
			{
				max = j.getScore();
				
				
			}
			average += j.getScore();
		}
		if (max > trueMax)
		{
			trueMax = max;
			count = 0;
			;
		}
		else
		{
			count++;
		}
		average = average / sched.size();
		System.out.println("Generation: " + generation + " max is " + max);
		System.out.println("Generation: " + generation + " average is " + average);

		
		//System.out.println("Average is: " + average);
		return max;
	}

}
