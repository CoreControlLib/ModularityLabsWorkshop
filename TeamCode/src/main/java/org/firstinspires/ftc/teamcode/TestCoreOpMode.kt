package org.firstinspires.ftc.teamcode

import com.andreidurlea.corecontrol.buttonsFeature.ActionButton
import com.andreidurlea.corecontrol.buttonsFeature.Button
import com.andreidurlea.corecontrol.opModesFeature.CoreTeleOp
import org.firstinspires.ftc.teamcode.modules.intake.Intake

class TestCoreOpMode : CoreTeleOp(Intake) {


    val activateIntake = ActionButton({ gamepad1.a })

    val intakeFor2Seconds = Button({ gamepad1.b })

    override fun onMainLoop() {
        if (activateIntake.pressed) {
            Intake.turnOn.register()
        }
        if (activateIntake.released) {
            Intake.turnOff.register()
        }

        if (gamepad1.b) {
            Intake.turnOnFor2Seconds.register()
        }
    }
}