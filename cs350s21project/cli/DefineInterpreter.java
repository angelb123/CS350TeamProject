package cs350s21project.cli;

import java.util.Arrays;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.*;
import cs350s21project.controller.command.munition.*;
import cs350s21project.datatype.*;

public class DefineInterpreter {
	
	private AgentID _id; 
	private A_Command defCommand;
	private CommandManagers _managers;
	
	static public void defineEvaluate(String command, String[] parsed) {
		//this method is used for determing what define metod to use
	}
	
	public DefineInterpreter(String command, String[] parsed) throws RuntimeException {
		
		_managers = CommandManagers.getInstance();
		
		//Convert the command array back to a string
		String originalCommand = Arrays.toString(parsed);
		
		
		
		if(parsed[1].equals("munition")) { // define munitions block
			
			//iii.1 - DEFINE A BOMB 
			if(parsed[2].equals("bomb")) { // define munitions,  bomb
				_id = new AgentID(parsed[3]);
				defCommand = new CommandMunitionDefineBomb(_managers, originalCommand, _id);
				
			}
			
			
			//iii.2 - DEFINE A SHELL
			if(parsed[2].equals("shell")) {
				_id = new AgentID(parsed[3]);
				defCommand = new CommandMunitionDefineShell(_managers, originalCommand, _id);
			}
			
			//iii.3 - DEFINE A DEPTH CHARGE
			if(parsed[2].equals("depth_charge")) {
				_id = new AgentID(parsed[3]);
				AgentID fuzeID;
				
				
				//
				//To define a depth charge, we need to use an existing depth_charge id. 
				//we will check to see if it exists in CommandManagers, in the Sensor Manager. 
				//If it doesnt, the depth_charge is not created and we throw a runtime exception
				
				/*
				try{
					fuzeID = _managers.getSensorManager().getSensor(new AgentID(command[6])).getSensorID(); //check to see if there exists a depth charge with that id
				}
				catch(RuntimeException e) {
					String error = "Depth charge with ID: " + _id.getID() + " was not able to be defined, a [depth sensor] with ID: " + command[6] + " was not found";
					
					System.out.println(e.getMessage());
					throw new RuntimeException(error);
					
				}
				
				####TO BE DETERMINED####
				
				*/
				
				fuzeID = new AgentID(parsed[6]);
				
				defCommand = new CommandMunitionDefineDepthCharge(_managers, originalCommand, _id, fuzeID);
				
			}
			
			//iii.4 - DEFINE A TORPEDO
			if(parsed[2].equals("torpedo")) {
				_id = new AgentID(parsed[3]);
				AgentID sensorID = new AgentID(parsed[6]);
				AgentID fuzeID = new AgentID(parsed [8]);
				Time time = new Time(Double.valueOf(parsed[11]));
				defCommand = new CommandMunitionDefineTorpedo(_managers, originalCommand, _id, sensorID, fuzeID, time);
				
			}
			
			//iii.5 - DEFINE A MISSLE
			if(parsed[2].equals("missle")) {
				_id = new AgentID(parsed[3]);
				AgentID sensorID = new AgentID(parsed[6]);
				AgentID fuzeID = new AgentID(parsed[8]);
	
				DistanceNauticalMiles distance = new DistanceNauticalMiles(Double.valueOf(parsed[11]));
				
				defCommand = new CommandMunitionDefineMissile(_managers, originalCommand, _id, sensorID, fuzeID, distance);
				
			}
			
			
		}
		
		
		
		
		
		if(parsed[1].equals("ship")) { 
			//todo
			
		}
		
		if(parsed[1].equals("sensors")) {
			//todo
		}
		
		
	
	}
	
	
	
	
	
	
	
	public void execute() throws RuntimeException {
		if(defCommand == null) {
			throw new RuntimeException("No Command Object was created in DefineCommand Class constructor ");
		}
		_managers.getInstance().schedule(defCommand);
	}
	
}
