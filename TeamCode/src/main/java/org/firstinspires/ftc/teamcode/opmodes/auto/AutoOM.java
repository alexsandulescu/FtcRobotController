package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.vision.WebcamVision;


public abstract class AutoOM extends LinearOpMode {

    WebcamVision webcamVision;

    @Override
    public void runOpMode() {

        webcamVision = new WebcamVision(this);

        setup();
        waitForStart();
        run();
//        while(opModeIsActive());
    }

    protected void setup() {};
    protected void run() {};
}
