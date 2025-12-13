package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final WPI_TalonSRX motor = ShooterConstants.MASTER_MOTOR;

    public Shooter() {
    }

    void setTargetVoltage(double targetVoltage) {
        motor.setVoltage(targetVoltage);
    }

    void setTargetState(ShooterConstants.ShooterState targetState) {
        setTargetVoltage(targetState.targetVoltage);
    }

    void stop(){
        setTargetVoltage(0);
    }
}