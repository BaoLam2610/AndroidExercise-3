package com.example.exercise3.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Neo(
    val name: String?,
    val index: Int? = null,
    val address: String?,
) : Parcelable
