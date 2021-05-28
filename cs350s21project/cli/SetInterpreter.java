package cs350s21project.cli;

import java.util.Arrays;
import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.*;
import cs350s21project.controller.command.munition.*;
import cs350s21project.datatype.*;

public class SetInterpreter {
	
	private AgentID _id; 
	private A_Command defCommand;
	private CommandManagers _managers;
	
	static public void setEvaluate(String command, String[] parsed) {
		//this method is used for determing what set metod to use
		SetInterpreter set = new SetInterpreter(command, parsed);
		set.execute();
	}
	//////////////////////////////////////////////////////////////////
	//add set command methods down below
	public SetInterpreter(String command, String[] parsed) throws RuntimeException {
		_managers = CommandManagers.getInstance();
		
		if(parsed[2].equals("course")) {//dustin
		 //todo	
		}
		
		if(parsed[2].equals("speed")) {//angel
			 //todo	
		}
		
		if(parsed[2].equals("altitude")||parsed[2].equals("depth")) {//angel
			 //todo	
		}
		
		if(parsed[2].equals("load")) {//angel
			 //todo	
		}
		
		if(parsed[2].equals("deploy")) {//angel
			 //todo	
		}
		
		
		
	}	
	
	public void execute() throws RuntimeException { // - Angel
		if(defCommand == null) {
			throw new RuntimeException("No Command Object was created in SetCommand Class constructor ");
		}
		_managers.getInstance().schedule(defCommand);
	}//end of execute
	
}
