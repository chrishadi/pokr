package com.chrishadi.pokr

const val CARDS_PER_PLAYER = 5
const val NUM_OF_PLAYER_PROMPT = "Number of player: "
const val INTEGER_PLEASE_MESSAGE = "Please input an integer."
const val MIN_NUM_OF_PLAYERS = 1
const val MAX_NUM_OF_PLAYERS = 10
const val INVALID_NUM_OF_PLAYERS_MESSAGE = "Number of players should be between $MIN_NUM_OF_PLAYERS and $MAX_NUM_OF_PLAYERS"
const val PLAY_AGAIN_PROMPT = "Play again? [Y/n] "
const val WINNER_LABEL = "\t*** WINNER ***"

fun main() {
    do {
        val numOfPlayers = promptInt(NUM_OF_PLAYER_PROMPT)
        if (numOfPlayers !in MIN_NUM_OF_PLAYERS..MAX_NUM_OF_PLAYERS) {
            println(INVALID_NUM_OF_PLAYERS_MESSAGE)
            continue
        }

        val players = play(numOfPlayers)
        printResult(players)
    } while (promptYesNo(PLAY_AGAIN_PROMPT))
}

fun prompt(msg: String): String {
    print(msg)
    return readlnOrNull() ?: ""
}

fun promptInt(msg: String): Int {
    var result: Int? = null

    while (result == null) {
        try {
            result = prompt(msg).toInt()
        } catch (ex: NumberFormatException) {
            println(INTEGER_PLEASE_MESSAGE)
        }
    }

    return result
}

fun promptYesNo(msg: String): Boolean {
    var result: Boolean? = null

    while (result == null) {
        val input = prompt(msg)
        result = yesNoToBoolean(input)
    }

    return result
}

fun yesNoToBoolean(input: String): Boolean? {
    if (input.isEmpty() || input.lowercase() == "y") {
        return true
    }
    if (input.lowercase() == "n") {
        return false
    }
    return null
}

fun play(numOfPlayers: Int): List<Player> {
    var cards = createCards()
    val players = createPlayers(numOfPlayers)

    cards = cards.shuffled().toMutableSet()

    dealCards(cards, players, CARDS_PER_PLAYER)
    detectHands(players)
    val winner = findWinner(players)
    winner.setWin()

    return players
}

fun createCards(): MutableSet<Card> {
    val deck = mutableSetOf<Card>()

    for (suit in Suit.entries) {
        for (rank in Rank.entries) {
            deck.add(Card(rank, suit))
        }
    }

    return deck
}

fun createPlayers(count: Int): List<Player> {
    return (1..count).map { Player() }
}

fun dealCards(
    cards: MutableSet<Card>, players: List<Player>, cardsPerPlayer: Int
) {
    repeat(cardsPerPlayer) {
        players.forEach {
            val top = cards.last()
            cards.remove(top)
            it.receiveCard(top)
        }
    }
}

fun detectHands(players: List<Player>) {
    players.forEach {
        val hand = HandDetector.detect(it.cards)
        it.setHand(hand)
    }
}

fun findWinner(players: List<Player>): Player {
    val bestHand = players.maxOf { it.hand!! }
    return players.find { it.hand == bestHand }!!
}

fun printResult(players: List<Player>) {
    players.forEachIndexed { index, player ->
        println(if (index == 0) "You:" else "Player ${index + 1}:")
        println(player)
        if (player.isWin()) println(WINNER_LABEL)
        println()
    }
}