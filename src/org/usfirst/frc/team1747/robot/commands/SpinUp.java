package org.usfirst.frc.team1747.robot.commands;

import org.usfirst.frc.team1747.robot.CyborgController;
import org.usfirst.frc.team1747.robot.OI;
import org.usfirst.frc.team1747.robot.Robot;
import org.usfirst.frc.team1747.robot.SDController;
import org.usfirst.frc.team1747.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class SpinUp extends Command {

	CyborgController cyborg;
	Shooter shooter;
	SDController sd;
	double speed, shooterSpeed;
	
	public SpinUp(double speed){
		this.cyborg=Robot.getOi().getCyborg();
		this.shooter = Robot.getShooter();
		this.sd = Robot.getSd();
		this.speed = speed;
		requires(shooter);
	}
	
	protected void initialize() {
		
	}

	protected void execute() {
		if(cyborg.getLeftBumper().get()){
			shooter.setShooterJag(speed/2);
		}else{
			shooter.setShooterJag(speed);
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
