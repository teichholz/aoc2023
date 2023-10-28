package aoc2022.days

import Day
import readDay

fun Char.priority(): Int {
    return when (this) {
        in 'a'..'z' -> this - 'a' + 1
        in 'A'..'Z' -> this - 'A' + 27
        else -> throw Exception("Unknown char $this")
    }
}

fun main() {
    val day = Day3()
    day.solve()
}

class Day3 : Day<List<String>> {

    override fun part1(input: List<String>): Any {
        return input.sumOf { it ->
            val firstHalf = it.substring(0, it.length / 2)
            val secondHalf = it.substring(it.length / 2, it.length)

            val firstHalfSet = firstHalf.toSet()
            val secondHalfSet = secondHalf.toSet()
            val intersection = firstHalfSet.intersect(secondHalfSet)

            intersection.sumOf { it.priority() }
        }
    }

    override fun part2(input: List<String>): Any {
        val groups = input.chunked(3)

        return groups.sumOf {
            it.map {
                it.toSet()
            }.reduce(Set<Char>::intersect).sumOf { it.priority() }
        }
    }

    override fun parse(): List<String> {
        return readDay(2022, 3) {
            val lines = mutableListOf<String>()
            while (true) {
                val line = readUtf8Line() ?: break
                lines.add(line)
            }
            return@readDay lines
        }
    }

}