package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ShooterConstants {
    private static final int MASTER_MOTOR_ID = 8;
    static final WPI_TalonSRX MOTOR = new WPI_TalonSRX(MASTER_MOTOR_ID);
    private static final boolean SHOULD_MOTOR_INVERT = true;
    private static final NeutralMode NEUTRAL_MODE = NeutralMode.Brake;

    private static final double VOLTAGE_LIMIT = 12;

    static {
        MOTOR.configFactoryDefault();
        MOTOR.enableVoltageCompensation(true);
        MOTOR.configVoltageCompSaturation(VOLTAGE_LIMIT);
        MOTOR.setNeutralMode(NEUTRAL_MODE);
        MOTOR.setInverted(SHOULD_MOTOR_INVERT);
    }

    public enum ShooterState {
        REST(0),
        SHOOT(5),
        EJECT(2);

        public final double targetVoltage;

        ShooterState(double targetVoltage) {
            this.targetVoltage = targetVoltage;
        }
    }
}