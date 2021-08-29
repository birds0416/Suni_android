package com.birds.suni3.ui.schedule

import org.json.JSONArray

class CoursesData(
    val major: String,
    val name: String,
    val title: String,
    val type: String,
    val credit: Int,
    val days: JSONArray,
    val startTime: String,
    val endTime: String,
    val room: String,
    val instructor: String,
    val hasLab: Boolean,
    val link: String
)