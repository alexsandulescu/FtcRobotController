package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.OuttakeSubsystem;

public class OuttakeLaunchCommand  extends CommandBase {

    private final OuttakeSubsystem outtake;
    private boolean shouldRetreat = false;

    public OuttakeLaunchCommand(OuttakeSubsystem subsystem) {
        outtake = subsystem;
        addRequirements(outtake);
    }

    @Override
    public void initialize() {
        outtake.launchServo();
    }

    @Override
    public void execute() {
        //if(outtake.getServoPos() == 1.0) shouldRetreat = true;
    }

    @Override
    public void end(boolean interrupted) {
        //outtake.retreatServo();
    }

    @Override
    public boolean isFinished() {
        return shouldRetreat;
    }
}
