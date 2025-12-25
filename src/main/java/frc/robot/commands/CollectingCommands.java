package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.intake.IntakeCommands;
import frc.robot.subsystems.intake.IntakeConstants;
import frc.robot.subsystems.transporter.TransporterCommands;
import frc.robot.subsystems.transporter.TransporterConstants;

public class CollectingCommands {
    public static Command CollectTennisBall() {
        return new ParallelCommandGroup(
                IntakeCommands.getSetTargetStateCommand(IntakeConstants.IntakeState.COLLECT_STATE),
                TransporterCommands.getSetTargetStateCommand(TransporterConstants.TransporterState.COLLECT_STATE)
        );
    }

    public static Command EjectTennisBall() {
        return new ParallelCommandGroup(
                IntakeCommands.getSetTargetStateCommand(IntakeConstants.IntakeState.EJECT_STATE),
                TransporterCommands.getSetTargetStateCommand(TransporterConstants.TransporterState.EJECT_STAGE)
        );
    }
}
