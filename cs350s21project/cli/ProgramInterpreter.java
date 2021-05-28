package cs350s21project.cli;

import java.util.Arrays;
import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.*;
import cs350s21project.controller.command.munition.*;
import cs350s21project.datatype.*;

public class ProgramInterpreter {
	
	private AgentID _id; 
	private A_Command defCommand;
	private CommandManagers _managers;

	static public void programEvaluate(String command, String[] parsed) {
		//this method is used for determing what @metod to use
		ProgramInterpreter program = new ProgramInterpreter(command, parsed);
		program.execute();
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	//Add @* command methods down below
	public ProgramInterpreter(String command, String[] parsed) throws RuntimeException {
		_managers = CommandManagers.getInstance();
		
		if(parsed[0].equals("@load")) {//han
			
		}
		
		if(parsed[0].equals("@pause")) {//han
			
		}
		
		if(parsed[0].equals("@resume")) {//han
	
		}
		
		if(parsed[0].equals("@set")) {//han
	
		}
		
		if(parsed[0].equals("@wait")) {//han
	
		}
		
		if(parsed[0].equals("@force")) {//han
	
		}
		
		if(parsed[0].equals("@exit")) {//han
	
		}
		
		
		
	}
	
	public void execute() throws RuntimeException { // - Angel
		if(defCommand == null) {
			throw new RuntimeException("No Command Object was created in ProgramCommand Class constructor ");
		}
		_managers.getInstance().schedule(defCommand);
	}//end of execute
}
