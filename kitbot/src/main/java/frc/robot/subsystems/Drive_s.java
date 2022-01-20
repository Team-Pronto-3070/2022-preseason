package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

/**
 * Drive subsystem
 */
public class Drive_s extends SubsystemBase{

    // declare talons
    TalonFX talFL;
    TalonFX talBL;
    TalonFX talFR;
    TalonFX talBR;
    
    public Drive_s() {
        talFL = new TalonFX(Constants.DRIVE.TAL_FL_PORT);
        talBL = new TalonFX(Constants.DRIVE.TAL_BL_PORT);
        talFR = new TalonFX(Constants.DRIVE.TAL_FR_PORT);
        talBR = new TalonFX(Constants.DRIVE.TAL_BR_PORT);

        talFL.configOpenloopRamp(Constants.DRIVE.RAMP_TIME);
        talBL.configOpenloopRamp(Constants.DRIVE.RAMP_TIME);
        talFR.configOpenloopRamp(Constants.DRIVE.RAMP_TIME);
        talBR.configOpenloopRamp(Constants.DRIVE.RAMP_TIME);

        // invert one side TODO: Test which side needs inversion
        talFR.setInverted(true);
        talBR.setInverted(true);
    }

    /**
     * Set talons to given input speeds.
     * @param velocityL
     * @param velocityR
     */
    public void setSpeed(double velocityL, double velocityR) {
        // set left speeds
        talFL.set(ControlMode.PercentOutput, velocityL);
        talBL.set(ControlMode.Follower, Constants.DRIVE.TAL_FL_PORT);

        // set right speeds
        talFR.set(ControlMode.PercentOutput, velocityR);
        talBR.set(ControlMode.Follower, Constants.DRIVE.TAL_FR_PORT);
    }

    /**
     * Stop robot
     */
    public void stop() {
        // stop left motors
        talFL.set(ControlMode.PercentOutput, 0);
        talBL.set(ControlMode.Follower, Constants.DRIVE.TAL_FL_PORT);

        // stop right speeds
        talFR.set(ControlMode.PercentOutput, 0);
        talBR.set(ControlMode.Follower, Constants.DRIVE.TAL_FR_PORT);
    }
}
