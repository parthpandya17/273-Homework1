package com.main.example.classesmain;

import com.main.example.classes.Generics;

public class GenericsMain
{

	public static void main(String[] args)
	{
		Generics<String> g1 = new Generics<String>();
		Generics<Integer> g2 = new Generics<Integer>();
		g1.settFlagValue("Not Available");
		System.out.println(g1.gettFlagValue());
		g2.settFlagValue(0);
		System.out.println(g2.gettFlagValue());
	}
}