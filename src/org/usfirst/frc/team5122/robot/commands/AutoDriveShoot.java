package org.usfirst.frc.team5122.robot.commands;

import org.usfirst.frc.team5122.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveShoot extends CommandGroup {
    
    public  AutoDriveShoot() {
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
    	
    	addSequential(new AutoDriveForward());
    	addSequential(new FireBall());
    }
}
