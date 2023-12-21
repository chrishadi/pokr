package com.chrishadi.pokr.comparators

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.Rank
import com.chrishadi.pokr.Suit
import com.chrishadi.pokr.hands.Nothing
import com.chrishadi.pokr.hands.OnePair
import com.chrishadi.pokr.hands.Straight
import com.chrishadi.pokr.hands.TwoPair
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class RankFirstComparatorTest {

    @Test
    fun `compare should return negative number given lower rank and higher rank hands`() {
        val o1Cards = setOf(
            Card(Rank.FIVE, Suit.CLUB),
            Card(Rank.FIVE, Suit.DIAMOND)
        )
        val o2Cards = setOf(
            Card(Rank.JACK, Suit.HEART),
            Card(Rank.JACK, Suit.SPADE)
        )
        val o1Hand = OnePair(o1Cards)
        val o2Hand = OnePair(o2Cards)

        assertTrue(RankFirstComparator.compare(o1Hand, o2Hand) < 0)
    }

    @Test
    fun `compare should return negative number given same rank with lower suit and higher suit hands`() {
        val o1Cards = setOf(
            Card(Rank.SIX, Suit.DIAMOND),
            Card(Rank.SEVEN, Suit.HEART),
            Card(Rank.EIGHT, Suit.SPADE),
            Card(Rank.NINE, Suit.CLUB),
            Card(Rank.TEN, Suit.DIAMOND)
        )
        val o2Cards = setOf(
            Card(Rank.SIX, Suit.CLUB),
            Card(Rank.SEVEN, Suit.SPADE),
            Card(Rank.EIGHT, Suit.DIAMOND),
            Card(Rank.NINE, Suit.HEART),
            Card(Rank.TEN, Suit.SPADE)
        )
        val o1Hand = Straight(o1Cards)
        val o2Hand = Straight(o2Cards)

        assertTrue(RankFirstComparator.compare(o1Hand, o2Hand) < 0)
    }

    @Test
    fun `compare should return positive number given higher rank and lower rank hands`() {
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

        assertTrue(RankFirstComparator.compare(o1Hand, o2Hand) > 0)
    }

    @Test
    fun `compare should return negative number given same rank with higher suit and lower suit hands`() {
        val o1Cards = setOf(
            Card(Rank.SEVEN, Suit.HEART),
            Card(Rank.SEVEN, Suit.DIAMOND),
            Card(Rank.KING, Suit.SPADE),
            Card(Rank.KING, Suit.CLUB)
        )
        val o2Cards = setOf(
            Card(Rank.FIVE, Suit.DIAMOND),
            Card(Rank.FIVE, Suit.HEART),
            Card(Rank.KING, Suit.DIAMOND),
            Card(Rank.KING, Suit.HEART)
        )
        val o1Hand = TwoPair(o1Cards)
        val o2Hand = TwoPair(o2Cards)

        assertTrue(RankFirstComparator.compare(o1Hand, o2Hand) > 0)
    }
}