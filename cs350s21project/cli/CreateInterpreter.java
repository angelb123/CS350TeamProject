package cs350s21project.cli;


import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.*;

import cs350s21project.controller.command.actor.*;
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
			
			_id = new AgentID(parsed[2]); // _id is of type AgentID, should create a new Agent ID of parsed[2]//done and compare those two agent ids 
			AgentID _family = new AgentID(parsed[4]);
			//to do parse coodinates
			//parse the lat &long
			
			String[] coord = CommandInterpreter.pCoordinates(parsed[6]);
			
			String[] latTemp = CommandInterpreter.parseLatLong(coord[0]);
			//change to proper method name in command interpreter class	//done	
			Latitude latitude = new Latitude(Integer.valueOf(latTemp[0]), Integer.valueOf(latTemp[1]), Double.valueOf(latTemp[2]));
			
			
			String[] lonTemp = CommandInterpreter.parseLatLong(coord[1]);//done
			Longitude longitude = new Longitude(Integer.valueOf(lonTemp[0]), Integer.valueOf(lonTemp[1]), Double.valueOf(lonTemp[2]));
						
			
			Altitude altitude = new Altitude(Double.valueOf(coord[2]));
						
			CoordinateWorld3D position = new CoordinateWorld3D(latitude, longitude, altitude); // fix to proper name//done, imoprt//already imported
			
			Course course = new Course(Double.valueOf(parsed[9]));
			Groundspeed speed = new Groundspeed(Double.valueOf(parsed[11])); // fix to proper name; ("Groundspeed")//done
			
			defCommand = new CommandActorCreateActor(_managers, command, _id, _family, position, course, speed); //import//already imported
			
		}
		
		
		
	}
	
	public void execute() throws RuntimeException { // - Angel
		if(defCommand == null) {
			throw new RuntimeException("No Command Object was created in CreateCommand Class constructor ");
		}
		_managers.getInstance().schedule(defCommand);
	}//end of execute
	
}
