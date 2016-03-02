package org.usfirst.frc.team5122.robot.commands.autoComponents;

import org.usfirst.frc.team5122.robot.Robot;
import org.usfirst.frc.team5122.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A_Under_Lowbar extends CommandGroup {
    
    public  A_Under_Lowbar() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	requires(Robot.drivetrain);
    	requires(Robot.shooter);
    	requires(Robot.lift);
    	
    	// Put the tomahawks down.
    	addSequential(new ToggleTomahawks());
    	// Put the lift all the way up.
    	addSequential(new LiftUp());
    	// Pull the rotator up a bit so it can go over an obstacle.
    	addSequential(new RotatorOverObstacle(false));
    	// Wait for 1 second (nothing happening).
    	addSequential(new AutoDrive(0, 0, 1));
    	// Drive backwards at 0.6 power, 0 angle, for 4 seconds.
    	addSequential(new AutoDrive(-0.6, 0, 4));
    }
}
