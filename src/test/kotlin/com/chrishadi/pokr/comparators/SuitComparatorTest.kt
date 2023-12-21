package com.chrishadi.pokr.comparators

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.Rank
import com.chrishadi.pokr.Suit
import com.chrishadi.pokr.hands.Flush
import com.chrishadi.pokr.hands.RoyalFlush
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SuitComparatorTest {

    @Test
    fun `compare should return negative number given lower suit and higher suit hands`() {
        val o1Cards = setOf(
            Card(Rank.THREE, Suit.CLUB),
            Card(Rank.SEVEN, Suit.CLUB),
            Card(Rank.TEN, Suit.CLUB),
            Card(Rank.JACK, Suit.CLUB),
            Card(Rank.ACE, Suit.CLUB)
        )
        val o2Cards = setOf(
            Card(Rank.TWO, Suit.SPADE),
            Card(Rank.FOUR, Suit.SPADE),
            Card(Rank.FIVE, Suit.SPADE),
            Card(Rank.NINE, Suit.SPADE),
            Card(Rank.TEN, Suit.SPADE)
        )
        val o1Hand = Flush(o1Cards)
        val o2Hand = Flush(o2Cards)

        assertTrue(SuitComparator.compare(o1Hand, o2Hand) < 0)
    }

    @Test
    fun `compare should return 0 given same suit hands`() {
        val suit = Suit.entries.random()
        val o1Cards = setOf(
            Card(Rank.TWO, suit),
            Card(Rank.FOUR, suit),
            Card(Rank.FIVE, suit),
            Card(Rank.NINE, suit),
            Card(Rank.TEN, suit)
        )
        val o2Cards = setOf(
            Card(Rank.THREE, suit),
            Card(Rank.SEVEN, suit),
            Card(Rank.EIGHT, suit),
            Card(Rank.JACK, suit),
            Card(Rank.QUEEN, suit)
        )
        val o1Hand = Flush(o1Cards)
        val o2Hand = Flush(o2Cards)

        assertEquals(0, SuitComparator.compare(o1Hand, o2Hand))
    }

    @Test
    fun `compare should positive number given higher suit and lower suit hands`() {
        val o1Cards = setOf(
            Card(Rank.TEN, Suit.SPADE),
            Card(Rank.JACK, Suit.SPADE),
            Card(Rank.QUEEN, Suit.SPADE),
            Card(Rank.KING, Suit.SPADE),
            Card(Rank.ACE, Suit.SPADE)
        )
        val o2Cards = setOf(
            Card(Rank.TEN, Suit.DIAMOND),
            Card(Rank.JACK, Suit.DIAMOND),
            Card(Rank.QUEEN, Suit.DIAMOND),
            Card(Rank.KING, Suit.DIAMOND),
            Card(Rank.ACE, Suit.DIAMOND)
        )
        val o1Hand = RoyalFlush(o1Cards)
        val o2Hand = RoyalFlush(o2Cards)

        assertTrue(SuitComparator.compare(o1Hand, o2Hand) > 0)
    }
}