package com.Run.Ca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SafeCa {
	public static String Safe(String text) {
		List<String> list=new ArrayList<String>();
		list.add("FILE");
		list.add("cin");
		list.add("fstream.h");
		list.add("time.h");
		list.add("locale.h");
		list.add("istream");
		list.add("unistd.h");
		for (Iterator it = list.iterator(); it.hasNext();) {
			String string = (String) it.next();
			if(text.indexOf(string)!=-1) {
				return string;
			}
				
		}
		return "yes";
	}
}
