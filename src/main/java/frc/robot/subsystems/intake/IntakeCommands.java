package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import frc.robot.RobotContainer;

import java.util.function.Supplier;

public class IntakeCommands {
    public static Command getSetTargetState(IntakeConstants.IntakeState targetState) {
        return new FunctionalCommand(
                () -> RobotContainer.INTAKE.setTargetState(targetState),
                () -> RobotContainer.INTAKE.setTargetState(targetState),
                (interrupted) -> RobotContainer.INTAKE.stop(),
                () -> false,
                RobotContainer.INTAKE
        );
    }

    public static Command getSetTargetVoltage(Supplier<Double> targetVoltage) {
        return new FunctionalCommand(
                () -> {},
                () -> RobotContainer.INTAKE.setTargetVoltage(targetVoltage.get()),
                (interrupted) -> RobotContainer.INTAKE.stop(),
                () -> false,
                RobotContainer.INTAKE
        );
    }
}
