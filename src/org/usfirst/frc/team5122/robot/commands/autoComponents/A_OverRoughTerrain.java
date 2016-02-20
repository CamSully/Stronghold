package org.usfirst.frc.team5122.robot.commands.autoComponents;

import org.usfirst.frc.team5122.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class A_OverRoughTerrain extends Command {

    public A_OverRoughTerrain() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    	setTimeout(3);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(1, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stopDrivetrain();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
