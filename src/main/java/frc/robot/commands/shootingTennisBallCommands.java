package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.shooter.ShooterCommands;
import frc.robot.subsystems.shooter.ShooterConstants;
import frc.robot.subsystems.transporter.TransporterCommands;
import frc.robot.subsystems.transporter.TransporterConstants;

public class shootingTennisBallCommands extends ParallelCommandGroup {
    public static Command ShootTennisBallCommand(){
        return new ParallelCommandGroup(
                ShooterCommands.getSetTargetStateCommand(ShooterConstants.ShooterState.SHOOT),
                TransporterCommands.getSetTargetStateCommand(TransporterConstants.TransporterState.EJECT_STAGE)
        );
    }

    public static Command EjectTennisBallCommand(){
        return new ParallelCommandGroup(
                ShooterCommands.getSetTargetStateCommand(ShooterConstants.ShooterState.EJECT)
        );
    }
}