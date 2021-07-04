package com.shenawynkov.test.networking.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class LineResponse(
    val calories: Int,
    val totalWeight: Double,
    var quantity: String="",
    var unit: String="",
    var food: String="",

):Parcelable