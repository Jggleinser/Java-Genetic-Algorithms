package proj2KillMe;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Breeding {
	
	List<Double> fitnessTracker = new LinkedList<>();
	List<Schedule> scheduledList = new LinkedList<>();
	
	Breeding(List<Schedule> scheduledListVar)
	{
		for (int i = 0; i < scheduledListVar.size(); i++)
		{
			scheduledList.add(scheduledListVar.get(i));
		}
	}
	
public void normalize (List <Schedule> fitness)
{
	fitnessTracker.clear();
	List<Double> fitnessTrackerTemp = new LinkedList<>();
	Double sum = 0.0;
	for (Schedule s : fitness)
	{
		Integer score = new Fitness(s, false).getScore();
		score = score * score;
		sum += score;
		
		fitnessTrackerTemp.add(score.doubleValue());
	}
	
	for (int i = 0; i < fitnessTrackerTemp.size(); i++)
	{
		Double val = (Double) fitnessTrackerTemp.get(i);
		Double val2 = (Double) sum;
		Double val3 = val / val2;
		fitnessTrackerTemp.set(i, val3);
		
		
	}
	
	for (int k = 0; k < fitnessTrackerTemp.size(); k++)
	{
		if (k == 0)
		{
			fitnessTracker.add(fitnessTrackerTemp.get(k));
		}
		else
		{
		
			Double val1 = fitnessTrackerTemp.get(k);
			Double val2 = fitnessTrackerTemp.get(k-1);
			
			Double val3 = val1 + val2;
			fitnessTrackerTemp.set(k, val3 );
			
			fitnessTracker.add(fitnessTrackerTemp.get(k));
			
		}
	}
	
}

public int getFit()
{
	Random rand = new Random();
	Double d = rand.nextDouble();
	int k = 0;
	for (int i = 0; i < fitnessTracker.size(); i++)
	{
	
		if (d > fitnessTracker.get(i) && d < fitnessTracker.get(i+1))
		{
			k = i;
		}
	
	}

	return k;
	
}

public Schedule crossOver (Schedule a, Schedule b)
{
	Schedule c = new Schedule(a);
	Random rand = new Random();
	Integer rando = rand.nextInt(a.getCourses().size());
	for (int i = 0; i < rando; i++)
	{
		
		c.getCourses().get(i).setRoom(b.getCourses().get(i).getRoom());
	
		if (rando > .5)
		{
			c.getCourses().get(i).setTime(b.getCourses().get(i).getTime());
		}
		else if (rando < .2)
		{
			c.getCourses().get(i).setTeacher(b.getCourses().get(i).getTeacher());
		}
		
		mutate();
		
	}
	
	return c;
	
}

public void mutate()
{
	Random rand = new Random();
	if (rand.nextDouble() > .98)
	{
		scheduledList.get(rand.nextInt(scheduledList.size())).getCourses().get(rand.nextInt(12)).setRoom(new Room());
		scheduledList.get(rand.nextInt(scheduledList.size())).getCourses().get(rand.nextInt(12)).setTeacher(new Teacher());
		scheduledList.get(rand.nextInt(scheduledList.size())).getCourses().get(rand.nextInt(12)).setTime();
		
	}
}

public void breedPopulation ()
{
	normalize(scheduledList);
	List<Schedule> tempList = new LinkedList<>();
	for (int i = 0; i < scheduledList.size(); i++) 
	{
		tempList.add(crossOver(scheduledList.get(getFit()), scheduledList.get(getFit())));	
	}
	for (int i = 0; i < scheduledList.size(); i++)
	{
		scheduledList.set(i, tempList.get(i));
	}

}

public List <Schedule> getPop()
{
	return scheduledList;
}
}

