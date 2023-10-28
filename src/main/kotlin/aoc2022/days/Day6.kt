package aoc2022.days

import Day
import readDay

fun main() {
    Day6().solve()
}

class Day6 : Day<String> {
    override fun part1(input: String): Any {
        val windows = input.windowed(4)
        val marker = windows.first {
            it.toSet().size == 4
        }
        val index = windows.indexOf(marker)
        return index + 4
    }

    override fun part2(input: String): Any {
        val windows = input.windowed(14)
        val marker = windows.first {
            it.toSet().size == 14
        }
        val index = windows.indexOf(marker)
        return index + 14
    }

    override fun parse(): String {
        return readDay(2022, 6) {
            return@readDay readUtf8()
        }
    }

}