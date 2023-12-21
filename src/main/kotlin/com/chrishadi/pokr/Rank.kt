package com.chrishadi.pokr

enum class Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

    companion object {
        fun royals() = setOf(TEN, JACK, QUEEN, KING, ACE)
    }
}