package org.usfirst.frc.team5122.robot.commands.autoModes;

import org.usfirst.frc.team5122.robot.commands.autoComponents.A_OverRoughTerrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A_RoughTerrain extends CommandGroup {
    
    public  A_RoughTerrain(String position) {
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
    	
    	addSequential(new A_OverRoughTerrain());
    	
    	
    	if (position.equals("center")) {
    		
    	}
    	
    	else if (position.equals("right")) {
    		
    	}
    	
    	else if (position.equals("cleft")) {
    		
    	}
    	
    	else if (position.equals("fleft")) {
    		
    	}
    }
}
