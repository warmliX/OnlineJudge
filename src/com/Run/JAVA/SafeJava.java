package com.Run.JAVA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SafeJava {
	public static String Safe(String text) {
		List<String> list=new ArrayList<String>();
		list.add("java.awt");
		list.add("java.io");
		list.add("java.net");
		list.add("java.rmi");
		list.add("Scanner");
		list.add("javax.imageio");
		list.add("javax.net");
		list.add("javax.swing");
		list.add("org.ietf.jgss");
		list.add("org.w3c");
		list.add("org.xml.sax");
		list.add("javax.sql");
		list.add("javax.sound");
		for (Iterator it = list.iterator(); it.hasNext();) {
			String string = (String) it.next();
			if(text.indexOf(string)!=-1) {
				return string;
			}
		}
		return "yes";
	}
}

