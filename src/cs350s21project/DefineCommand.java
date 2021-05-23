package cs350s21project.cli;

import java.util.Arrays;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.carrier.CarrierMunitionBomb;
import cs350s21project.datatype.AgentID;
import cs350s21project.controller.command.A_Command;
import cs350s21project.controller.command.munition.CommandMunitionDefineBomb;
import cs350s21project.controller.command.munition.CommandMunitionUndefineMunition;
//A class that is used to define objects
class DefineCommand {

	
	private AgentID _id; 
	private A_Command defCommand;
	private CommandManagers _managers;
	
	/**
	 * @param {CommandManagers} managers - The static managers fromm the program
	 * @param {String[]} command - parsed command from the CommandInterpreter Class 
	 */
	public DefineCommand(CommandManagers managers, String[] command) {
		
		_managers = managers;
		
		//Convert the command array back to a string
		String originalCommand = Arrays.toString(command);
		
		
		
		if(command[1].equals("munition")) { // define munitions block
		
			if(command[2].equals("bomb")) { // define munitions,  bomb
				_id = new AgentID(command[3]);
				defCommand = new CommandMunitionDefineBomb(_managers, originalCommand, _id);	
			}
		}
		
		
		
		if(command[1].equals("ship")) { 
			//todo
			
		}
		
		if(command[1].equals("sensors")) {
			//todo
		}
		
	
	}
	
	public void execute() {
		_managers.getInstance().schedule(defCommand);
	}
	
	
}
