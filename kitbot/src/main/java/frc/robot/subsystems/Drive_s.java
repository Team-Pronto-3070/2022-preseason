package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

/**
 * Drive subsystem
 */
public class Drive_s extends SubsystemBase{
    // Right motor controllers
    private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(
        new WPI_TalonSRX(Constants.DRIVE.TAL_FR_CHANNEL), 
        new WPI_TalonSRX(Constants.DRIVE.TAL_BR_CHANNEL));

    // Left motor controllers
    private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(
        new WPI_TalonSRX(Constants.DRIVE.TAL_FL_CHANNEL), 
        new WPI_TalonSRX(Constants.DRIVE.TAL_BL_CHANNEL));

    // The robot's drive
    private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
    
    public Drive_s() {
        // Invert one side of the drive train
        m_rightMotors.setInverted(true);
    }

    /**
     * Arcade drive mode for the robot
     * @param forwardSpeed
     * @param rotation
     */
    public void arcadeDrive(double forwardSpeed, double rotation) {
        m_drive.arcadeDrive(forwardSpeed, rotation);
    }
}
