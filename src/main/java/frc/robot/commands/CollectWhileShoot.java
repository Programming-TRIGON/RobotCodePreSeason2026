package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.intake.IntakeCommands;
import frc.robot.subsystems.intake.IntakeConstants;
import frc.robot.subsystems.shooter.ShooterCommands;
import frc.robot.subsystems.shooter.ShooterConstants;
import frc.robot.subsystems.sparkShooter.SparkShooterCommands;
import frc.robot.subsystems.sparkShooter.SparkShooterConstants;
import frc.robot.subsystems.transporter.TransporterCommands;
import frc.robot.subsystems.transporter.TransporterConstants;

public class CollectWhileShoot {
    public static Command CollectingAndShootingCommand(){
        return new ParallelCommandGroup(
                SparkShooterCommands.getSetTargetStateCommand(SparkShooterConstants.SparkShooterState.SHOOT),
                IntakeCommands.getSetTargetStateCommand(IntakeConstants.IntakeState.COLLECT_STATE),
                TransporterCommands.getSetTargetStateCommand(TransporterConstants.TransporterState.COLLECT_STATE)
        );
    }
}
