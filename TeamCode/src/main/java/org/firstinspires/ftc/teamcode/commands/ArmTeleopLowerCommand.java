package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

public class ArmTeleopLowerCommand extends CommandBase {

    private final ArmSubsystem arm;

    public ArmTeleopLowerCommand(ArmSubsystem subsystem) {
        arm = subsystem;
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        arm.moveArm(-1);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        arm.moveArm(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
