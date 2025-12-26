package frc.robot.subsystems.sparkShooter;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

public class SparkShooterConstants {
    private static final int MOTOR_ID = 8;

    static final SparkMax MOTOR = new SparkMax(MOTOR_ID, SparkLowLevel.MotorType.kBrushless);

    private static final boolean SHOULD_MOTOR_INVERT = false;
    private static final SparkBaseConfig.IdleMode IDLE_MODE = SparkBaseConfig.IdleMode.kBrake;

    private static final double VOLTAGE_LIMIT = 12;

    static {
        SparkMaxConfig config = new SparkMaxConfig();
        config.inverted(SHOULD_MOTOR_INVERT);
        config.voltageCompensation(VOLTAGE_LIMIT);
        config.idleMode(SparkBaseConfig.IdleMode.kBrake);

        MOTOR.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kNoPersistParameters);
    }

    public enum SparkShooterState {
        REST(0),
        SHOOT(5),
        EJECT(2);

        public final double targetVoltage;

        SparkShooterState(double targetVoltage) {
            this.targetVoltage = targetVoltage;
        }
    }
}