package com.example.stcchallenge.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Senator(
    val caucus: Any? = null,

    @SerializedName("congress_numbers")
    val congressNumbers: List<Long>? = null,

    val current: Boolean? = null,
    val description: String? = null,
    val district: Any? = null,
    val enddate: String? = null,
    val extra: Extra? = null,

    @SerializedName("leadership_title")
    val leadershipTitle: Any? = null,

    val party: PartyType? = null,
    val person: Person? = null,
    val phone: String? = null,

    @SerializedName("role_type")
    val roleType: String? = null,

    @SerializedName("role_type_label")
    val roleTypeLabel: String? = null,

    @SerializedName("senator_class")
    val senatorClass: String? = null,

    @SerializedName("senator_class_label")
    val senatorClassLabel: String? = null,

    @SerializedName("senator_rank")
    val senatorRank: String? = null,

    @SerializedName("senator_rank_label")
    val senatorRankLabel: String? = null,

    val startdate: String? = null,
    val state: String? = null,
    val title: String? = null,

    @SerializedName("title_long")
    val titleLong: String? = null,

    val website: String? = null
) : Serializable {

    fun getSenatorName(): String = "${person?.firstname} ${person?.lastname}"

    enum class PartyType {
        Democrat, Republican
    }

    data class Extra (
        val address: String? = null,
        @SerializedName("contact_form")
        val contactForm: String? = null,
        val fax: String? = null,
        val office: String? = null,
        @SerializedName("rss_url")
        val rssURL: String? = null
    )

    data class Person (
        val bioguideid: String? = null,
        val birthday: String? = null,
        val cspanid: Long? = null,
        val firstname: String? = null,
        val gender: String? = null,

        @SerializedName("gender_label")
        val genderLabel: String? = null,
        val lastname: String? = null,
        val link: String? = null,
        val middlename: String? = null,
        val name: String? = null,
        val namemod: String? = null,
        val nickname: String? = null,
        val osid: String? = null,
        val pvsid: String? = null,
        val sortname: String? = null,
        val twitterid: String? = null,
        val youtubeid: String? = null
    )

}