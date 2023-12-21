package com.chrishadi.pokr.comparators

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.Rank
import com.chrishadi.pokr.Suit
import com.chrishadi.pokr.hands.Hand

object RankFirstComparator : Comparator<Hand> {

    override fun compare(o1: Hand?, o2: Hand?): Int {
        if (o1 == null || o2 == null) throw NullPointerException()

        val o1BestRank = o1.cards.last().rank
        val o2BestRank = o2.cards.last().rank
        val comparedByRank = o1BestRank.ordinal - o2BestRank.ordinal
        if (comparedByRank != 0) return comparedByRank

        val o1BestSuit = findBestSuitByRank(o1.cards, o2BestRank)
        val o2BestSuit = findBestSuitByRank(o2.cards, o2BestRank)
        return o1BestSuit.ordinal - o2BestSuit.ordinal
    }

    private fun findBestSuitByRank(cards: Set<Card>, rank: Rank): Suit {
        return cards.filter { it.rank == rank }.maxOf { it.suit }
    }
}