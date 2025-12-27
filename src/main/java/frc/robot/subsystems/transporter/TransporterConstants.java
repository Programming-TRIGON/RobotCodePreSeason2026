package frc.robot.subsystems.transporter;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class TransporterConstants {
    private static final int MOTOR_ID = 7;

    static final WPI_TalonSRX MOTOR = new WPI_TalonSRX(MOTOR_ID);

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

    public enum TransporterState {
        COLLECT_STATE(3),
        EJECT_STAGE(-3),
        REST(0);

        public final double targetVoltage;

        TransporterState(double targetVoltage) {
            this.targetVoltage = targetVoltage;
        }
    }
}