package com.chrishadi.pokr.comparators

import com.chrishadi.pokr.hands.FullHouse
import com.chrishadi.pokr.hands.Hand
import java.io.InvalidClassException

object FullHouseComparator : Comparator<Hand> {

    override fun compare(o1: Hand?, o2: Hand?): Int {
        if (o1 == null || o2 == null) throw NullPointerException()

        if (o1 !is FullHouse || o2 !is FullHouse) {
            throw InvalidClassException("should be called with FullHouse only")
        }

        val o1ThreeCards = o1.threeOfAKind.cards
        val o2ThreeCards = o2.threeOfAKind.cards
        val o1BestSuit = o1ThreeCards.maxOf { it.suit }
        val o2BestSuit = o2ThreeCards.maxOf { it.suit }

        val comparedBySuit = o1BestSuit.ordinal - o2BestSuit.ordinal
        if (comparedBySuit != 0) return comparedBySuit

        return o1ThreeCards.first().rank.ordinal - o2ThreeCards.first().rank.ordinal
    }
}