package com.main.example.classesmain;

import java.util.LinkedList;

import com.main.example.classes.QueueTheatre;

public class QueueTheatreMain
{

	public static void main(String[] args)
	{
		QueueTheatre objQueueTheatre = new QueueTheatre();
		objQueueTheatre.setLine(new LinkedList<String>());
		objQueueTheatre.addToline("Parth");
		objQueueTheatre.addToline("Kemy");
		objQueueTheatre.addToline("Hriday");
		objQueueTheatre.addToline("Rini");
		objQueueTheatre.addToline("Meet");

		System.out.println("Status of line: " + objQueueTheatre.getLine());

		String sPerson;
		while (objQueueTheatre.getLine().size() > 0)
		{
			sPerson = objQueueTheatre.getFirst();
			System.out.println("Verfying  " + sPerson);
			if (sPerson.length() != 4)
			{
				System.out.println("Not eligible for movie, removing from queue: " + objQueueTheatre.removeFromLine());
			} else
			{
				System.out.println("Ticket issued to " + objQueueTheatre.issueTicket());
			}
		}
	}
}
