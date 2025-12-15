package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.RobotContainer;

public class ShooterCommands {
    public static Command getSetTargetStateCommand(ShooterConstants.ShooterState targetState) {
        return new StartEndCommand(
                () ->RobotContainer.SHOOTER.setTargetState(targetState),
                RobotContainer.SHOOTER::stop,
                RobotContainer.SHOOTER
        );
    }

    public static Command getSetTargetVoltage(double targetVoltage) {
        return new StartEndCommand(
                () ->RobotContainer.SHOOTER.setTargetVoltage(targetVoltage),
                RobotContainer.SHOOTER::stop,
                RobotContainer.SHOOTER
        );
    }
}