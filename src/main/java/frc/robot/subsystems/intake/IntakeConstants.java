package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeConstants {
    private static final int
            INTAKE_MOTOR_ID = 5,
            CENTRALIZATION_MOTOR_ID = 6;
    static final WPI_TalonSRX
            INTAKE_MOTOR = new WPI_TalonSRX(INTAKE_MOTOR_ID),
            CENTRALIZATION_MOTOR = new WPI_TalonSRX(CENTRALIZATION_MOTOR_ID);

    private static final double VOLTAGE_LIMIT = 12.0;

    private static final boolean
            SHOULD_MASTER_MOTOR_INVERT_VALUE = true,
            SHOULD_FOLLOWER_MOTOR_INVERT_VALUE = false;
    private static final NeutralMode NEUTRAL_MODE = NeutralMode.Brake;

    static {
        configureMasterMotor();
        configureFollowerMotor();
    }

    private static void configureMasterMotor() {
        INTAKE_MOTOR.configFactoryDefault();
        INTAKE_MOTOR.enableVoltageCompensation(true);
        INTAKE_MOTOR.configVoltageCompSaturation(VOLTAGE_LIMIT);
        INTAKE_MOTOR.setInverted(SHOULD_MASTER_MOTOR_INVERT_VALUE);
        INTAKE_MOTOR.setNeutralMode(NEUTRAL_MODE);
    }

    private static void configureFollowerMotor() {
        CENTRALIZATION_MOTOR.configFactoryDefault();
        CENTRALIZATION_MOTOR.enableVoltageCompensation(true);
        CENTRALIZATION_MOTOR.configVoltageCompSaturation(VOLTAGE_LIMIT);
        CENTRALIZATION_MOTOR.setInverted(SHOULD_FOLLOWER_MOTOR_INVERT_VALUE);
        CENTRALIZATION_MOTOR.setNeutralMode(NEUTRAL_MODE);
        CENTRALIZATION_MOTOR.follow(INTAKE_MOTOR, FollowerType.PercentOutput);
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