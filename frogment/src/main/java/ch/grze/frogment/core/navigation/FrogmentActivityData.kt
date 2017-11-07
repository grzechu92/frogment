package ch.grze.frogment.core.navigation

import android.os.Parcel
import android.os.Parcelable
import ch.grze.frogment.State
import ch.grze.frogment.activity.FrogmentActivityInterface

class FrogmentActivityData
@JvmOverloads constructor(
        val clazz: Class<out FrogmentActivityInterface>,
        val state: State? = null,
        val frogmentData: FrogmentData? = null
) : Parcelable {
    private constructor(builder: Builder) : this(builder.clazz, builder.state, builder.frogmentData)

    class Builder(val clazz: Class<out FrogmentActivityInterface>) {
        internal var state: State? = null
        internal var frogmentData: FrogmentData? = null

        fun state(state: State): Builder {
            this.state = state
            return this
        }

        fun frogmentData(frogmentData: FrogmentData): Builder {
            this.frogmentData = frogmentData
            return this
        }

        fun build(): FrogmentActivityData = FrogmentActivityData(this)
    }

    constructor(source: Parcel) : this(source.readSerializable() as Class<out FrogmentActivityInterface>, source.readParcelable<State>(State::class.java.classLoader), source.readParcelable<FrogmentData>(FrogmentData::class.java.classLoader))

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeSerializable(clazz)
        writeParcelable(state, 0)
        writeParcelable(frogmentData, 0)
    }

    companion object {
        @JvmStatic
        fun forClass(clazz: Class<out FrogmentActivityInterface>): FrogmentActivityData = FrogmentActivityData(clazz)

        @JvmField
        val CREATOR: Parcelable.Creator<FrogmentActivityData> = object : Parcelable.Creator<FrogmentActivityData> {
            override fun createFromParcel(source: Parcel): FrogmentActivityData = FrogmentActivityData(source)
            override fun newArray(size: Int): Array<FrogmentActivityData?> = arrayOfNulls(size)
        }
    }
}