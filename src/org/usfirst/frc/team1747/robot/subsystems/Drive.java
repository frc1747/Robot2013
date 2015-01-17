package org.usfirst.frc.team1747.robot.subsystems;

import org.usfirst.frc.team1747.robot.RobotMap;
import org.usfirst.frc.team1747.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Subsystem {

	CANJaguar topLeftJag, midLeftJag, botLeftJag;
	CANJaguar topRightJag, midRightJag, botRightJag;

	public Drive(){
		midRightJag = new CANJaguar(RobotMap.RIGHT_MID_JAG_ID);
		topRightJag = new CANJaguar(RobotMap.RIGHT_TOP_JAG_ID);
		botRightJag = new CANJaguar(RobotMap.RIGHT_BOT_JAG_ID);
		botLeftJag = new CANJaguar(RobotMap.LEFT_BOT_JAG_ID);
		midLeftJag = new CANJaguar(RobotMap.LEFT_MID_JAG_ID);
		topLeftJag = new CANJaguar(RobotMap.LEFT_TOP_JAG_ID);
		System.out.println("Jags Initialized");
	}
	
	public void arcadeDrive(double forward, double turn){
		double leftCurrent = forward-turn;
		double rightCurrent = forward+turn;
		tankDrive(leftCurrent, rightCurrent);
	}

	public void tankDrive(double leftSpeed, double rightSpeed){
		topLeftJag.set(leftSpeed);
		midLeftJag.set(leftSpeed);
		botLeftJag.set(leftSpeed);
		topRightJag.set(rightSpeed);
		midRightJag.set(rightSpeed);
		botRightJag.set(rightSpeed);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}
}