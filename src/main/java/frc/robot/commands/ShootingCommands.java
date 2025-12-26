package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.shooter.ShooterCommands;
import frc.robot.subsystems.shooter.ShooterConstants;
import frc.robot.subsystems.sparkShooter.SparkShooterCommands;
import frc.robot.subsystems.sparkShooter.SparkShooterConstants;
import frc.robot.subsystems.transporter.TransporterCommands;
import frc.robot.subsystems.transporter.TransporterConstants;

public class ShootingCommands {
    public static Command ShootTennisBallCommand() {
        return new ParallelCommandGroup(
                SparkShooterCommands.getSetTargetStateCommand(SparkShooterConstants.SparkShooterState.SHOOT),
                TransporterCommands.getSetTargetStateCommand(TransporterConstants.TransporterState.COLLECT_STATE)
        );
    }
    public static Command EjectTennisBallFromShooter() {
        return new ParallelCommandGroup(
                SparkShooterCommands.getSetTargetStateCommand(SparkShooterConstants.SparkShooterState.EJECT),
                TransporterCommands.getSetTargetStateCommand(TransporterConstants.TransporterState.COLLECT_STATE)
        );
    }
}
