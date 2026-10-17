package org.firstinspires.ftc.teamcode.modules.outtake

import com.andreidurlea.corecontrol.commandsFeature.CoreCommand
import com.andreidurlea.corecontrol.commandsFeature.instant
import com.andreidurlea.corecontrol.modulesFeature.Module

object OuttakeTurret : Module() {

    fun goToPosition(angle : Double) : CoreCommand {
        return instant({ })
    }
}