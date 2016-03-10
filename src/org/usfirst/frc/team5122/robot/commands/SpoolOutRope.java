package org.usfirst.frc.team5122.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5122.robot.*;

/**
 * 
 */
public class SpoolOutRope extends Command {
	
    public SpoolOutRope() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lift.deployRope();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.stopLiftMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    // Cancel runs when button is released.
    public void cancel() {
    	super.cancel();
    	// Turn lift off when button is released.
    	end();
    }
}
