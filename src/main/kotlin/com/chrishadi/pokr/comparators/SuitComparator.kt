package com.chrishadi.pokr.comparators

import com.chrishadi.pokr.hands.Hand

object SuitComparator : Comparator<Hand> {

    override fun compare(o1: Hand?, o2: Hand?): Int {
        if (o1 == null || o2 == null) throw NullPointerException()
        return o1.cards.last().suit.ordinal - o2.cards.last().suit.ordinal
    }
}