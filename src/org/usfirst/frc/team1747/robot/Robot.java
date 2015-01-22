package org.usfirst.frc.team1747.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1747.robot.subsystems.Drive;
import org.usfirst.frc.team1747.robot.subsystems.Feeder;
import org.usfirst.frc.team1747.robot.subsystems.Shooter;

public class Robot extends IterativeRobot {

	private static Drive drive;
	private static  OI oi;
	private static SDController sd;
	private static Shooter shooter;
	private static Feeder feeder;

	public void robotInit() {
		oi = new OI();
		sd = new SDController();
		drive = new Drive();
		shooter = new Shooter();
		feeder = new Feeder();
		oi.init();
		System.out.println("Robot Initialized");
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		Scheduler.getInstance().removeAll();
	}

	public void disabledInit() {

	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		sd.refresh();
		//drive.tankDrive(.5, .5);
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public static Drive getDrive()  {
		if(drive==null)
			System.out.println("drive is null!");
		return drive;
	}

	public static OI getOi()  {
		if(oi==null)
			System.out.println("oi is null!");
		return oi;
	}

	public static SDController getSd()  {
		if(sd==null)
			System.out.println("sd is null!");
		return sd;
	}

	public static Shooter getShooter()  {
		if(shooter==null)
			System.out.println("shooter is null!");
		return shooter;
	}

	public static Feeder getFeeder()  {
		if(feeder==null)
			System.out.println("feeder is null!");
		return feeder;
	}
}
