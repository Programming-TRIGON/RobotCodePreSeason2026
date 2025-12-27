package frc.robot.constants;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class OperatorConstants {
    private static final int DRIVER_CONTROLLER_PORT = 0;
    public static final CommandXboxController DRIVER_CONTROLLER = new CommandXboxController(DRIVER_CONTROLLER_PORT);
    public static final Trigger
            SHOOT = DRIVER_CONTROLLER.rightBumper().and(DRIVER_CONTROLLER.leftTrigger().negate()),
            COLLECT = DRIVER_CONTROLLER.leftTrigger().and(DRIVER_CONTROLLER.rightBumper().negate()),
            SHOOT_WHILE_COLLECT = DRIVER_CONTROLLER.leftTrigger().and(DRIVER_CONTROLLER.rightBumper().negate());
}