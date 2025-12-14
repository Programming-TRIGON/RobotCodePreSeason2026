package frc.robot.subsystems.tank;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tank extends SubsystemBase {
    private final DifferentialDrive differentialDrive = TankConstants.DIFFERENTIAL_DRIVE;

    public Tank() {
    }

    void arcadeDrive(double targetDriveSpeed, double targetRotationSpeed) {
        final double limitedDriveSpeed = targetDriveSpeed * TankConstants.MAX_DRIVE_SPEED;
        final double limitedRotationSpeed = targetRotationSpeed * TankConstants.MAX_ROTATION_SPEED;

        final double deadbandedDriveSpeed = MathUtil.applyDeadband(limitedDriveSpeed, TankConstants.DRIVE_DEADBAND);
        final double deadbandedRotationSpeed = MathUtil.applyDeadband(limitedRotationSpeed, TankConstants.ROTATION_DEADBAND);

        differentialDrive.arcadeDrive(deadbandedDriveSpeed, deadbandedRotationSpeed, TankConstants.ARCADE_DRIVE_SQUARE_INPUT);
    }

    void stop() {
        differentialDrive.stopMotor();
    }
}