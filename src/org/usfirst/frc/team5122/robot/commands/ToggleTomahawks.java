package org.usfirst.frc.team5122.robot.commands;

import org.usfirst.frc.team5122.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggle tomahawks is a simple command that changes the position of the tomahawks once, then ends.
 */
public class ToggleTomahawks extends Command {

	boolean done = false;
	
    public ToggleTomahawks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Toggle the tomahawks once, then end execution (so that they don't toggle infinitely).
    	Robot.lift.toggleTomahawks();
    	done = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
