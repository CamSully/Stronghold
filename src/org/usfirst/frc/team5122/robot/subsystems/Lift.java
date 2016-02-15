package org.usfirst.frc.team5122.robot.subsystems;

import org.usfirst.frc.team5122.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedController lifter = RobotMap.liftLifter;
	
	public void lifterUp() {
		lifter.set(.3);
	}
	
	public void lifterDown() {
		lifter.set(-.3);
	}
	
	public void stopLift() {
		lifter.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

