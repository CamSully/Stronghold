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
	DigitalInput topLimit = RobotMap.liftTopLimit;
	DoubleSolenoid tomahawks = RobotMap.tomahawksSolenoid;
	
	boolean tomahawksDown = false;
	
	public void lifterUp() {
		if (topLimit.get()) {     // Limit not pressed.
			lifter.set(0.4);
		}
	}
	
	public void lifterDown() {
		lifter.set(-0.4);
	}
	
	public void stopLift() {
		lifter.set(0);
	}
	
	public boolean getTopLimit() {
		return topLimit.get();
	}
	
	public void tomahawksDown() {
		tomahawks.set(DoubleSolenoid.Value.kForward);
		tomahawksDown = true;
	}
	
	public void tomahawksUp() {
		tomahawks.set(DoubleSolenoid.Value.kReverse);
		tomahawksDown = false;
	}
	
	public void toggleTomahawks() {
		if (tomahawksDown) {
			tomahawksUp();
		}
		else {
			tomahawksDown();
		}
	}
	
	public boolean getTomahawksDown() {
		return tomahawksDown;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

