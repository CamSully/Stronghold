package org.usfirst.frc.team5122.robot.subsystems;

import org.usfirst.frc.team5122.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedController lifter = RobotMap.liftLifter;
	DigitalInput topLimit = RobotMap.liftTopLimit;
	
	public void lifterUp() {
		if (!topLimit.get()) {
			SmartDashboard.putBoolean("Lift on Top Limit", false);
			lifter.set(.3);
		}
		
		else {
			SmartDashboard.putBoolean("Lift on Top Limit", true);
		}
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

