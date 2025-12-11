package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.units.measure.Voltage;

public class ShooterConstants {
    private static final int
            MASTER_MOTOR_ID = 9,
            FOLLOWER_MOTOR_ID = 10;

    static final WPI_TalonSRX
            MASTER_MOTOR = new WPI_TalonSRX(MASTER_MOTOR_ID),
            FOLLOWER_MOTOR = new WPI_TalonSRX(FOLLOWER_MOTOR_ID);

    private static final boolean
            MASTER_MOTOR_INVERTED_VALUE = true,
            FOLLOWER_MOTOR_INVERTED_VALUE = false;
    private static final NeutralMode NEUTRAL_MODE = NeutralMode.Brake;

    private static final double VOLTAGE_LIMIT = 12;

    static {
        configureMaster();
        configureFollower();
    }

    private static void configureMaster() {
        MASTER_MOTOR.configFactoryDefault();
        MASTER_MOTOR.enableVoltageCompensation(true);
        MASTER_MOTOR.configVoltageCompSaturation(VOLTAGE_LIMIT);
        MASTER_MOTOR.setNeutralMode(NEUTRAL_MODE);
        MASTER_MOTOR.setInverted(MASTER_MOTOR_INVERTED_VALUE);
    }

    private static void configureFollower() {
        FOLLOWER_MOTOR.configFactoryDefault();
        FOLLOWER_MOTOR.enableVoltageCompensation(true);
        FOLLOWER_MOTOR.configVoltageCompSaturation(VOLTAGE_LIMIT);
        FOLLOWER_MOTOR.setNeutralMode(NEUTRAL_MODE);
        FOLLOWER_MOTOR.setInverted(FOLLOWER_MOTOR_INVERTED_VALUE);
        FOLLOWER_MOTOR.follow(MASTER_MOTOR, FollowerType.PercentOutput);
    }

    public enum ShooterState{
        COLLECT_STATE(-12),
        EJECT_STAGE(12),
        REST(0);

        public final double targetVoltage;

        ShooterState(double targetVoltage){
            this.targetVoltage = targetVoltage;
        }
    }
}