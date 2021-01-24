package com.example.stcchallenge.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Senator(
    val bioguide: String? = null,
    val party: PartyType? = null,
    val name: String? = null,
    @SerializedName("name_slug")
    val nameSlug: String? = null,
    @SerializedName("first_name")
    val firstName: String? = null,
    @SerializedName("last_name")
    val lastName: String? = null,
    val gender: String? = null,
    @SerializedName("date_of_birth")
    val dateOfBirth: String? = null,
    @SerializedName("entered_office")
    val enteredOffice: String? = null,
    @SerializedName("term_end")
    val termEnd: String? = null,
    @SerializedName("address_complete")
    val addressComplete: String = "",
    val website: String? = null
) : Serializable {

    fun getSenatorName(): String = "$firstName $lastName"

    enum class PartyType {
        democrat, republican
    }

    data class ExtraInformation(
        val address: String? = null,
        val office: String? = null
    )

    data class Person(
        val name: String? = null,
        @SerializedName("date_of_birth")
        val dateOfBirth: String? = null,
        val gender: String? = null,
        val sortName: String? = null
        )

}