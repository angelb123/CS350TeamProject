package cs350s21project.cli;

import java.util.Arrays;
import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.*;
import cs350s21project.controller.command.munition.*;
import cs350s21project.datatype.*;

public class DeleteInterpreter {

	private AgentID _id; 
	private A_Command defCommand;
	private CommandManagers _managers;
	
	static public void deleteEvaluate(String command, String[] parsed) {
		//this method is used for determing what delete metod to use
		DeleteInterpreter delete = new DeleteInterpreter(command, parsed);
		delete.execute();
	}
	/////////////////////////////////////////////////////////////////////
	//Add delete command methods below
	public DeleteInterpreter(String command, String[] parsed) throws RuntimeException {
		_managers = CommandManagers.getInstance();
		
		if(parsed[1].equals("window")) {//han
			
		}
		
	}
	
	public void execute() throws RuntimeException { // - Angel
		if(defCommand == null) {
			throw new RuntimeException("No Command Object was created in DeleteCommand Class constructor ");
		}
		_managers.getInstance().schedule(defCommand);
	}//end of execute
}
