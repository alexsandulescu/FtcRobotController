package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.commands.MecanumDriveTeleopCommand;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveTeleopSubsystem;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public abstract class TeleOM extends CommandOpMode {

    GamepadEx gamepadEx1, gamepadEx2;


    @Override
    public void initialize() {
        gamepadEx1 = new GamepadEx(gamepad1);
        gamepadEx2 = new GamepadEx(gamepad2);

        DoubleSupplier strafe = () -> gamepadEx1.getLeftX();
        DoubleSupplier forward = () -> gamepadEx1.getLeftY();
        DoubleSupplier turn = () -> 0;
        
        schedule(
                new MecanumDriveTeleopCommand(
                        new MecanumDriveTeleopSubsystem(hardwareMap),
                        strafe,
                        forward,
                        turn
                )
        );
    }

    protected abstract void setup();
}
