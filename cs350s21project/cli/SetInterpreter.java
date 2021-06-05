package cs350s21project.cli;


import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.*;
import cs350s21project.controller.command.actor.*;

import cs350s21project.datatype.*;
import cs350s21project.model.agents.ScoreboardEntry;

public class SetInterpreter {
	
	private AgentID _id; 
	private A_Command setCommand;
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
		
		//ii.6
		if(parsed[2].equals("course")) {//dustin- unsigned int
		 	
			_id = new AgentID(parsed[1]);
			Course nextCourse = new Course(Double.valueOf(parsed[3]));
			setCommand = new CommandActorSetCourse(_managers, command, _id, nextCourse);
		}
		
		//ii.7
		if(parsed[2].equals("speed")) {//angel
			_id = new AgentID(parsed[1]);
			Groundspeed speed = new Groundspeed(Double.valueOf(parsed[3]));
			setCommand = new CommandActorSetSpeed(_managers, command, _id, speed);
		}
		//ii.8
		if(parsed[2].equals("altitude")||parsed[2].equals("depth")) {//angel
			_id = new AgentID(parsed[1]);
			Altitude altitude = new Altitude(Double.valueOf(parsed[3]));
			setCommand = new CommandActorSetAltitudeDepth(_managers, command, _id, altitude);
		}
		
		//iii.7
		if(parsed[2].equals("load")) {//angel
			String s = _managers.getMunitionManager().getMunition(new AgentID(parsed[4])).getCommandText();
			AgentID theActor = new AgentID(parsed[1]);
			AgentID theMunition = new AgentID(parsed[4]);
			
			String munitionCommand[] = CommandInterpreter.stringArrayToArray(s);
			
			ScoreboardEntry entry; //Scoreboard entry, not sure what it is and does
			
			
			
			if(munitionCommand[2].equals("shell") || munitionCommand[2].equals("bomb") ) { //its either a shell or a bomb with no sensors or fuzes
				entry = new ScoreboardEntry(theMunition);
			}
			
			if(munitionCommand[2].equals("depth_charge")) { // its a depth charge with a depth sensor fuze
				AgentID theFuze = new AgentID(munitionCommand[6]);
				entry = new ScoreboardEntry(theMunition, theFuze, false);
				
			}
			if(munitionCommand[2].equals("torpedo")) {
				
				AgentID theSensor = new AgentID(munitionCommand[6]);
				AgentID theFuze = new AgentID(munitionCommand[8]);
				
				entry = new ScoreboardEntry(theMunition, theSensor, theFuze);
			}
			
			if(munitionCommand[2].equals("missle")) {
				AgentID theSensor = new AgentID(munitionCommand[6]);
				AgentID theFuze = new AgentID(munitionCommand[8]);
				
				entry = new ScoreboardEntry(theMunition, theSensor, theFuze);
			}
			
			
			
			
			setCommand = new CommandActorLoadMunition(_managers, command, theActor, theMunition);
			 
		}
		
		//iii.8
		if(parsed[2].equals("deploy")) {//angel - deploy a munition
			AgentID theActor = new AgentID(parsed[1]);
			AgentID theMunition = new AgentID(parsed[4]);
			
			setCommand = new CommandActorDeployMunition(_managers, command, theActor, theMunition);
		}
		
		//iii.9
		if(parsed[2].equals("deploy") && parsed.length > 4) { // deploying a shell 
			AgentID theActor = new AgentID(parsed[1]);
			AgentID theMunition = new AgentID(parsed[4]);
			
			AttitudeYaw azimuth = new AttitudeYaw(Double.valueOf(parsed[7]));
			AttitudePitch elevation = new AttitudePitch(Double.valueOf(parsed[9]));
			
			setCommand = new CommandActorDeployMunitionShell(_managers, command, theActor, theMunition, azimuth, null);
		}
		
		
		
	}	
	
	public void execute() throws RuntimeException { // - Angel
		if(setCommand == null) {
			throw new RuntimeException("No Command Object was created in SetCommand Class constructor ");
		}
		_managers.getInstance().schedule(setCommand);
	}//end of execute
	
}
