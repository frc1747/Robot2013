package org.usfirst.frc.team1747.robot.commands;

import org.usfirst.frc.team1747.robot.OI;
import org.usfirst.frc.team1747.robot.Robot;
import org.usfirst.frc.team1747.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleopDrive extends Command {
	
	Drive drive;
    OI oi;
	
    public TeleopDrive() {
    	this.drive=Robot.drive;
    	this.oi=Robot.oi;
        requires(drive);
    }
	
	protected void initialize() {
	
	}
    
	protected void execute() {
		if(SmartDashboard.getBoolean("TankDrive")){
			drive.tankDrive(oi.getLeftJoyVert(), oi.getRightJoyVert());
			SmartDashboard.putNumber("LeftJoy", oi.getLeftJoyVert());
	    	SmartDashboard.putNumber("RightJoy", oi.getRightJoyVert());
	    }
		else{
			drive.arcadeDrive(oi.getLeftJoyVert(), oi.getRightJoyHoriz());
			SmartDashboard.putNumber("LeftJoy", oi.getLeftJoyVert());
	    	SmartDashboard.putNumber("RightJoy", oi.getRightJoyHoriz());
	    }
    }

    protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
}
