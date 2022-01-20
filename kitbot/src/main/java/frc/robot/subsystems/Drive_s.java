package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive_s extends SubsystemBase{

    TalonFX talFL;
    TalonFX talBL;
    TalonFX talFR;
    TalonFX talBR;

    
    public Drive_s() {
        talFL = new TalonFX();
        talBL = new TalonFX();
        talFR = new TalonFX();
        talBR = new TalonFX();

        tal
    }

}
