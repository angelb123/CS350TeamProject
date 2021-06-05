package cs350s21project.cli;


import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.*;

import cs350s21project.controller.command.actor.*;
import cs350s21project.controller.command.view.CommandViewCreateWindowFront;
import cs350s21project.controller.command.view.CommandViewCreateWindowSide;
import cs350s21project.controller.command.view.CommandViewCreateWindowTop;
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
			
			//create window wTop top view with 200 (49*39'32# 0*10'0# 0*0'30#) (117*25'30# 0*10'0# 0*0'30#)
			if(parsed[3].equals("top")) {
				// create window  id top view with  size 
				//( latitude1  latitude2  latitude3)
				//( longitude1  longitude2  longitude3)
				_id=new AgentID(parsed[2]);
				int size=Integer.valueOf(parsed[6]);
				
				String  latitude1=parsed[7];
				String[] lati1 = CommandInterpreter.parseLatLong(latitude1);
				//String lati11=CommandInterpreter.pParenthesis(lati1[0]);
				String []temp1=new String[lati1.length];
				for(int i = 0; i < lati1.length; i ++) {
					//System.out.println(temp[i]);
					temp1[i]=CommandInterpreter.pParenthesis(lati1[i]);
					
					//System.out.println(temp1[i]);
					
				}
				Latitude latitude11=new Latitude(Integer.valueOf(temp1[0]), Integer.valueOf(temp1[1]), Integer.valueOf(temp1[2]));
				
				
				String  latitude2=parsed[8];
				String[] lati2 = CommandInterpreter.parseLatLong(latitude2);
				Latitude latitude22=new Latitude(Integer.valueOf(lati2[0]), Integer.valueOf(lati2[1]), Integer.valueOf(lati2[2]));
				
				
				String  latitude3=parsed[9];
				String[] lati3 = CommandInterpreter.parseLatLong(latitude3);
				//String lati11=CommandInterpreter.pParenthesis(lati1[0]);
				String []temp3=new String[lati3.length];
				for(int i = 0; i < lati3.length; i ++) {
					//System.out.println(temp[i]);
					temp3[i]=CommandInterpreter.pParenthesis(lati3[i]);
					
					//System.out.println(temp3[i]);
					
				}
				Latitude latitude33=new Latitude(Integer.valueOf(temp3[0]), Integer.valueOf(temp3[1]), Integer.valueOf(temp3[2]));
				
				
				String  longitude1=parsed[10];
				String[] long1 = CommandInterpreter.parseLatLong(longitude1);
				//String lati11=CommandInterpreter.pParenthesis(lati1[0]);
				String []temp4=new String[long1.length];
				for(int i = 0; i < long1.length; i ++) {
					//System.out.println(temp[i]);
					temp4[i]=CommandInterpreter.pParenthesis(long1[i]);
					
					//System.out.println(temp4[i]);
					
				}
				Longitude longitude11=new Longitude(Integer.valueOf(temp4[0]), Integer.valueOf(temp4[1]), Integer.valueOf(temp4[2]));
				
				String  longitude2=parsed[11];
				String[] long2 = CommandInterpreter.parseLatLong(longitude2);
				Longitude longitude22=new Longitude(Integer.valueOf(long2[0]), Integer.valueOf(long2[1]), Integer.valueOf(long2[2]));
				
				String  longitude3=parsed[12];
				String[] long3 = CommandInterpreter.parseLatLong(longitude3);
				//String lati11=CommandInterpreter.pParenthesis(lati1[0]);
				String []temp6=new String[long3.length];
				for(int i = 0; i < long3.length; i ++) {
					//System.out.println(temp[i]);
					temp6[i]=CommandInterpreter.pParenthesis(long3[i]);
					
					//System.out.println(temp6[i]);
					
				}
				Longitude longitude33=new Longitude(Integer.valueOf(temp6[0]), Integer.valueOf(temp6[1]), Integer.valueOf(temp6[2]));
				
				
				
				defCommand=new  CommandViewCreateWindowTop(_managers, command, _id, size, latitude11, latitude22, latitude33, longitude11
						, longitude22, longitude33);
			}
			
			
			if(parsed[3].equals("front")) {
				/*create window  id front view with  size 
				 * ( longitude1  longitude2  longitude3) 
				 * ( altitude1  altitude2  altitude3  altitude4)*/
				
				// 
				
				_id=new AgentID(parsed[2]);
				int size=Integer.valueOf(parsed[6]);
				
				String  longitude1=parsed[7];
				String[] long1 = CommandInterpreter.parseLatLong(longitude1);
				//String lati11=CommandInterpreter.pParenthesis(lati1[0]);
				String []temp1=new String[long1.length];
				for(int i = 0; i < long1.length; i ++) {
					//System.out.println(temp[i]);
					temp1[i]=CommandInterpreter.pParenthesis(long1[i]);
					
					//System.out.println(temp1[i]);
					
				}
				Longitude longitude11=new Longitude(Integer.valueOf(temp1[0]), Integer.valueOf(temp1[1]), Integer.valueOf(temp1[2]));
				
				String  longitude2=parsed[8];
				String[] long2 = CommandInterpreter.parseLatLong(longitude2);
				Longitude longitude22=new Longitude(Integer.valueOf(long2[0]), Integer.valueOf(long2[1]), Integer.valueOf(long2[2]));
				
				String  longitude3=parsed[9];
				String[] long3 = CommandInterpreter.parseLatLong(longitude3);
				//String lati11=CommandInterpreter.pParenthesis(lati1[0]);
				String []temp3=new String[long3.length];
				for(int i = 0; i < long3.length; i ++) {
					//System.out.println(temp[i]);
					temp3[i]=CommandInterpreter.pParenthesis(long3[i]);
					
					//System.out.println(temp3[i]);
					
				}
				Longitude longitude33=new Longitude(Integer.valueOf(temp3[0]), Integer.valueOf(temp3[1]), Integer.valueOf(temp3[2]));
				
				
				
				Altitude altitude1=new Altitude(Double.valueOf(CommandInterpreter.pParenthesis(parsed[10])));
				Altitude altitude2=new Altitude(Double.valueOf(CommandInterpreter.pParenthesis(parsed[11])));
				Altitude altitude3=new Altitude(Double.valueOf(CommandInterpreter.pParenthesis(parsed[12])));
				Altitude altitude4=new Altitude(Double.valueOf(CommandInterpreter.pParenthesis(parsed[13])));
				
				
				
				defCommand=new CommandViewCreateWindowFront(_managers, command, _id, size, longitude11, longitude22, longitude33, altitude1, altitude2, altitude3, altitude4);
			}
			
			
			if(parsed[3].equals("side")) {
				/*create window  id side view with  size 
				 * ( latitude1  latitude2  latitude3) 
				 * ( altitude1  altitude2 altitude3  altitude4)*/
				_id=new AgentID(parsed[2]);
				int size=Integer.valueOf(parsed[6]);
				
				String  latitude1=parsed[7];
				String[] lati1 = CommandInterpreter.parseLatLong(latitude1);
				//String lati11=CommandInterpreter.pParenthesis(lati1[0]);
				String []temp1=new String[lati1.length];
				for(int i = 0; i < lati1.length; i ++) {
					//System.out.println(temp[i]);
					temp1[i]=CommandInterpreter.pParenthesis(lati1[i]);
					
					System.out.println(temp1[i]);
					
				}
				Latitude latitude11=new Latitude(Integer.valueOf(temp1[0]), Integer.valueOf(temp1[1]), Integer.valueOf(temp1[2]));
				
				
				String  latitude2=parsed[8];
				String[] lati2 = CommandInterpreter.parseLatLong(latitude2);
				Latitude latitude22=new Latitude(Integer.valueOf(lati2[0]), Integer.valueOf(lati2[1]), Integer.valueOf(lati2[2]));
				
				
				String  latitude3=parsed[9];
				String[] lati3 = CommandInterpreter.parseLatLong(latitude3);
				//String lati11=CommandInterpreter.pParenthesis(lati1[0]);
				String []temp3=new String[lati3.length];
				for(int i = 0; i < lati3.length; i ++) {
					//System.out.println(temp[i]);
					temp3[i]=CommandInterpreter.pParenthesis(lati3[i]);
					
					//System.out.println(temp3[i]);
					
					
					
				}
				Latitude latitude33=new Latitude(Integer.valueOf(temp3[0]), Integer.valueOf(temp3[1]), Integer.valueOf(temp3[2]));
				Altitude altitude1=new Altitude(Double.valueOf(CommandInterpreter.pParenthesis(parsed[10])));
				Altitude altitude2=new Altitude(Double.valueOf(CommandInterpreter.pParenthesis(parsed[11])));
				Altitude altitude3=new Altitude(Double.valueOf(CommandInterpreter.pParenthesis(parsed[12])));
				Altitude altitude4=new Altitude(Double.valueOf(CommandInterpreter.pParenthesis(parsed[13])));
				
				defCommand= new CommandViewCreateWindowSide(_managers, command, _id, size, latitude11, latitude22, latitude33, altitude1,altitude2, altitude3, altitude4);
			}
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
