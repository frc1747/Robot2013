package org.usfirst.frc.team1747.robot.subsystems;

import org.usfirst.frc.team1747.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	CANJaguar shooterJag;
	
	public Shooter(){
		shooterJag = new CANJaguar(RobotMap.SHOOTER_JAG_ID); 
	}
	
	public void setShooterJag(double speed){
		shooterJag.set(speed);
	}
	
	protected void initDefaultCommand() {

	}

}
