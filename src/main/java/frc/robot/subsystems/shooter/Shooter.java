package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final WPI_TalonSRX motor = ShooterConstants.MOTOR;

    public Shooter() {
    }

    void setTargetState(ShooterConstants.ShooterState targetState) {
        setTargetVoltage(targetState.targetVoltage);
    }

    void setTargetVoltage(double targetVoltage) {
        motor.setVoltage(targetVoltage);
    }

    void stop(){
        ShooterConstants.MOTOR.stopMotor();
        ShooterConstants.FOLLOWER_MOTOR.stopMotor();
    }
}