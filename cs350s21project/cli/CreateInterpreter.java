package cs350s21project.cli;

import java.util.Arrays;
import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.*;
import cs350s21project.controller.command.munition.*;
import cs350s21project.datatype.*;

public class CreateInterpreter {
	
	private AgentID _id; 
	private A_Command defCommand;
	private CommandManagers _managers;
	
	static public void createEvaluate(String command, String[] parsed) {
		//this method is used for determing what create method to use
		CreateInterpreter create = new CreateInterpreter(command, parsed);
		create.execute();
	}
	//////////////////////////////////////////////////////////////////////
	//Add create command methods down below
	public CreateInterpreter(String command, String[] parsed) throws RuntimeException {
		_managers = CommandManagers.getInstance();
		
		if(parsed[1].equals("window")) {//han
		//create window id top view with size (latitude1 latitude2 latitude3) (longitude1 longitude2 longitude3)
			
		}
		
		
		
		if(parsed[1].equals("actor")) {//Dustin
		//create actor id1 from id2 at coordinates with course course speed speed
			
		}
		
		
		
	}
	
	public void execute() throws RuntimeException { // - Angel
		if(defCommand == null) {
			throw new RuntimeException("No Command Object was created in CreateCommand Class constructor ");
		}
		_managers.getInstance().schedule(defCommand);
	}//end of execute
	
}
