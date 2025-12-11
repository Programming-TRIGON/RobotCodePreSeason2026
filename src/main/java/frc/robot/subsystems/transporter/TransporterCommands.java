package frc.robot.subsystems.transporter;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.RobotContainer;

import java.util.function.Supplier;

public class TransporterCommands {
    public static Command getSetTargetStateCommand(TransporterConstants.TransporterState targetState) {
        return new StartEndCommand(
                () ->RobotContainer.TRANSPORTER.setTargetState(targetState),
                RobotContainer.TRANSPORTER::stop,
                RobotContainer.TRANSPORTER
        );
    }

    public static Command getSetTargetVoltage(double targetVoltage) {
        return new StartEndCommand(
                () ->RobotContainer.TRANSPORTER.setTargetVoltage(targetVoltage),
                RobotContainer.TRANSPORTER::stop,
                RobotContainer.TRANSPORTER
        );
    }
}