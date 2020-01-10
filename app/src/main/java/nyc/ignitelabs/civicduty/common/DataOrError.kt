package nyc.ignitelabs.civicduty.common

import androidx.annotation.NonNull

interface DataOrError<out E, out D>{

    @NonNull
    fun data() : D

    @NonNull
    fun error() : E
}