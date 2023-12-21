package com.chrishadi.pokr

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    fun `yesNoToBoolean should return true given empty string or Y or y`() {
        assertTrue(yesNoToBoolean("")!!)
        assertTrue(yesNoToBoolean("Y")!!)
        assertTrue(yesNoToBoolean("y")!!)
    }

    @Test
    fun `yesNoToBoolean should return false given N or n`() {
        assertFalse(yesNoToBoolean("N")!!)
        assertFalse(yesNoToBoolean("n")!!)
    }

    @Test
    fun `yesNoToBoolean should return null given other inputs`() {
        assertNull(yesNoToBoolean("YES"))
        assertNull(yesNoToBoolean("no"))
    }

    @Test
    fun `play should return numOfPlayers players`() {
        val numOfPlayers = (MIN_NUM_OF_PLAYERS..MAX_NUM_OF_PLAYERS).random()
        val players = play(numOfPlayers)
        assertEquals(numOfPlayers, players.size)
    }

    @Test
    fun `play should return list of players with 1 winner`() {
        val numOfPlayers = (MIN_NUM_OF_PLAYERS..MAX_NUM_OF_PLAYERS).random()
        val players = play(numOfPlayers)
        assertEquals(1, players.count { it.isWin() })
    }

    @Test
    fun `createCards should create all ranks and suits`() {
        val expectedSize = Rank.entries.size * Suit.entries.size

        val cards = createCards()

        assertEquals(expectedSize, cards.size)

        for (rank in Rank.entries) {
            for (suit in Suit.entries) {
                assertTrue(cards.contains(Card(rank, suit)))
            }
        }
    }

    @Test
    fun `createPlayers should create between min and max number of players`() {
        val count = (MIN_NUM_OF_PLAYERS..MAX_NUM_OF_PLAYERS).random()
        assertEquals(count, createPlayers(count).size)
    }

    @Test
    fun `dealCards should distribute cards to players`() {
        val numOfPlayers = 10
        val cardsPerPlayers = 5
        val cards = createCards()
        val totalCardsCount = cards.size
        val players = createPlayers(numOfPlayers)

        dealCards(cards, players, cardsPerPlayers)

        players.forEach { assertEquals(cardsPerPlayers, it.cards.size) }
        assertEquals(totalCardsCount - cardsPerPlayers * numOfPlayers, cards.size)
    }

    @Test
    fun `detectHands should set players' hand`() {
        val numOfPlayers = 10
        val cardsPerPlayers = 5
        var cards = createCards()
        val players = createPlayers(numOfPlayers)

        cards = cards.shuffled().toMutableSet()
        dealCards(cards, players, cardsPerPlayers)
        detectHands(players)

        players.forEach { assertNotNull(it.hand) }
    }

    @Test
    fun `findWinner should return player with highest hand`() {
        val playersCards = setOf(
            setOf(
                Card(Rank.EIGHT, Suit.SPADE),
                Card(Rank.KING, Suit.DIAMOND),
                Card(Rank.THREE, Suit.SPADE),
                Card(Rank.FOUR, Suit.SPADE),
                Card(Rank.THREE, Suit.CLUB)
            ),
            setOf(
                Card(Rank.TWO, Suit.DIAMOND),
                Card(Rank.FIVE, Suit.DIAMOND),
                Card(Rank.THREE, Suit.HEART),
                Card(Rank.NINE, Suit.HEART),
                Card(Rank.JACK, Suit.SPADE)
            ),
            setOf(
                Card(Rank.JACK, Suit.HEART),
                Card(Rank.JACK, Suit.DIAMOND),
                Card(Rank.TEN, Suit.CLUB),
                Card(Rank.TWO, Suit.SPADE),
                Card(Rank.EIGHT, Suit.CLUB)
            ),
            setOf(
                Card(Rank.NINE, Suit.DIAMOND),
                Card(Rank.ACE, Suit.CLUB),
                Card(Rank.QUEEN, Suit.CLUB),
                Card(Rank.KING, Suit.SPADE),
                Card(Rank.FIVE, Suit.CLUB)
            ),
            setOf(
                Card(Rank.NINE, Suit.CLUB),
                Card(Rank.SIX, Suit.DIAMOND),
                Card(Rank.KING, Suit.CLUB),
                Card(Rank.TEN, Suit.DIAMOND),
                Card(Rank.SIX, Suit.CLUB)
            )
        )
        val players = createPlayers(playersCards.size)
        playersCards.forEachIndexed { index, cards ->
            for (card in cards) {
                players[index].receiveCard(card)
            }
        }

        detectHands(players)

        val winner = findWinner(players)

        assertEquals(players[2], winner)
    }
}