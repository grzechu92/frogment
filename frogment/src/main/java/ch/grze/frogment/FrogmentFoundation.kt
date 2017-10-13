package ch.grze.frogment

import android.app.Application
import ch.grze.frogment.core.Config
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.extension.AbstractExtension
import java.util.*

class FrogmentFoundation private constructor(builder: Builder) {
    private val core: Core

    constructor(application: Application) : this(Builder(application))

    init {
        core = Core(builder.application, builder.config, builder.extensions)
    }

    class Builder(val application: Application) {
        internal val extensions = ArrayList<AbstractExtension>()
        internal var config = Config.getDefault()

        fun extension(extension: AbstractExtension): Builder {
            extensions.add(extension)
            return this
        }

        fun config(config: Config): Builder {
            this.config = config
            return this
        }

        fun build(): FrogmentFoundation = FrogmentFoundation(this)
    }
}
