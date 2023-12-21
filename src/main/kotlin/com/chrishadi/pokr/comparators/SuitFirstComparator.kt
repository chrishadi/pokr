package com.chrishadi.pokr.comparators

import com.chrishadi.pokr.hands.Hand

object SuitFirstComparator : Comparator<Hand> {

    override fun compare(o1: Hand?, o2: Hand?): Int {
        if (o1 == null || o2 == null) throw NullPointerException()

        // This comparator is only used for Flush/StraightFlush hands,
        // therefore the best card is the last because they are sorted by rank.
        val o1Best = o1.cards.last()
        val o2Best = o2.cards.last()
        val comparedBySuit = o1Best.suit.ordinal - o2Best.suit.ordinal
        if (comparedBySuit != 0) return comparedBySuit

        return o1Best.rank.ordinal - o2Best.rank.ordinal
    }
}