package org.usfirst.frc.team1747.robot.subsystems;

import org.usfirst.frc.team1747.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Feeder extends Subsystem{
	
	CANJaguar feederJag;
	public Feeder(){
		//feederJag = new CANJaguar(RobotMap.FEEDER_JAG_ID); 
	}
	
	public void setfeederJag(double speed){
		feederJag.set(speed);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
