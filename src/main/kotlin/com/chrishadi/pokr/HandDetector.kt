package com.chrishadi.pokr

import com.chrishadi.pokr.hands.*
import com.chrishadi.pokr.hands.Nothing

object HandDetector {
    fun detect(cards: Set<Card>): Hand {
        // This method only works for cards of 5

        // sort and convert to list because we'll be using index a lot
        val sortedCards = cards.sortedBy { it.rank.ordinal }.toList()
        if (isStraight(sortedCards)) {
            if (isFlush(sortedCards)) {
                if (cards.map { it.rank }.containsAll(Rank.royals())) {
                    return RoyalFlush(sortedCards.toSet())
                }
                return StraightFlush(sortedCards.toSet())
            }
            return Straight(sortedCards.toSet())
        }

        if (isFlush(sortedCards)) {
            return Flush(sortedCards.toSet())
        }

        val sameRankCards = mutableSetOf(sortedCards.first())
        val pairs = mutableSetOf<Set<Card>>()
        var threeOfAKind: ThreeOfAKind? = null
        for (i in 1 until sortedCards.size) {
            val card = sortedCards[i]
            var setOfAKind = emptySet<Card>()
            if (card.rank != sameRankCards.last().rank) {
                if (sameRankCards.size > 1) {
                    // copy the cards, don't use sameRankCards to create the hand, or we'll get in trouble
                    setOfAKind = sameRankCards.toSet()
                }

                sameRankCards.clear()
            }

            sameRankCards.add(card)

            if (i == sortedCards.lastIndex && sameRankCards.size > 1) {
                setOfAKind = sameRankCards.toSet()
            }

            when (setOfAKind.size) {
                2 -> pairs.add(setOfAKind)
                3 -> threeOfAKind = ThreeOfAKind(setOfAKind)
                4 -> return FourOfAKind(setOfAKind)
            }
        }

        when (pairs.size) {
            1 -> {
                val onePair = OnePair(pairs.elementAt(0))
                return if (threeOfAKind != null) {
                    FullHouse(threeOfAKind, onePair)
                } else {
                    onePair
                }
            }

            2 -> return TwoPair(pairs.flatten().toSet())
        }

        if (threeOfAKind != null) {
            return threeOfAKind
        }

        return Nothing(sortedCards.toSet())
    }

    private fun isStraight(cards: List<Card>): Boolean {
        if (cards.size < 5) {
            return false
        }

        for (i in 1 until 5) {
            val rank = cards[i].rank
            val prevRank = cards[i-1].rank
            if (rank.ordinal != prevRank.ordinal + 1) {
                // do we have [ACE, 2, 3, 4, 5]?
                return i > 3 && rank == Rank.ACE && cards.first().rank == Rank.TWO
            }
        }

        return true
    }

    private fun isFlush(cards: List<Card>): Boolean {
        if (cards.size < 5) {
            return false
        }

        val suit = cards.first().suit
        return cards.all { it.suit == suit }
    }
}