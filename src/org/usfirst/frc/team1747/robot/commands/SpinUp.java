package org.usfirst.frc.team1747.robot.commands;

import org.usfirst.frc.team1747.robot.OI;
import org.usfirst.frc.team1747.robot.Robot;
import org.usfirst.frc.team1747.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class SpinUp extends Command {

	OI oi;
	Shooter shooter;
	double speed, shooterSpeed;
	
	public SpinUp(double speed){
		this.oi = Robot.oi;
		this.shooter = Robot.shooter;
		this.speed = speed;
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if(oi.getLeftBumper()){
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
