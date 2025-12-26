package frc.robot.subsystems.sparkShooter;


import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SparkShooter extends SubsystemBase {
    private final SparkMax motor = SparkShooterConstants.MOTOR;

    public SparkShooter() {
    }

    void stop() {
        motor.stopMotor();
    }

    void setTargetState(SparkShooterConstants.SparkShooterState targetState) {
        setTargetVoltage(targetState.targetVoltage);
    }

    private void setTargetVoltage(double targetVoltage) {
        motor.setVoltage(targetVoltage);
    }


}

