package com.chrishadi.pokr

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class HandDetectorTest {

    @Test
    fun `detect should return RoyalFlush given Royal Flush cards`() {
        val cards = setOf(
            Card(Rank.TEN, Suit.HEART),
            Card(Rank.JACK, Suit.HEART),
            Card(Rank.QUEEN, Suit.HEART),
            Card(Rank.KING, Suit.HEART),
            Card(Rank.ACE, Suit.HEART)
        )

        assertEquals(HandRank.ROYAL_FLUSH, HandDetector.detect(cards).rank)
    }

    @Test
    fun `detect should return StraightFlush given Straight Flush cards`() {
        val cards = setOf(
            Card(Rank.EIGHT, Suit.CLUB),
            Card(Rank.NINE, Suit.CLUB),
            Card(Rank.TEN, Suit.CLUB),
            Card(Rank.JACK, Suit.CLUB),
            Card(Rank.QUEEN, Suit.CLUB)
        )

        assertEquals(HandRank.STRAIGHT_FLUSH, HandDetector.detect(cards).rank)
    }

    @Test
    fun `detect should return StraightFlush given Straight Flush with low Ace`() {
        val cards = setOf(
            Card(Rank.FOUR, Suit.SPADE),
            Card(Rank.TWO, Suit.SPADE),
            Card(Rank.FIVE, Suit.SPADE),
            Card(Rank.ACE, Suit.SPADE),
            Card(Rank.THREE, Suit.SPADE)
        )

        assertEquals(HandRank.STRAIGHT_FLUSH, HandDetector.detect(cards).rank)
    }

    @Test
    fun `detect should return FourOfAKind given Four Of A Kind cards`() {
        val cards = setOf(
            Card(Rank.FOUR, Suit.CLUB),
            Card(Rank.NINE, Suit.CLUB),
            Card(Rank.FOUR, Suit.HEART),
            Card(Rank.FOUR, Suit.SPADE),
            Card(Rank.FOUR, Suit.DIAMOND)
        )

        assertEquals(HandRank.FOUR_OF_A_KIND, HandDetector.detect(cards).rank)
    }


    @Test
    fun `detect should return FullHouse given Full House cards`() {
        val cards = setOf(
            Card(Rank.SEVEN, Suit.CLUB),
            Card(Rank.SEVEN, Suit.SPADE),
            Card(Rank.FIVE, Suit.HEART),
            Card(Rank.FIVE, Suit.SPADE),
            Card(Rank.FIVE, Suit.DIAMOND)
        )

        assertEquals(HandRank.FULL_HOUSE, HandDetector.detect(cards).rank)
    }
    @Test
    fun `detect should return Flush given Flush cards`() {
        val cards = setOf(
            Card(Rank.THREE, Suit.CLUB),
            Card(Rank.FIVE, Suit.CLUB),
            Card(Rank.EIGHT, Suit.CLUB),
            Card(Rank.JACK, Suit.CLUB),
            Card(Rank.ACE, Suit.CLUB)
        )

        assertEquals(HandRank.FLUSH, HandDetector.detect(cards).rank)
    }

    @Test
    fun `detect should return Straight given Straight cards`() {
        val cards = setOf(
            Card(Rank.THREE, Suit.DIAMOND),
            Card(Rank.FIVE, Suit.CLUB),
            Card(Rank.TWO, Suit.HEART),
            Card(Rank.SIX, Suit.SPADE),
            Card(Rank.FOUR, Suit.CLUB)
        )

        assertEquals(HandRank.STRAIGHT, HandDetector.detect(cards).rank)
    }

    @Test
    fun `detect should return Straight given Straight with low Ace`() {
        val cards = setOf(
            Card(Rank.THREE, Suit.DIAMOND),
            Card(Rank.FIVE, Suit.CLUB),
            Card(Rank.TWO, Suit.HEART),
            Card(Rank.ACE, Suit.SPADE),
            Card(Rank.FOUR, Suit.CLUB)
        )

        assertEquals(HandRank.STRAIGHT, HandDetector.detect(cards).rank)
    }

    @Test
    fun `detect should return ThreeOfAKind given Three Of A Kind cards`() {
        val cards = setOf(
            Card(Rank.THREE, Suit.SPADE),
            Card(Rank.THREE, Suit.HEART),
            Card(Rank.FIVE, Suit.CLUB),
            Card(Rank.JACK, Suit.SPADE),
            Card(Rank.THREE, Suit.CLUB)
        )

        assertEquals(HandRank.THREE_OF_A_KIND, HandDetector.detect(cards).rank)
    }

    @Test
    fun `detect should return TwoPair given Two Pair cards`() {
        val cards = setOf(
            Card(Rank.FOUR, Suit.DIAMOND),
            Card(Rank.FOUR, Suit.HEART),
            Card(Rank.FIVE, Suit.HEART),
            Card(Rank.TWO, Suit.CLUB),
            Card(Rank.TWO, Suit.HEART)
        )

        assertEquals(HandRank.TWO_PAIR, HandDetector.detect(cards).rank)
    }

    @Test
    fun `detect should return OnePair given One Pair cards`() {
        val cards = setOf(
            Card(Rank.JACK, Suit.HEART),
            Card(Rank.JACK, Suit.DIAMOND),
            Card(Rank.TEN, Suit.CLUB),
            Card(Rank.EIGHT, Suit.HEART),
            Card(Rank.KING, Suit.HEART)
        )

        assertEquals(HandRank.ONE_PAIR, HandDetector.detect(cards).rank)
    }

    @Test
    fun `detect should return OnePair given the pair is the highest rank`() {
        val cards = setOf(
            Card(Rank.JACK, Suit.HEART),
            Card(Rank.JACK, Suit.DIAMOND),
            Card(Rank.TEN, Suit.CLUB),
            Card(Rank.EIGHT, Suit.HEART),
            Card(Rank.SEVEN, Suit.HEART)
        )

        assertEquals(HandRank.ONE_PAIR, HandDetector.detect(cards).rank)
    }

    @Test
    fun `detect should return Nothing given Nothing cards`() {
        val cards = setOf(
            Card(Rank.THREE, Suit.CLUB),
            Card(Rank.FIVE, Suit.CLUB),
            Card(Rank.TEN, Suit.CLUB),
            Card(Rank.KING, Suit.CLUB),
            Card(Rank.ACE, Suit.DIAMOND)
        )

        assertEquals(HandRank.NOTHING, HandDetector.detect(cards).rank)
    }

    @Test
    fun `detect should return Nothing given low Ace without Two`() {
        val cards = setOf(
            Card(Rank.THREE, Suit.DIAMOND),
            Card(Rank.FIVE, Suit.CLUB),
            Card(Rank.SIX, Suit.HEART),
            Card(Rank.ACE, Suit.SPADE),
            Card(Rank.FOUR, Suit.CLUB)
        )

        assertEquals(HandRank.NOTHING, HandDetector.detect(cards).rank)
    }

}