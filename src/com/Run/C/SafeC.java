package com.Run.C;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SafeC {
	public static String Safe(String text) {
		List<String> list=new ArrayList<String>();
		list.add("FILE");
		list.add("scanf");
		list.add("fstream.h");
		list.add("time.h");
		list.add("locale.h");
		list.add("sscanf");
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
