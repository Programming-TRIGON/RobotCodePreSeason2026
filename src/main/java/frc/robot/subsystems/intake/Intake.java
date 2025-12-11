package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private final WPI_TalonSRX motor = IntakeConstants.MASTER_MOTOR;

    public Intake() {
    }

    void setTargetState(IntakeConstants.IntakeState targetState) {
        setTargetVoltage(targetState.targetVoltage);
    }

    void setTargetVoltage(double targetVoltage) {
        motor.setVoltage(targetVoltage);
    }

    void stop(){
        motor.stopMotor();
    }
}