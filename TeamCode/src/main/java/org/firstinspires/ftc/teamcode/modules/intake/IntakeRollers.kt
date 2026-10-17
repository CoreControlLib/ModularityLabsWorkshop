package org.firstinspires.ftc.teamcode.modules.intake

import com.andreidurlea.corecontrol.commandsFeature.InstantCommand
import com.andreidurlea.corecontrol.miscellaneous.cachingPower
import com.andreidurlea.corecontrol.miscellaneous.hardwareMapEverywhere
import com.andreidurlea.corecontrol.modulesFeature.Module
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import org.firstinspires.ftc.teamcode.HardwareNames

object IntakeRollers : Module(IntakeSensor) {
    lateinit var motor: DcMotor
    var isTurnedOn = false
    var isReversed = false
    const val POWER = 1.0

    override fun onInit() {
        motor = hardwareMapEverywhere.dcMotor.get(HardwareNames.intakeMotor)
        isReversed = false

        motor.direction = DcMotorSimple.Direction.REVERSE
        motor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
    }

    override fun onMainLoop() {
        if (isTurnedOn and IntakeSensor.seesArtifact) {
            if (isReversed) {
                motor.cachingPower = -POWER
            }
            else {
                motor.cachingPower = POWER
            }
        }
        else {
            motor.cachingPower = 0.0
        }
    }

    val turnOn = InstantCommand({ isTurnedOn = true })
    val turnOff = InstantCommand({ isTurnedOn = false })
    val reverse = InstantCommand({ isReversed = !isReversed })
}