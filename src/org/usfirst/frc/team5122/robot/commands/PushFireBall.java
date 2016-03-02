package org.usfirst.frc.team5122.robot.commands;

import org.usfirst.frc.team5122.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * PushFireBall is the command used to fire the ball.
 */
public class PushFireBall extends CommandGroup {
    
    public  PushFireBall() {
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
    	
    	requires(Robot.shooter);
    	
    	// Turn on the motors for 1.25s to get them up to speed.
    	addSequential(new FireBall(1.25));
    	// Keep the motors on while pushing the ball into them.
    	addParallel(new FireBall());
    	addParallel(new Push());
    	// Keep the motors on to ensure that the ball is passed through with them at full speed.
    	addSequential(new FireBall(1));
    	
    }
}
