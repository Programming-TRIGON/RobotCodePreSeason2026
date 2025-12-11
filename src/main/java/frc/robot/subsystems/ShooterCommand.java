package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import frc.robot.RobotContainer;

import java.util.function.Supplier;

public class ShooterCommand {
    public static Command getSetTargetState(ShooterConstants.ShooterState targetState) {
        return new FunctionalCommand(
                () -> RobotContainer.SHOOTER.setTargetState(targetState),
                () -> RobotContainer.SHOOTER.setTargetState(targetState),
                interrupted -> RobotContainer.SHOOTER.stop(),
                () -> false,
                RobotContainer.SHOOTER
        );
    }

    public static Command getSetTargetVoltage(Supplier<Double> targetVoltage) {
        return new FunctionalCommand(
                () -> {},
                () -> RobotContainer.SHOOTER.setTargetVoltage(targetVoltage.get()),
                (interrupted) -> RobotContainer.SHOOTER.stop(),
                () -> false,
                RobotContainer.SHOOTER
        );
    }
}
