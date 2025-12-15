package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.shooter.ShooterCommands;
import frc.robot.subsystems.shooter.ShooterConstants;

public class ShootingCommands extends ParallelCommandGroup {
    public static Command ShootTenisBall (){
        return new ParallelCommandGroup(
                ShooterCommands.getSetTargetStateCommand(ShooterConstants.ShooterState.SHOOT),
                ShooterCommands.getSetTargetStateCommand(ShooterConstants.ShooterState.EJECT)
        );
    }
}
