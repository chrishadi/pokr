package com.chrishadi.pokr.comparators

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.Rank
import com.chrishadi.pokr.Suit
import com.chrishadi.pokr.hands.FullHouse
import com.chrishadi.pokr.hands.OnePair
import com.chrishadi.pokr.hands.ThreeOfAKind
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class FullHouseComparatorTest {

    private fun createFullHouse(threeCards: Set<Card>, pairCards: Set<Card>): FullHouse {
        val threeOfAKind = ThreeOfAKind(threeCards)
        val pair = OnePair(pairCards)
        return FullHouse(threeOfAKind, pair)
    }

    @Test
    fun `compare should return negative number given lower suit and higher suit hands`() {
        val o1ThreeCards = setOf(
            Card(Rank.TEN, Suit.DIAMOND), Card(Rank.TEN, Suit.HEART), Card(Rank.TEN, Suit.CLUB)
        )
        val o1PairCards = setOf(
            Card(Rank.ACE, Suit.HEART), Card(Rank.ACE, Suit.SPADE)
        )
        val o2ThreeCards = setOf(
            Card(Rank.KING, Suit.CLUB), Card(Rank.KING, Suit.SPADE), Card(Rank.KING, Suit.DIAMOND)
        )
        val o2PairCards = setOf(
            Card(Rank.TWO, Suit.SPADE), Card(Rank.TWO, Suit.CLUB)
        )
        val o1Hand = createFullHouse(o1ThreeCards, o1PairCards)
        val o2Hand = createFullHouse(o2ThreeCards, o2PairCards)

        assertTrue(FullHouseComparator.compare(o1Hand, o2Hand) < 0)
    }

    @Test
    fun `compare should return negative number given same suit with lower rank and higher rank hands`() {
        val o1ThreeCards = setOf(
            Card(Rank.TEN, Suit.DIAMOND), Card(Rank.TEN, Suit.SPADE), Card(Rank.TEN, Suit.CLUB)
        )
        val o1PairCards = setOf(
            Card(Rank.ACE, Suit.HEART), Card(Rank.ACE, Suit.SPADE)
        )
        val o2ThreeCards = setOf(
            Card(Rank.KING, Suit.SPADE), Card(Rank.KING, Suit.CLUB), Card(Rank.KING, Suit.HEART)
        )
        val o2PairCards = setOf(
            Card(Rank.TWO, Suit.SPADE), Card(Rank.TWO, Suit.CLUB)
        )
        val o1Hand = createFullHouse(o1ThreeCards, o1PairCards)
        val o2Hand = createFullHouse(o2ThreeCards, o2PairCards)

        assertTrue(FullHouseComparator.compare(o1Hand, o2Hand) < 0)
    }

    @Test
    fun `compare should return positive number given higher suit and lower suit hands`() {
        val o1ThreeCards = setOf(
            Card(Rank.KING, Suit.CLUB), Card(Rank.KING, Suit.SPADE), Card(Rank.KING, Suit.DIAMOND)
        )
        val o1PairCards = setOf(
            Card(Rank.ACE, Suit.HEART), Card(Rank.ACE, Suit.SPADE)
        )
        val o2ThreeCards = setOf(
            Card(Rank.TEN, Suit.DIAMOND), Card(Rank.TEN, Suit.HEART), Card(Rank.TEN, Suit.CLUB)
        )
        val o2PairCards = setOf(
            Card(Rank.TWO, Suit.SPADE), Card(Rank.TWO, Suit.CLUB)
        )
        val o1Hand = createFullHouse(o1ThreeCards, o1PairCards)
        val o2Hand = createFullHouse(o2ThreeCards, o2PairCards)

        assertTrue(FullHouseComparator.compare(o1Hand, o2Hand) > 0)
    }

    @Test
    fun `compare should return positive number given same suit with higher rank and lower rank hands`() {
        val o1ThreeCards = setOf(
            Card(Rank.KING, Suit.SPADE), Card(Rank.KING, Suit.CLUB), Card(Rank.KING, Suit.HEART)
        )
        val o1PairCards = setOf(
            Card(Rank.ACE, Suit.HEART), Card(Rank.ACE, Suit.SPADE)
        )
        val o2ThreeCards = setOf(
            Card(Rank.TEN, Suit.DIAMOND), Card(Rank.TEN, Suit.SPADE), Card(Rank.TEN, Suit.CLUB)
        )
        val o2PairCards = setOf(
            Card(Rank.TWO, Suit.SPADE), Card(Rank.TWO, Suit.CLUB)
        )
        val o1Hand = createFullHouse(o1ThreeCards, o1PairCards)
        val o2Hand = createFullHouse(o2ThreeCards, o2PairCards)

        assertTrue(FullHouseComparator.compare(o1Hand, o2Hand) > 0)
    }
}