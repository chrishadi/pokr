package com.chrishadi.pokr

import com.chrishadi.pokr.hands.OnePair
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PlayerTest {
    lateinit var player: Player

    @BeforeEach
    fun setUp() {
        player = Player()
    }

    @Test
    fun `receiveCard should add player's cards`() {
        assertEquals(0, player.cards.size)

        player.receiveCard(Card(Rank.TWO, Suit.DIAMOND))
        assertEquals(1, player.cards.size)

        player.receiveCard(Card(Rank.FIVE, Suit.HEART))
        player.receiveCard(Card(Rank.TEN, Suit.CLUB))
        assertEquals(3, player.cards.size)
    }

    @Test
    fun `setHand should set player's hand`() {
        assertNull(player.hand)

        val cards = setOf(Card(Rank.TWO, Suit.HEART), Card(Rank.TWO, Suit.DIAMOND))
        val hand = OnePair(cards)
        player.setHand(hand)

        assertEquals(hand, player.hand)
    }
}