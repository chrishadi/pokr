package com.chrishadi.pokr.hands

import com.chrishadi.pokr.HandRank
import com.chrishadi.pokr.comparators.FullHouseComparator

class FullHouse(val threeOfAKind: ThreeOfAKind, pair: OnePair) : Hand(threeOfAKind.cards + pair.cards) {
    override val rank = HandRank.FULL_HOUSE
    override val comparator = FullHouseComparator
}