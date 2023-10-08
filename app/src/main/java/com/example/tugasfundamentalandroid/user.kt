package com.example.tugasfundamentalandroid

import android.os.Parcelable
import android.provider.ContactsContract.CommonDataKinds.Email
import kotlinx.parcelize.Parcelize

@Parcelize
data class user(
    val email: String,
    val password: String
):Parcelable
