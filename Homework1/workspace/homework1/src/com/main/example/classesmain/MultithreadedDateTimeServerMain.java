package com.main.example.classesmain;

import java.net.ServerSocket;
import java.net.Socket;

import com.main.example.classes.MultithreadedDateTimeServer;

public class MultithreadedDateTimeServerMain
{

	public static void main(String[] args)
	{
		int nPort = Integer.parseInt(args[0]);
		try
		{
			MultithreadedDateTimeServer.ssocMasterSocket = new ServerSocket(nPort);
			//System.out.println("Server running at " + nPort);
			while(true)
			{
				Socket socTemp = MultithreadedDateTimeServer.ssocMasterSocket.accept();
				MultithreadedDateTimeServer clientthread = new MultithreadedDateTimeServer(socTemp);
				new Thread(clientthread).start();
				
				System.out.println(MultithreadedDateTimeServer.getnRequestCount());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}