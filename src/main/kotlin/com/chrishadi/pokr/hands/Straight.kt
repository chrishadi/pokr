package com.chrishadi.pokr.hands

import com.chrishadi.pokr.Card
import com.chrishadi.pokr.HandRank
import com.chrishadi.pokr.comparators.RankFirstComparator

class Straight(cards: Set<Card>) : Hand(cards) {
    override val rank = HandRank.STRAIGHT
    override val comparator = RankFirstComparator
}