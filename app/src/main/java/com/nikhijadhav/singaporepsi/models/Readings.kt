package com.nikhijadhav.singaporepsi.models

data class Readings (
    private val o3SubIndex: O3SubIndex? = null,
    private val pm10TwentyFourHourly: Pm10TwentyFourHourly? = null,
    private val pm10SubIndex: Pm10SubIndex? = null,
    private val coSubIndex: CoSubIndex? = null,
    private val pm25TwentyFourHourly: Pm25TwentyFourHourly? = null,
    private val so2SubIndex: So2SubIndex? = null,
    private val coEightHourMax: CoEightHourMax? = null,
    private val no2OneHourMax: No2OneHourMax? = null,
    private val so2TwentyFourHourly: So2TwentyFourHourly? = null,
    private val pm25SubIndex: Pm25SubIndex? = null,
    private val psiTwentyFourHourly: PsiTwentyFourHourly? = null,
    private val o3EightHourMax: O3EightHourMax? = null){
}