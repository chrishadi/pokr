package com.chrishadi.pokr

import com.chrishadi.pokr.hands.Hand

class Player {
    private val _cards = mutableSetOf<Card>()
    val cards: Set<Card> = _cards

    private var _hand: Hand? = null
    val hand: Hand?
        get() = _hand

    private var win: Boolean = false

    fun receiveCard(card: Card) {
        _cards.add(card)
    }

    fun setHand(hand: Hand) {
        _hand = hand
    }

    fun setWin() {
        win = true
    }

    fun isWin(): Boolean {
        return win
    }

    override fun toString(): String {
        return "\tCards: $cards\n\tHand: $hand"
    }
}