package com.chrishadi.pokr.comparators

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.Rank
import com.chrishadi.pokr.Suit
import com.chrishadi.pokr.hands.Flush
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SuitFirstComparatorTest {

    @Test
    fun `compare should return negative number given lower suit and higher suit hands`() {
        val o1Cards = setOf(
            Card(Rank.THREE, Suit.HEART),
            Card(Rank.SEVEN, Suit.HEART),
            Card(Rank.TEN, Suit.HEART),
            Card(Rank.JACK, Suit.HEART),
            Card(Rank.ACE, Suit.HEART)
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

        assertTrue(SuitFirstComparator.compare(o1Hand, o2Hand) < 0)
    }

    @Test
    fun `compare should return negative number given same suit with lower rank and higher rank hands`() {
        val o1Cards = setOf(
            Card(Rank.THREE, Suit.HEART),
            Card(Rank.SEVEN, Suit.HEART),
            Card(Rank.EIGHT, Suit.HEART),
            Card(Rank.TEN, Suit.HEART),
            Card(Rank.JACK, Suit.HEART)
        )
        val o2Cards = setOf(
            Card(Rank.TWO, Suit.HEART),
            Card(Rank.FOUR, Suit.HEART),
            Card(Rank.FIVE, Suit.HEART),
            Card(Rank.NINE, Suit.HEART),
            Card(Rank.ACE, Suit.HEART)
        )
        val o1Hand = Flush(o1Cards)
        val o2Hand = Flush(o2Cards)

        assertTrue(SuitFirstComparator.compare(o1Hand, o2Hand) < 0)
    }

    @Test
    fun `compare should return positive number given higher suit and lower suit hands`() {
        val o1Cards = setOf(
            Card(Rank.TWO, Suit.SPADE),
            Card(Rank.FOUR, Suit.SPADE),
            Card(Rank.FIVE, Suit.SPADE),
            Card(Rank.NINE, Suit.SPADE),
            Card(Rank.TEN, Suit.SPADE)
        )
        val o2Cards = setOf(
            Card(Rank.THREE, Suit.CLUB),
            Card(Rank.SEVEN, Suit.CLUB),
            Card(Rank.TEN, Suit.CLUB),
            Card(Rank.JACK, Suit.CLUB),
            Card(Rank.ACE, Suit.CLUB)
        )
        val o1Hand = Flush(o1Cards)
        val o2Hand = Flush(o2Cards)

        assertTrue(SuitFirstComparator.compare(o1Hand, o2Hand) > 0)
    }

    @Test
    fun `compare should return positive number given same suit with higher rank and lower rank hands`() {
        val o1Cards = setOf(
            Card(Rank.TWO, Suit.HEART),
            Card(Rank.FOUR, Suit.HEART),
            Card(Rank.FIVE, Suit.HEART),
            Card(Rank.NINE, Suit.HEART),
            Card(Rank.QUEEN, Suit.HEART)
        )
        val o2Cards = setOf(
            Card(Rank.THREE, Suit.HEART),
            Card(Rank.SEVEN, Suit.HEART),
            Card(Rank.EIGHT, Suit.HEART),
            Card(Rank.TEN, Suit.HEART),
            Card(Rank.JACK, Suit.HEART)
        )
        val o1Hand = Flush(o1Cards)
        val o2Hand = Flush(o2Cards)

        assertTrue(SuitFirstComparator.compare(o1Hand, o2Hand) > 0)
    }
}