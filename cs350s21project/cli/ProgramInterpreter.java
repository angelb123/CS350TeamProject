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
	private String _fileName;
	private Time _time;

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
			//_id = new AgentID(parsed[3]);
			_fileName=parsed[2];
			defCommand=new CommandMiscLoad(_managers, command, _fileName);
			
		}
		
		if(parsed[0].equals("@pause")) {//han
			defCommand= new CommandMiscPause(_managers, command);
		}
		
		if(parsed[0].equals("@resume")) {//han
	        defCommand= new CommandMiscResume(_managers, command);
		}
		
		if(parsed[0].equals("@set")) {//han
			_time =new Time(Double.valueOf(parsed[3]));
	        defCommand = new CommandMiscSetUpdate(_managers, command, _time);
	        }
		
		if(parsed[1].equals("@wait")) {//han
	        _time = new Time(Double.valueOf(parsed[2]));
	        defCommand = new CommandMiscWait(_managers, command, _time);
		}
		//@force fo1 state to 45*30'15"/110*30'10"/200 with course 090, 270 speed 2.0 
		//CommandActorSetState​(CommandManagers managers,java.lang.String text, AgentID id, 
		//CoordinateWorld3D position, Course course, Groundspeed speed)
		
		if(parsed[1].equals("@force")) {//han
	       _id = new AgentID(parsed[1]);
	       String[] coord = CommandInterpreter.pCoordinates(parsed[4]); 
	       String[] latTemp = CommandInterpreter.parseLatLong(command);
	       Latitude latitude = new Latitude(Integer.valueOf(latTemp[0]), Integer.valueOf(latTemp[1]), Double.valueOf(latTemp[2]));
	       String[] lonTemp = CommandInterpreter.parseLatLong(coord[1]);
	       Longitude longitude = new Longitude(Integer.valueOf(lonTemp[0]), Integer.valueOf(lonTemp[1]), Double.valueOf(lonTemp[2]));
	       Altitude altitude = new Altitude(Double.valueOf(coord[2]));
	       CoordinateWorld3D position = new CoordinateWorld3D(latitude, longitude, altitude); // fix to proper name, imoprt
	       Course course = new Course(Double.valueOf(parsed[7]));
	       Groundspeed speed = new Groundspeed(Double.valueOf(parsed[9])); 
	       defCommand = new CommandActorSetState(_managers, command, _id, position, course, speed);
		}
		
		if(parsed[1].equals("@exit")) {//han
	        defCommand =new CommandMiscExit(_managers, command);
		}
		
		
		
	}
	
	public void execute() throws RuntimeException { // - Angel
		if(defCommand == null) {
			throw new RuntimeException("No Command Object was created in ProgramCommand Class constructor ");
		}
		_managers.getInstance().schedule(defCommand);
	}//end of execute
}
