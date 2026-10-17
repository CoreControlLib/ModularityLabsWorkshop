package org.firstinspires.ftc.teamcode.modules.intake

import com.andreidurlea.corecontrol.miscellaneous.hardwareMapEverywhere
import com.andreidurlea.corecontrol.modulesFeature.Module
import com.qualcomm.hardware.rev.RevColorSensorV3
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit
import org.firstinspires.ftc.teamcode.HardwareNames

object IntakeSensor : Module() {
    const val DISTANCE_TO_ARTIFACT = 2.0

    lateinit var sensor : RevColorSensorV3
    var seesArtifact = false

    override fun onInit() {
        sensor = hardwareMapEverywhere.get(
            RevColorSensorV3::class.java, HardwareNames.intakeSensor
        )
    }

    override fun onLoop() {
        val distance = sensor.getDistance(DistanceUnit.CM)
        seesArtifact = if (distance >= DISTANCE_TO_ARTIFACT) true else false
    }
}