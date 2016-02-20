package org.usfirst.frc.team5122.robot.commands.autoComponents;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A_DriveAlongTurn extends CommandGroup {
    
	double time;
	
    public  A_DriveAlongTurn(int spaces) {
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
    	
    	time = spaces * 1.5;
    	
    	addSequential (new AutoDrive(0.6, 0, time));
    	addSequential (new AutoDrive(0.5, 0.5, 1));     // speed, turn, time.
    }
}
