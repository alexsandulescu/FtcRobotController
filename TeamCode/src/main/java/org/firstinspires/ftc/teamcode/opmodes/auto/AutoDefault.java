package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.vision.DetectedObject;
import org.firstinspires.ftc.teamcode.vision.WebcamVision;

@Autonomous
public class AutoDefault extends AutoOM{

    private DetectedObject detectedObject;

    @Override
    protected void setup() {
    }

    @Override
    protected void run() {
        DetectedObject object = webcamVision.getFrontDetection();

        switch (object.objectCode) {
            case NO_OBJECT: {
                caseNoObject();
                break;
            }
            case SINGLE: {
                caseSingle();
                break;
            }
            case QUAD: {
                caseQuad();
                break;
            }
        }
    }

    private void caseNoObject() {

    }

    private void caseSingle() {

    }

    private void caseQuad() {

    }
}
