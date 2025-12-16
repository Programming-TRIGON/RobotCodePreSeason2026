// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.tank.Tank;
import frc.robot.subsystems.tank.TankCommands;
import frc.robot.subsystems.transporter.Transporter;
import frc.robot.commands.*;

public class RobotContainer {
    public static final Intake INTAKE = new Intake();
    public static Shooter SHOOTER =  new Shooter();
    public static Transporter TRANSPORTER = new Transporter();
    public static final Tank TANK = new Tank();
    private static final CommandXboxController DRIVER_CONTROLLER = new CommandXboxController(0);

    public RobotContainer() {
        configureBindings();
        TANK.setDefaultCommand(
                TankCommands.getArcadeDriveCommand(
                        () -> -DRIVER_CONTROLLER.getLeftY(),
                        DRIVER_CONTROLLER::getRightX
                )
        );

        /*DRIVER_CONTROLLER.rightTrigger().whileTrue(
                IntakeAndTransportTennisBallCommand.CollectTennisBall()
        );

        DRIVER_CONTROLLER.rightBumper().whileTrue(
                IntakeAndTransportTennisBallCommand.EjectTennisBall()
        );*/
    }
    
    private void configureBindings() {
    }
    
    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}