package org.usfirst.frc.team5122.robot.commands.autoComponents;

import org.usfirst.frc.team5122.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class A_StopDrive extends Command {

    public A_StopDrive(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.drivetrain);
    	
    	setTimeout(time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(0,0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
