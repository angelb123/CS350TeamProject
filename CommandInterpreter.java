package cs350s21project.cli;
import java.util.*;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.misc.CommandMiscExit;

public class CommandInterpreter  {
	
	public void evaluate(String command) throws RuntimeException {
		String str = "create window wTop top view with 200 (49*39'32# 0*10'0# 0*0'30#) (117*25'30# 0*10'0# 0*0'30#)";
		
		String[] parsed = parse (str);
		
		//String test = "hello";
		//TO-DO
		//System.out.println(test.charAt(0));
		
		
		for(int i = 0; i < parsed.length; i ++) {
			System.out.println(parsed[i]);
			
			
		}
		
		String temp[] =  parseLatLong(parsed[8]);
		for(int i = 0; i < temp.length; i ++) {
			System.out.println(temp[i]);
			
			
		}
		
		//CommandManagers m = new CommandManagers();
		//m.getInstance().schedule(new CommandMiscExit(m,"test"));
	}
	
	
	private String[] parse(String command) {
		String s[] = command.split(" ");
		return s;
	}
	
	public String[] parseLatLong(String str) {// this takes a latitude or longitude and splits it up into
		
		String s[] = new String[3];
		
		String temp[] = str.split(new String("\\*"));
		s[0] = temp[0];
		
		temp = temp[1].split("\'");
		
		s[1] = temp[0];
		
		temp = temp[1].split("#");
		
		s[2] = temp[0];

		return s;
		
		
	} 
	
	
	public String[] pCoordinates(String coords) {
		return null ;
	}
	
	public String pParenthesis(Srting word) {//this can remove a parenthesis from the front or the end of a string or both-Dustin
		String str = word;
		
		System.out.println("Start: " + str);
		
		if(str.charAt(0) == '(' ) {
			String[] temp = str.split("\\(");
			System.out.println("Open parenthesis removed: " + temp[1]);
			str = temp[1];
		}
		if(str.charAt(str.length()-1) == ')') {
			String[] temp2 = str.split("\\)");			
			System.out.println("Closed parenthesis removed: " + temp2[0]);
			str = temp2[0];
		}
		System.out.println("Final String: " + str);
		return str;
	}
	
}
