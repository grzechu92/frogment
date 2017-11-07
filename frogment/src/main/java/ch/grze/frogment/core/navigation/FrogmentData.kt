package ch.grze.frogment.core.navigation

import android.os.Parcel
import android.os.Parcelable
import ch.grze.frogment.State
import ch.grze.frogment.frogment.FrogmentInterface

class FrogmentData
@JvmOverloads constructor(
        val clazz: Class<out FrogmentInterface>,
        val state: State? = null,
        val tag: String? = clazz.canonicalName
) : Parcelable {
    private constructor (builder: Builder) : this(builder.clazz, builder.state, builder.tag)

    class Builder(val clazz: Class<out FrogmentInterface>) {
        internal var state: State? = null
        internal var tag: String = clazz.canonicalName

        fun state(state: State): Builder {
            this.state = state
            return this
        }

        fun tag(tag: String): Builder {
            this.tag = tag
            return this
        }

        fun build(): FrogmentData = FrogmentData(this)
    }

    constructor(source: Parcel) : this(source.readSerializable() as Class<out FrogmentInterface>, source.readParcelable<State>(State::class.java.classLoader), source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeSerializable(clazz)
        writeParcelable(state, 0)
        writeString(tag)
    }

    companion object {
        @JvmStatic
        fun forClass(clazz: Class<out FrogmentInterface>): FrogmentData = FrogmentData(clazz)

        @JvmField
        val CREATOR: Parcelable.Creator<FrogmentData> = object : Parcelable.Creator<FrogmentData> {
            override fun createFromParcel(source: Parcel): FrogmentData = FrogmentData(source)
            override fun newArray(size: Int): Array<FrogmentData?> = arrayOfNulls(size)
        }
    }
}