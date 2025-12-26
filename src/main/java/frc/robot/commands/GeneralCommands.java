package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.OperatorConstants;
import frc.robot.subsystems.tank.TankCommands;

public class GeneralCommands {

    public static Command getTankDefaultCommand() {
        return TankCommands.getArcadeDriveCommand(
                () -> CommandConstants.calculateDriveStickAxisValue(OperatorConstants.DRIVER_CONTROLLER.getLeftY()),
                () -> CommandConstants.calculateDriveStickAxisValue(OperatorConstants.DRIVER_CONTROLLER.getRightX())
        );
    }
}