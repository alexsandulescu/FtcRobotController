package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.OuttakeSubsystem;

public class OuttakeOnCommand  extends CommandBase {

    private final OuttakeSubsystem outtake;

    public OuttakeOnCommand(OuttakeSubsystem subsystem) {
        outtake = subsystem;
        addRequirements(outtake);
    }

    @Override
    public void initialize() {
        outtake.on();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        outtake.off();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
