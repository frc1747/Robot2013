package org.usfirst.frc.team1747.robot;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SDController {
	
	SendableChooser driveChooser;
	CyborgController cyborg;
	
	public SDController(){
		cyborg=Robot.getOi().getCyborg();
		 SmartDashboard.putData(Scheduler.getInstance());
		 driveChooser = new SendableChooser();
		 driveChooser.addDefault("Arcade Drive", true);
		 driveChooser.addObject("Tank Drive", false);
		 SmartDashboard.putData("Drive Modes", driveChooser);
		 //SmartDashboard.putData(Robot.drive);
		 SmartDashboard.putNumber("Left Joystick", 0);
		 SmartDashboard.putNumber("Right Joystick", 0);
		 SmartDashboard.putNumber("Dampening Constant", 0);
	}
	
	public boolean getDriveMode(){
		return !(boolean) driveChooser.getSelected();
	}
	
	public void setLeftJoy(double value){
		SmartDashboard.putNumber("Left Joystick", value);
	}
	
	public void setRightJoy(double value){
		SmartDashboard.putNumber("Right Joystick", value);
	}		
	
	public double getDampeningConstant(){
		return SmartDashboard.getNumber("Dampening Constant");
	}
	
	public void refresh(){
		if(getDriveMode()){
			setLeftJoy(cyborg.getLeftVert());
	    	setRightJoy(cyborg.getRightVert());
		} else {
			setLeftJoy(cyborg.getLeftVert());
			setRightJoy(cyborg.getRightHoriz());
		}
	}
}
