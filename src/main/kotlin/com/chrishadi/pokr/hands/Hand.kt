package com.chrishadi.pokr.hands

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.HandRank

sealed class Hand(val cards: Set<Card>) : Comparable<Hand> {

    abstract val rank: HandRank
    abstract val comparator: Comparator<Hand>

    override fun compareTo(other: Hand): Int {
        val comparedByRank = this.rank.ordinal - other.rank.ordinal
        if (comparedByRank != 0) {
            return comparedByRank
        }
        return comparator.compare(this, other)
    }

    override fun toString(): String = "$rank $cards"
}