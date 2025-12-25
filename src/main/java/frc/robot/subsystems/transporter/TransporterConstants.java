package frc.robot.subsystems.transporter;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.units.measure.Voltage;

public class TransporterConstants {
    private static final int
            MASTER_MOTOR_ID = 7,
            FOLLOWER_MOTOR_ID = 8;
    static final WPI_TalonSRX
            MASTER_MOTOR = new WPI_TalonSRX(MASTER_MOTOR_ID),
            FOLLOWER_MOTOR = new WPI_TalonSRX(FOLLOWER_MOTOR_ID);

    private static final boolean
            SHOULD_MASTER_MOTOR_INVERT = true,
            SHOULD_FOLLOWER_MOTOR_INVERT = false;
    private static final NeutralMode NEUTRAL_MODE = NeutralMode.Brake;

    private static final double VOLTAGE_LIMIT = 12;

    static {
        configureMasterMotor();
        configureFollowerMotor();
    }

    private static void configureMasterMotor() {
        MASTER_MOTOR.configFactoryDefault();
        MASTER_MOTOR.enableVoltageCompensation(true);
        MASTER_MOTOR.configVoltageCompSaturation(VOLTAGE_LIMIT);
        MASTER_MOTOR.setNeutralMode(NEUTRAL_MODE);
        MASTER_MOTOR.setInverted(SHOULD_MASTER_MOTOR_INVERT);
    }

    private static void configureFollowerMotor() {
        FOLLOWER_MOTOR.configFactoryDefault();
        FOLLOWER_MOTOR.enableVoltageCompensation(true);
        FOLLOWER_MOTOR.configVoltageCompSaturation(VOLTAGE_LIMIT);
        FOLLOWER_MOTOR.setNeutralMode(NEUTRAL_MODE);
        FOLLOWER_MOTOR.setInverted(SHOULD_FOLLOWER_MOTOR_INVERT);
        FOLLOWER_MOTOR.follow(MASTER_MOTOR, FollowerType.PercentOutput);
    }

    public enum TransporterState{
        COLLECT_STATE(-5),
        EJECT_STAGE(4),
        REST(0);

        public final double targetVoltage;

        TransporterState(double targetVoltage){
            this.targetVoltage = targetVoltage;
        }
    }
}