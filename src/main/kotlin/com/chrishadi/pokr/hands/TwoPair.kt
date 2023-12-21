package com.chrishadi.pokr.hands

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.HandRank
import com.chrishadi.pokr.comparators.RankFirstComparator

class TwoPair(cards: Set<Card>) : Hand(cards) {
    override val rank = HandRank.TWO_PAIR
    override val comparator = RankFirstComparator
}