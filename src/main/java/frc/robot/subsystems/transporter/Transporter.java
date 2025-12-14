package frc.robot.subsystems.transporter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Transporter extends SubsystemBase {
    private final WPI_TalonSRX motor = TransporterConstants.MASTER_MOTOR;

    public Transporter() {
    }

    void setTargetState(TransporterConstants.TransporterState targetState) {
        setTargetVoltage(targetState.targetVoltage);
    }

    void setTargetVoltage(double targetVoltage) {
        motor.setVoltage(targetVoltage);
    }

    void stop(){
        TransporterConstants.MASTER_MOTOR.stopMotor();
        TransporterConstants.FOLLOWER_MOTOR.stopMotor();
    }
}