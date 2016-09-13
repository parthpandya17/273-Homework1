package com.main.example.classes;

public class ArrayMarks
{

	private int nMarks[];

	public int[] getnMarks()
	{
		return nMarks;
	}

	public void setnMarks(int[] nMarks)
	{
		this.nMarks = nMarks;
	}

	public int getTotal()
	{
		int nSum = 0;
		if (nMarks != null)
		{
			for (int i = 0; i < this.nMarks.length; i++)
			{
				nSum += this.nMarks[i];
			}
		}
		return nSum;
	}

	public int getHighest()
	{
		int nHighest=0;
		if(nMarks != null)
		{
			nHighest=nMarks[0];
			for(int i = 0 ; i < this.nMarks.length-1; i++)
			{
				nHighest = (nMarks[i] > nMarks[i+1])? ( nMarks[i]):(nMarks[i+1]);
			}
			return nHighest;
		}
		return nHighest;
	}

}