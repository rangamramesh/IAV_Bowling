package com.iav.bowling.data

data class Frame(
        val score: Int?,
        val scoreType: ScoreType,
        val throws: List<Throw>
)