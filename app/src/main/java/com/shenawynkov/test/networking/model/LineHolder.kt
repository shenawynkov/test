package com.shenawynkov.test.networking.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LineHolder (val  lines:ArrayList<LineResponse>):Parcelable