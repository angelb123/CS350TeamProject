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
		
		//wrapped what I had into this static method - Angel
		DefineInterpreter interpreter = new DefineInterpreter(command, parsed);
		interpreter.execute();
	}
	
	public DefineInterpreter(String command, String[] parsed) throws RuntimeException {
		
		_managers = CommandManagers.getInstance();
		
		//Convert the command array back to a string
		//String originalCommand = Arrays.toString(parsed);
		
		
		
		if(parsed[1].equals("munition")) { // define munitions block
			
			//iii.1 - DEFINE A BOMB - Angel
			if(parsed[2].equals("bomb")) { // define munitions,  bomb
				_id = new AgentID(parsed[3]);
				defCommand = new CommandMunitionDefineBomb(_managers, command, _id);
				
			}
			
			
			//iii.2 - DEFINE A SHELL - Angel
			if(parsed[2].equals("shell")) {
				_id = new AgentID(parsed[3]);
				defCommand = new CommandMunitionDefineShell(_managers, command, _id);
			}
			
			//iii.3 - DEFINE A DEPTH CHARGE
			if(parsed[2].equals("depth_charge")) { //- Angel
				_id = new AgentID(parsed[3]);
				AgentID fuzeID;
				
				
				// - Angel
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
				
				defCommand = new CommandMunitionDefineDepthCharge(_managers, command, _id, fuzeID);
				
			}
			
			//iii.4 - DEFINE A TORPEDO
			if(parsed[2].equals("torpedo")) { // -Angel
				_id = new AgentID(parsed[3]);
				AgentID sensorID = new AgentID(parsed[6]);
				AgentID fuzeID = new AgentID(parsed [8]);
				Time time = new Time(Double.valueOf(parsed[11]));
				defCommand = new CommandMunitionDefineTorpedo(_managers, command, _id, sensorID, fuzeID, time);
				
			}
			
			//iii.5 - DEFINE A MISSLE
			if(parsed[2].equals("missle")) { // - Angel
				_id = new AgentID(parsed[3]);
				AgentID sensorID = new AgentID(parsed[6]);
				AgentID fuzeID = new AgentID(parsed[8]);
	
				DistanceNauticalMiles distance = new DistanceNauticalMiles(Double.valueOf(parsed[11]));
				
				defCommand = new CommandMunitionDefineMissile(_managers, command, _id, sensorID, fuzeID, distance);
				
			}
			
			
		}
		
		
		
		//ii.1
		//ship  define ship id1 with munition[s] (idn+)
		if(parsed[1].equals("ship")) { //Dustin;WIP
			//todo
			_id = new AgentID(parsed[2]);
			List<AgentID> munitions = new List<AgentID>(5);
			// need to add list of munitions
			for(int i = 5; i < parsed.length; i++) {
				AgentID temp = new AgentID(parsed[i]);
				munitions.add(temp);
			}
			defCommand = new CommandActorDefineShip(_managers, command, _id, munitions);
			
		}
		
		//iv.1-8
		//sensors
		if(parsed[1].equals("sensors")) {//Dustin;WIP
			//todo
			_id = new AgentID(parsed[3]);
			switch(parsed[2]) {
				case "radar"://define sensor radar id with field of view fov power power sensitivity sensitivity
					FieldOfView fov = new FieldOfView(new AngleNavigational(Double.valueOf(parsed[8])));//double
					Power power = new Power(Double.valueOf(parsed[10]));
					Sensitivity sense = new Sensitivity(Double.valueOf(parsed[12]));
					defCommand  = new CommandSensorDefineRadar(_managers, command, _id, fov, power, sense);
					break;
				case "thermal"://define sensor thermal id with field of view fov sensitivity sensitivity
					FieldOfView fov = new FieldOfView(new AngleNavigational(Double.valueOf(parsed[8])));					
					Sensitivity sense = new Sensitivity(Double.valueOf(parsed[10]));
					defCommand = new CommandSensorDefineThermal(_managers, command, _id, fov, sense);
					break;
				case "acoustic"://define sensor acoustic id with sensitivity sensitivity
					Sensitivity sense = new Sensitivity(Double.valueOf(parsed[6]));
					defCommand = new CommandSensorDefineAcoustic(_managers, command, _id, sense);
					break;
				case "sonar":
					_id = new AgentID(parsed[4]);
					if(parsed[3].equals("active")) {//define sensor sonar active id with power power sensitivity sensitivity
						Power power = new Power(Double.valueOf(parsed[7]));
						Sensitivity sense = new Sensitivity(Double.valueOf(parsed[9]));
						defCommand = new CommandSensorDefineSonarActive(_managers, command, _id, power, sense);
					}else if(parsed[3].equals("passive")){//define sensor sonar passive id with sensitivity sensitivity
						Sensitivity sense = new Sensitivity(Double.valueOf(parsed[7]));
						defCommand = new CommandSensorDefineSonarActive(_managers, command, _id, sense);
					}else {System.out.println("Sonar type not defined");}
					break;
				case "depth"://define sensor depth id with trigger depth altitude
					Altitude altitude = new Altitude(Double.valueOf(parsed[7]));
					defCommand = new CommandSensorDefineDepth(_managers, command, _id, altitude);
					break;
				case "distance"://define sensor distance id with trigger distance distance
					DistanceNauticalMiles distance = new DistanceNauticalMiles(Double.valueOf(parsed[7]));
					defCommand = new CommandSensorDefineDistance(_managers, command, _id, distance);
					break;
				case "time"://define sensor time id with trigger time time
					Time time = new Time(Double.valueOf(parsed[7]));
					defCommand = new CommandSensorDefineTime(_managers, command, _id, time);
					break;
				default:
					System.out.println("Sensor type not found");					
			}
		}
		
		
	
	}//end of define methods
		

	public void execute() throws RuntimeException { // - Angel
		if(defCommand == null) {
			throw new RuntimeException("No Command Object was created in DefineCommand Class constructor ");
		}
		_managers.getInstance().schedule(defCommand);
	}//end of execute
	
}//end of class
