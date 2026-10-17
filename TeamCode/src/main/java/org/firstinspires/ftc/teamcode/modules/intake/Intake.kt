package org.firstinspires.ftc.teamcode.modules.intake

import com.andreidurlea.corecontrol.commandsFeature.CoreCommand
import com.andreidurlea.corecontrol.commandsFeature.SequentialCommandGroup
import com.andreidurlea.corecontrol.commandsFeature.WaitCommand
import com.andreidurlea.corecontrol.commandsFeature.sequentially
import com.andreidurlea.corecontrol.commandsFeature.wait
import com.andreidurlea.corecontrol.modulesFeature.Module

object Intake : Module(IntakeArm, IntakeRollers) {

    val lowerArmAndTurnOn = SequentialCommandGroup(
        IntakeArm.goLower,
        IntakeRollers.turnOn
    )

    val raiseArmAndTurnOff = sequentially(
        IntakeRollers.turnOff,
        IntakeArm.goUpper
    )

    val collectFor2s = sequentially(
        lowerArmAndTurnOn,
        WaitCommand(2.0),
        raiseArmAndTurnOff
    )

    fun collect(seconds : Double) : CoreCommand {
        return SequentialCommandGroup(
            lowerArmAndTurnOn,
            wait(seconds),
            raiseArmAndTurnOff
        )
    }
}
