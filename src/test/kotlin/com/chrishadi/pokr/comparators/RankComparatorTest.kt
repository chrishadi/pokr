package com.chrishadi.pokr.comparators

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.Rank
import com.chrishadi.pokr.Suit
import com.chrishadi.pokr.hands.FourOfAKind
import com.chrishadi.pokr.hands.Nothing
import com.chrishadi.pokr.hands.ThreeOfAKind
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class RankComparatorTest {

    @Test
    fun `compare should return negative number given lower rank and higher rank hands`() {
        val o1Cards = setOf(
            Card(Rank.THREE, Suit.HEART),
            Card(Rank.THREE, Suit.CLUB),
            Card(Rank.THREE, Suit.DIAMOND)
        )
        val o2Cards = setOf(
            Card(Rank.SEVEN, Suit.CLUB),
            Card(Rank.SEVEN, Suit.DIAMOND),
            Card(Rank.SEVEN, Suit.SPADE)
        )
        val o1Hand = ThreeOfAKind(o1Cards)
        val o2Hand = ThreeOfAKind(o2Cards)

        assertTrue(RankComparator.compare(o1Hand, o2Hand) < 0)
    }

    @Test
    fun `compare should return 0 given same rank hands`() {
        val o1Cards = setOf(
            Card(Rank.TWO, Suit.CLUB),
            Card(Rank.FOUR, Suit.HEART),
            Card(Rank.FIVE, Suit.SPADE),
            Card(Rank.SEVEN, Suit.DIAMOND),
            Card(Rank.TEN, Suit.SPADE)
        )
        val o2Cards = setOf(
            Card(Rank.THREE, Suit.SPADE),
            Card(Rank.SEVEN, Suit.DIAMOND),
            Card(Rank.EIGHT, Suit.CLUB),
            Card(Rank.NINE, Suit.HEART),
            Card(Rank.TEN, Suit.DIAMOND)
        )
        val o1Hand = Nothing(o1Cards)
        val o2Hand = Nothing(o2Cards)

        assertEquals(0, RankComparator.compare(o1Hand, o2Hand))
    }

    @Test
    fun `compare should return positive number given higher rank and lower rank hands`() {
        val o1Cards = setOf(
            Card(Rank.JACK, Suit.CLUB),
            Card(Rank.JACK, Suit.CLUB),
            Card(Rank.JACK, Suit.CLUB),
            Card(Rank.JACK, Suit.CLUB)
        )
        val o2Cards = setOf(
            Card(Rank.FOUR, Suit.DIAMOND),
            Card(Rank.FOUR, Suit.DIAMOND),
            Card(Rank.FOUR, Suit.DIAMOND),
            Card(Rank.FOUR, Suit.DIAMOND)
        )
        val o1Hand = FourOfAKind(o1Cards)
        val o2Hand = FourOfAKind(o2Cards)

        assertTrue(RankComparator.compare(o1Hand, o2Hand) > 0)
    }
}