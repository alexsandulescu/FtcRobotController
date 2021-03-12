package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.ArmServoGrabCommand;
import org.firstinspires.ftc.teamcode.commands.ArmServoLetCommand;
import org.firstinspires.ftc.teamcode.commands.ArmTeleopLowerCommand;
import org.firstinspires.ftc.teamcode.commands.ArmTeleopRaiseCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeInverseCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeOnCommand;
import org.firstinspires.ftc.teamcode.commands.MecanumDriveTeleopCommand;
import org.firstinspires.ftc.teamcode.commands.OuttakeLaunchCommand;
import org.firstinspires.ftc.teamcode.commands.OuttakeOnCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveTeleopSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.OuttakeSubsystem;

import java.util.function.DoubleSupplier;

@TeleOp
public class TeleOMDefault extends CommandOpMode {

    GamepadEx movementGamepad, systemsGamepad;
    MecanumDriveTeleopSubsystem movementSubsystem;
    IntakeSubsystem intakeSubsystem;
    ArmSubsystem armSubsystem;
    OuttakeSubsystem outtakeSubsystem;



    @Override
    public void initialize() {
        movementGamepad = new GamepadEx(gamepad1);
//      systemsGamepad = new GamepadEx(gamepad2);
        systemsGamepad = movementGamepad;

        movementSubsystem = new MecanumDriveTeleopSubsystem(hardwareMap);
        intakeSubsystem = new IntakeSubsystem(hardwareMap);
        armSubsystem = new ArmSubsystem(hardwareMap, true);
        outtakeSubsystem = new OuttakeSubsystem(hardwareMap);


        // Movement
        DoubleSupplier strafe = () -> movementGamepad.getLeftX();
        DoubleSupplier forward = () -> movementGamepad.getLeftY();
        DoubleSupplier turn = () -> -movementGamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) +
                movementGamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER);

        schedule(
                new MecanumDriveTeleopCommand(
                        movementSubsystem,
                        strafe,
                        forward,
                        turn
                )
        );

        // Intake
        GamepadButton intakeButton = new GamepadButton(movementGamepad, GamepadKeys.Button.A);
        intakeButton.toggleWhenActive(new IntakeOnCommand(intakeSubsystem));
        GamepadButton  intakeInverseButton= new GamepadButton(movementGamepad, GamepadKeys.Button.B);
        intakeInverseButton.toggleWhenActive(new IntakeInverseCommand(intakeSubsystem));

        // Arm
        GamepadButton raiseArmButton = new GamepadButton(systemsGamepad, GamepadKeys.Button.DPAD_UP);
        raiseArmButton.whileActiveContinuous(new ArmTeleopRaiseCommand(armSubsystem));
        GamepadButton  lowerArmButton= new GamepadButton(systemsGamepad, GamepadKeys.Button.DPAD_DOWN);
        lowerArmButton.whileActiveContinuous(new ArmTeleopLowerCommand(armSubsystem));
        GamepadButton armGrabButton = new GamepadButton(systemsGamepad, GamepadKeys.Button.Y);
        armGrabButton.toggleWhenActive(new ArmServoGrabCommand(armSubsystem));
        GamepadButton armLetButton = new GamepadButton(systemsGamepad, GamepadKeys.Button.X);
        armLetButton.toggleWhenActive(new ArmServoLetCommand(armSubsystem));

        // Outtake
        GamepadButton outtakeButton = new GamepadButton(systemsGamepad, GamepadKeys.Button.LEFT_BUMPER);
        outtakeButton.toggleWhenPressed(new OuttakeOnCommand(outtakeSubsystem));
        //GamepadButton launchButton = new GamepadButton(systemsGamepad, GamepadKeys.Button.RIGHT_BUMPER);
        //launchButton.whenPressed(new OuttakeLaunchCommand(outtakeSubsystem));


    }

}
