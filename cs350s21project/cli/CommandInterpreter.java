package cs350s21project.cli;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 
 * Han Zhang
VII. 1-7
I.   1,4


Dustin Lawton
IV. 1-8
II. 1,5,6


Angel Bermudez
III. 1-5, 7-9
II.  7,8
 */
//class project

/*
 * CS 350 Spring 2021 
 * Command Interpreter Team Project
 * Dr.Tappan
 * */

public class CommandInterpreter  {
	public void evaluate(String command) throws RuntimeException {
		
		/*The string {command} may have multiple commands 
		 *(i.e.. command = "define munition bomb b1; define munition bomb b2")
		 *where the ';' character indicates a different command. 
		 **/
		
		
		//String s = "define munition torpedo t1 with sensor s1 fuze f1 arming time 2.0; set a1 load munition t1"; // example
		
	    //	String mc[] = seperateCommands(s);
		
		//.out.println(Arrays.toString(mc));
		
	
		/*exampe for ProgramInterpreten:
		 * "@load filename"
		 * "@pause"
		 * "@resume"
		 * "@set update time 2.0"
		 * "@wait time 2.0"
		 * "@force fo1 state to 45*30'15"/110*30'10"/200 with course 090, 270 speed 2.0 "
		 * "@exit"
		 * -Han*/
		
		command = "define munition bomb b1";
		//System.out.println(ignoreComment(comment));
		
		
		String commandNotComment = ignoreComment(command);
		
		if(commandNotComment.length() > 0) { // if the string is a comment, ignore it, else treat is as a command. - Angel
		
		String ss[] = seperateCommands(commandNotComment);
		
		
		
		String commands[] = ss; //get the multiple commands - Angel 
		
		
		
		for(int i = 0; i < commands.length; i ++) { // For every command as described above.. - Angel
			String str = commands[i];
			
			String[] parsed = parse(str);
			
		
			//initial passing of the command to its next method.
			//each methods needs passed the command and the parsed string of the command.
			if(parsed[0].equals("create")) {
				//System.out.println("we created");
				CreateInterpreter.createEvaluate(str, parsed);
			
			}else if(parsed[0].equals("define")) {
				//System.out.println("we defined");
				DefineInterpreter.defineEvaluate(str, parsed);
			
			}else if(parsed[0].equals("set")) {
				//System.out.println("setting");
				SetInterpreter.setEvaluate(str, parsed);
			
			}else if (parsed[0].equals("delete")) {
				//System.out.println("deleteing");
				DeleteInterpreter.deleteEvaluate(str, parsed);
			
			}else if(parsed[0].charAt(0) == '@') {
				//System.out.println("program command");
				ProgramInterpreter.programEvaluate(str, parsed);
			
			}else {
				System.out.println("Command not recognized");
			}	
		}
		}
		else {
			System.out.println("COMMENT: " + command);
		}
		
		
		
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private String[] parse(String command) {
		String s[] = command.split(" ");
		
		
		for(int i = 0; i < s.length; i++) {
		
			s[i]=pParenthesis(s[i]);
		}
		return s;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static String[] parseLatLong(String str) {// this takes a latitude or longitude and splits it up into
		
		String s[] = new String[3];
		
		String temp[] = str.split(new String("\\*"));
		s[0] = temp[0];
		
		
		temp = temp[1].split("\'");
		s[1] = temp[0];
		
		temp = temp[1].split("#");
		s[2] = temp[0];

		return s;
		
		
	} 
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static String[] pCoordinates(String coords) {//splits coordinates into a string array(will need further parsing)
		String[] str = coords.split("/");
		return str;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String pParenthesis(String word) {//this can remove a parenthesis from the front or the end of a string or both-Dustin
		String str = word;
		
		//System.out.println("Start: " + str);
		
		if(str.charAt(0) == '(' ) {
			String[] temp = str.split("\\(");
			//System.out.println("Open parenthesis removed: " + temp[1]);
			str = temp[1];
		}
		if(str.charAt(str.length()-1) == ')') {
			String[] temp2 = str.split("\\)");			
			//System.out.println("Closed parenthesis removed: " + temp2[0]);
			str = temp2[0];
		}
		//System.out.println("Final String: " + str);
		return str;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String[] seperateCommands(String _command) { //Return a list of string commands - Angel
		int lastIndex = 0;
		ArrayList<String> _commands = new ArrayList<String>();
		for(int i = 0; i < _command.length(); i++) {
			if(_command.charAt(i) == ';' || i == _command.length()-1) {
				String temp; 
				if(_command.charAt(i) == ';') {
					 temp = _command.substring(lastIndex, i);
					
				}
				else
				{
					 temp = _command.substring(lastIndex, i+1);
				}
				//System.out.println("printing temp " + temp);
				lastIndex = i+1;
				_commands.add(temp);
			}
			
		}
		
		//
		if(_commands.isEmpty()) { // no splitting was done - EDGE CASE
			_commands.add(_command);
		}
		
		
		
		
		for(int i = 0; i < _commands.size(); i ++) {
			if(_commands.get(i).charAt(0) == ' ') { 
				_commands.set(i, _commands.get(i).substring(i, _commands.get(i).length()));
				
			}
		}
		return _commands.toArray(new String[0]);
	}
	
	static String[] stringArrayToArray(String s) {
		String temp = s.substring(1, s.length()-1);
		temp = temp.substring(0, s.length()-2);
		
		String arr[] = temp.split(", ");
		return arr;
	}
	
	public String ignoreComment(String cmd) { // check to see if the string is a comment, if it is return an empty string, if it is not, then return the actual command/s string
		if(cmd.charAt(0) == '/' && cmd.charAt(1) == '/') { // its a comment denoted by: '//' - Angel
			return ""; //returning an empty string
		}
		return cmd; 
		
	}
	
}

