package com.example.exercise3.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class New(
    val name: String,
    val date: String,
    val index: String,
    val logo: Int,
    val notification: Boolean,
) : Parcelable
