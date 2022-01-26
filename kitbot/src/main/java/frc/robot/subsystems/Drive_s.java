package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

/**
 * Drive subsystem
 */
public class Drive_s extends SubsystemBase{
    
    private WPI_TalonSRX talLF;
    private WPI_TalonSRX talLB;
    private WPI_TalonSRX talRF;
    private WPI_TalonSRX talRB;

    private DifferentialDrive diffDrive;
    
    
    public Drive_s() {

        talLF = new WPI_TalonSRX(Constants.DRIVE.TAL_LF_ID);
        talLB = new WPI_TalonSRX(Constants.DRIVE.TAL_LB_ID);
        talRF = new WPI_TalonSRX(Constants.DRIVE.TAL_RF_ID);
        talRB = new WPI_TalonSRX(Constants.DRIVE.TAL_RB_ID);

        talLF.configFactoryDefault();
        talLB.configFactoryDefault();
        talRF.configFactoryDefault();
        talRB.configFactoryDefault();

        talLF.setNeutralMode(NeutralMode.Brake);
        talLB.setNeutralMode(NeutralMode.Brake);
        talRF.setNeutralMode(NeutralMode.Brake);
        talRB.setNeutralMode(NeutralMode.Brake);

        talLF.setInverted(false);
        talLB.setInverted(false);
        talRF.setInverted(true);
        talRB.setInverted(true);

        talLB.follow(talLF);
        talRB.follow(talRF);

        diffDrive = new DifferentialDrive(talLF, talRF);
    }

    /**
     * Arcade drive mode for the robot
     * @param forwardSpeed
     * @param rotation
     */
    public void arcadeDrive(double forwardSpeed, double rotation) {
        diffDrive.arcadeDrive(forwardSpeed, rotation);
    }

    public void curvatureDrive(double speed, double rotation) {
        diffDrive.curvatureDrive(speed, rotation, true);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("talLF", talLF.get());
        SmartDashboard.putNumber("talLR", talLB.get());
        SmartDashboard.putNumber("talBF", talRF.get());
        SmartDashboard.putNumber("talBR", talRB.get());
    }
}
