package com.chrishadi.pokr.hands

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.HandRank
import com.chrishadi.pokr.comparators.SuitComparator

class RoyalFlush(cards: Set<Card>) : Hand(cards) {
    override val rank = HandRank.ROYAL_FLUSH
    override val comparator = SuitComparator
}