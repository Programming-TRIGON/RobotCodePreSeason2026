// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.GeneralCommands;
import frc.robot.constants.OperatorConstants;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.IntakeCommands;
import frc.robot.subsystems.intake.IntakeConstants;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.shooter.ShooterCommands;
import frc.robot.subsystems.shooter.ShooterConstants;
import frc.robot.subsystems.tank.Tank;
import frc.robot.subsystems.tank.TankCommands;
import frc.robot.subsystems.transporter.Transporter;
import frc.robot.subsystems.transporter.TransporterCommands;
import frc.robot.subsystems.transporter.TransporterConstants;

public class RobotContainer {
    public static final Intake INTAKE = new Intake();
    public static Shooter SHOOTER = new Shooter();
    public static Transporter TRANSPORTER = new Transporter();
    public static final Tank TANK = new Tank();

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        bindDefaultCommands();
        bindControllerCommands();
    }

    private void bindDefaultCommands() {
        TANK.setDefaultCommand(GeneralCommands.getTankDefaultCommand());
        INTAKE.setDefaultCommand(IntakeCommands.getSetTargetStateCommand(IntakeConstants.IntakeState.REST));
        SHOOTER.setDefaultCommand(ShooterCommands.getSetTargetStateCommand(ShooterConstants.ShooterState.REST));
        TRANSPORTER.setDefaultCommand(TransporterCommands.getSetTargetStateCommand(TransporterConstants.TransporterState.REST));
    }

    private void bindControllerCommands() {
    }


    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}