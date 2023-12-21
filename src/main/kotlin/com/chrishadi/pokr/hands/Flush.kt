package com.chrishadi.pokr.hands

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.HandRank
import com.chrishadi.pokr.comparators.SuitFirstComparator

class Flush(cards: Set<Card>) : Hand(cards) {
    override val rank = HandRank.FLUSH
    override val comparator = SuitFirstComparator
}