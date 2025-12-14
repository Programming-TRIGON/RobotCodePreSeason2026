package frc.robot.subsystems.tank;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import frc.robot.RobotContainer;

import java.util.function.Supplier;

public class TankCommands {
    public static Command getArcadeDriveCommand(Supplier<Double> targetDriveSpeed, Supplier<Double> targetRotationSpeed) {
        return new FunctionalCommand(
                () -> {
                },
                () -> RobotContainer.TANK.arcadeDrive(targetDriveSpeed.get(), targetRotationSpeed.get()),
                (interrupted) -> RobotContainer.TANK.stop(),
                () -> false,
                RobotContainer.TANK
        );
    }
}