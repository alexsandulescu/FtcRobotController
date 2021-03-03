package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDriveTeleopSubsystem extends SubsystemBase {

    private final Motor motorFL, motorFR, motorBL, motorBR;
    private final MecanumDrive mecanum;


    public MecanumDriveTeleopSubsystem(final HardwareMap hMap) {
        motorFL = new Motor(hMap, "motorFL");
        motorFR = new Motor(hMap, "motorFR");
        motorBL = new Motor(hMap, "motorBL");
        motorBR = new Motor(hMap, "motorBR");

        mecanum = new MecanumDrive(true, motorFL, motorFR, motorBL, motorBR);
    }

    public void move(double strafe, double forward, double turn) {
        mecanum.driveFieldCentric(strafe, forward, turn, 0);
    }




}