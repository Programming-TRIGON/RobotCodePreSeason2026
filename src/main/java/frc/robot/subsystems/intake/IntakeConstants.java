package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeConstants {
    private static final int
            MASTER_MOTOR_ID = 5,
            FOLLOWER_MOTOR_ID = 6;
    static final WPI_TalonSRX
            MASTER_MOTOR = new WPI_TalonSRX(MASTER_MOTOR_ID),
            FOLLOWER_MOTOR = new WPI_TalonSRX(FOLLOWER_MOTOR_ID);

    private static final double VOLTAGE_LIMIT = 12.0;
    static final double MAX_SPINNING_SPEED = 1.0;

    private static final boolean
    SHOULD_MASTER_MOTOR_INVERT_VALUE = true,
    SHOULD_FOLLOWER_MOTOR_INVERT_VALUE = false;
    private static final NeutralMode NEUTRAL_MODE = NeutralMode.Brake;

    static {
        configureMotors();
    }

    private static void configureMotors() {
        MASTER_MOTOR.configFactoryDefault();
        MASTER_MOTOR.enableVoltageCompensation(true);
        MASTER_MOTOR.configVoltageCompSaturation(VOLTAGE_LIMIT);
        MASTER_MOTOR.setInverted(SHOULD_MASTER_MOTOR_INVERT_VALUE);
        MASTER_MOTOR.setNeutralMode(NEUTRAL_MODE);
        FOLLOWER_MOTOR.configFactoryDefault();
        FOLLOWER_MOTOR.enableVoltageCompensation(true);
        FOLLOWER_MOTOR.configVoltageCompSaturation(VOLTAGE_LIMIT);
        FOLLOWER_MOTOR.setInverted(SHOULD_FOLLOWER_MOTOR_INVERT_VALUE);
        FOLLOWER_MOTOR.setNeutralMode(NEUTRAL_MODE);
        FOLLOWER_MOTOR.follow(MASTER_MOTOR, FollowerType.PercentOutput);
    }

    public enum IntakeState {
        COLLECT_STATE(-12.0),
        EJECT_STATE(12.0),
        REST(0.0);

        public final double targetVoltage;

        IntakeState(double targetVoltage) {
            this.targetVoltage = targetVoltage;
        }
    }
}