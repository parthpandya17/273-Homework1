package com.test.example.classses;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.main.example.classes.MultithreadedDateTimeServer;

public class MultithreadedDateTimeServerTest extends Thread
{
	static Date objDate = new Date();
	 
	@Test
	public void testdoIncrementRequestCount()
	{
		MultithreadedDateTimeServerTest objClients = null;
		List<MultithreadedDateTimeServerTest> threads = new ArrayList<MultithreadedDateTimeServerTest>();
		for(int i = 0 ; i < 9; i++)
		{
			objClients = new MultithreadedDateTimeServerTest();
			objClients.start();
			threads.add(objClients);
		}
		try
		{	for(MultithreadedDateTimeServerTest t : threads)
			t.join();
			System.out.println("Finished");
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		assertEquals(new Date().getDate(), objDate.getDate());
	}
	
	public void run(){
		try
		{
			Socket socket = new Socket("localhost", 1025);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			StringBuffer s = new StringBuffer();
			String tmp;
			while((tmp = dis.readLine()) != null)
			{
				s.append(tmp);
			}
			System.out.println(s.toString());
			objDate = new Date(s.toString());
		} catch (UnknownHostException e)
		{	
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}