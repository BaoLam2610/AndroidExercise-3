package com.example.exercise3.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val email: String, var password: String) : Parcelable
