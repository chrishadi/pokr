package com.chrishadi.pokr.hands

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.HandRank
import com.chrishadi.pokr.comparators.SuitFirstComparator

class StraightFlush(cards: Set<Card>) : Hand(cards) {
    override val rank = HandRank.STRAIGHT_FLUSH
    override val comparator = SuitFirstComparator
}