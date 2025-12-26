package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.constants.OperatorConstants;
import frc.robot.subsystems.tank.TankCommands;

public class CommandConstants {
    private static final CommandXboxController DRIVER_CONTROLLER = OperatorConstants.DRIVER_CONTROLLER;
    private static final double
            MINIMUM_DRIVE_SHIFT_POWER = 0.30,
            MINIMUM_ROTATION_SHIFT_POWER = 0.4;

    public static final Command
            DRIVE_TANK_COMMAND = TankCommands.getArcadeDriveCommand(
            () -> calculateDriveStickAxisValue(DRIVER_CONTROLLER.getLeftY()),
            () -> calculateRotationStickAxisValue(DRIVER_CONTROLLER.getRightX())
    );

    public static double calculateDriveStickAxisValue(double axisValue) {
        return axisValue / calculateShiftModeValue(MINIMUM_DRIVE_SHIFT_POWER);
    }

    public static double calculateRotationStickAxisValue(double axisValue) {
        return axisValue / calculateShiftModeValue(MINIMUM_ROTATION_SHIFT_POWER);
    }

    public static double calculateShiftModeValue(double minimumPower) {
        final double squaredShiftModeValue = Math.sqrt(DRIVER_CONTROLLER.getRightTriggerAxis());
        final double minimumShiftValueCoefficient = 1 - (1 / minimumPower);

        return 1 - squaredShiftModeValue * minimumShiftValueCoefficient;
    }
}

