package com.chrishadi.pokr.hands

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.HandRank
import com.chrishadi.pokr.comparators.RankComparator

class FourOfAKind(cards: Set<Card>) : Hand(cards) {
    override val rank = HandRank.FOUR_OF_A_KIND
    override val comparator = RankComparator
}