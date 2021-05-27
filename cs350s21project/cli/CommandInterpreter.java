package cs350s21project.cli;

public class CommandInterpreter  {
	
	public void evaluate(String command) throws RuntimeException {
		String str = command;		
		String[] parsed = parse(str);
		//System.out.println(parsed[0]);
		
		//initial passing of the command to its next method.
		//each methods needs passed the command and the parsed string of the command.
		if(parsed[0].equals("create")) {
			System.out.println("we created");
			CreateInterpreter.createEvaluate(command, parsed);
			
		}else if(parsed[0].equals("define")) {
			System.out.println("we defined");
			DefineInterpreter.defineEvaluate(command, parsed);
			
		}else if(parsed[0].equals("set")) {
			System.out.println("setting");
			SetInterpreter.setEvaluate(command, parsed);
			
		}else if (parsed[0].equals("delete")) {
			System.out.println("deleteing");
			DeleteInterpreter.deleteEvaluate(command, parsed);
			
		}else if(parsed[0].charAt(0) == '@') {
			System.out.println("program command");
			ProgramInterpreter.programEvaluate(command, parsed);
			
		}else {
			System.out.println("Command not recognized");
		}	
		
		
		//String test = "hello";
		//TO-DO
		//System.out.println(test.charAt(0));
		
	/*	
		for(int i = 0; i < parsed.length; i ++) {
			System.out.println(parsed[i]);
			
			
		}
		
		String temp[] =  parseLatLong(parsed[7]);
		for(int i = 0; i < temp.length; i ++) {
			System.out.println(temp[i]);
		}
		
		String temp2[] =  parseLatLong(parsed[8]);
		for(int i = 0; i < temp2.length; i ++) {
			System.out.println(temp2[i]);
		}
		
		String temp3[] =  parseLatLong(parsed[9]);
		for(int i = 0; i < temp3.length; i ++) {
			System.out.println(temp3[i]);
		}
		
		String temp4[] =  parseLatLong(parsed[10]);
		for(int i = 0; i < temp4.length; i ++) {
			System.out.println(temp4[i]);
		}
		
		String temp5[] =  parseLatLong(parsed[11]);
		for(int i = 0; i < temp5.length; i ++) {
			System.out.println(temp5[i]);
		}
		
		String temp6[] =  parseLatLong(parsed[12]);
		for(int i = 0; i < temp6.length; i ++) {
			System.out.println(temp6[i]);			
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//CommandManagers m = new CommandManagers();
		//m.getInstance().schedule(new CommandMiscExit(m,"test"));
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
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String[] pCoordinates(String coords) {//splits coordinates into a string array(will need further parsing)
		String[] str = coords.split("/");
		return str;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String pParenthesis(String word) {//this can remove a parenthesis from the front or the end of a string or both-Dustin
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
}
