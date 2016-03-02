package org.usfirst.frc.team5122.robot.commands;

import org.usfirst.frc.team5122.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Push is run in conjunction with FireBall.
 * Push is used to push the ball into the wheels once they are spinning quickly.
 */
public class Push extends Command {
	
    public Push() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	//PURPSOSEFUL LACK OF REQUIRED FOR SHOOTING PURPOSES
    	
    	setTimeout(1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.push();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.restractPusher();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
