package frc.robot.subsystems.tank;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TankConstants {
    private static final int
            LEFT_MASTER_ID = 1,
            LEFT_FOLLOWER_ID = 2,
            RIGHT_MASTER_ID = 3,
            RIGHT_FOLLOWER_ID = 4;
    static final WPI_TalonSRX
            LEFT_MASTER = new WPI_TalonSRX(LEFT_MASTER_ID),
            LEFT_FOLLOWER = new WPI_TalonSRX(LEFT_FOLLOWER_ID),
            RIGHT_MASTER = new WPI_TalonSRX(RIGHT_MASTER_ID),
            RIGHT_FOLLOWER = new WPI_TalonSRX(RIGHT_FOLLOWER_ID);

    private static final boolean
            LEFT_MASTER_INVERTED_VALUE = true,
            LEFT_FOLLOWER_INVERTED_VALUE = true,
            RIGHT_MASTER_INVERTED_VALUE = false,
            RIGHT_FOLLOWER_INVERTED_VALUE = false;
    private static final NeutralMode NEUTRAL_MODE = NeutralMode.Brake;
    private static final double VOLTAGE_LIMIT = 12;

    static final DifferentialDrive DIFFERENTIAL_DRIVE = new DifferentialDrive(LEFT_MASTER, RIGHT_MASTER);
    static final double
            MAX_DRIVE_SPEED = 0.7,
            MAX_ROTATION_SPEED = 0.56;
    static final double
            DRIVE_DEADBAND = 0.02,
            ROTATION_DEADBAND = 0.02;
    static final boolean ARCADE_DRIVE_SQUARE_INPUT = true;

    static {
        configLeftMotors();
        configRightMotors();
    }

    private static void configLeftMotors() {
        LEFT_MASTER.configFactoryDefault();
        LEFT_FOLLOWER.configFactoryDefault();
        LEFT_MASTER.enableVoltageCompensation(true);
        LEFT_FOLLOWER.enableVoltageCompensation(true);
        LEFT_MASTER.configVoltageCompSaturation(VOLTAGE_LIMIT);
        LEFT_FOLLOWER.configVoltageCompSaturation(VOLTAGE_LIMIT);
        LEFT_MASTER.setInverted(LEFT_MASTER_INVERTED_VALUE);
        LEFT_FOLLOWER.setInverted(LEFT_FOLLOWER_INVERTED_VALUE);
        LEFT_MASTER.setNeutralMode(NEUTRAL_MODE);
        LEFT_FOLLOWER.setNeutralMode(NEUTRAL_MODE);
        LEFT_FOLLOWER.follow(LEFT_MASTER, FollowerType.PercentOutput);
    }

    private static void configRightMotors() {
        RIGHT_MASTER.configFactoryDefault();
        RIGHT_FOLLOWER.configFactoryDefault();
        RIGHT_MASTER.enableVoltageCompensation(true);
        RIGHT_FOLLOWER.enableVoltageCompensation(true);
        RIGHT_MASTER.configVoltageCompSaturation(VOLTAGE_LIMIT);
        RIGHT_FOLLOWER.configVoltageCompSaturation(VOLTAGE_LIMIT);
        RIGHT_MASTER.setInverted(RIGHT_MASTER_INVERTED_VALUE);
        RIGHT_FOLLOWER.setInverted(RIGHT_FOLLOWER_INVERTED_VALUE);
        RIGHT_MASTER.setNeutralMode(NEUTRAL_MODE);
        RIGHT_FOLLOWER.setNeutralMode(NEUTRAL_MODE);
        RIGHT_FOLLOWER.follow(RIGHT_MASTER, FollowerType.PercentOutput);
    }
}