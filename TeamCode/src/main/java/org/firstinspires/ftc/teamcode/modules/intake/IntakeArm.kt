package org.firstinspires.ftc.teamcode.modules.intake

import com.andreidurlea.corecontrol.commandsFeature.InstantCommand
import com.andreidurlea.corecontrol.miscellaneous.hardwareMapEverywhere
import com.andreidurlea.corecontrol.modulesFeature.Module
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.teamcode.HardwareNames

object IntakeArm : Module() {
    const val HOME_POS = 0.35
    const val UPPER_POS = 0.6
    const val LOWER_POS = 0.1

    enum class State{
        HOME,
        UPPER,
        LOWER
    }

    lateinit var servo : Servo
    var state : State = State.HOME

    override fun onInit() {
        servo = hardwareMapEverywhere.servo.get(HardwareNames.intakeServo)
        goHome.register()
    }

    val goHome = InstantCommand({ servo.position = HOME_POS })
    val goLower = InstantCommand({ servo.position = LOWER_POS })
    val goUpper = InstantCommand({ servo.position = UPPER_POS })

}