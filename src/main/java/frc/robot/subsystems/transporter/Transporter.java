package frc.robot.subsystems.transporter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Transporter extends SubsystemBase {
    private final WPI_TalonSRX motor = TransporterConstants.MASTER_MOTOR;

    public Transporter() {
    }

    void setTargetVoltage(double targetVoltage) {
        motor.setVoltage(targetVoltage);
    }

    void setTargetState(TransporterConstants.TransporterState targetState) {
        setTargetVoltage(targetState.targetVoltage);
    }

    void stop(){
        setTargetVoltage(0);
    }
}