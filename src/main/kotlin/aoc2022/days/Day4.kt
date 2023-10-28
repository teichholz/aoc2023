package days

import Day
import readDay

fun main() {
    Day4().solve()
}

fun IntRange.contains(other: IntRange): Boolean {
    return this.contains(other.first) && this.contains(other.last)
}

fun IntRange.overlaps(other: IntRange): Boolean {
    return this.contains(other.first) || this.contains(other.last)
}

class Day4 : Day<List<Pair<IntRange, IntRange>>> {

    override fun part1(input: List<Pair<IntRange, IntRange>>): Any {
        return input.count { (f, s) -> f.contains(s) || s.contains(f) }
    }

    override fun part2(input: List<Pair<IntRange, IntRange>>): Any {
        return input.count { (f, s) -> f.overlaps(s) || s.overlaps(f) }
    }

    override fun parse(): List<Pair<IntRange, IntRange>> {
        return readDay(2022, 4) {
            val pairs = mutableListOf<Pair<IntRange, IntRange>>()

            while (true) {
                val line = readUtf8Line() ?: break
                val (first, second) = line.split(",")
                val (fStart, fEnd) = first.split("-")
                val (sStart, sEnd) = second.split("-")
                pairs.add(Pair(fStart.toInt()..fEnd.toInt(), sStart.toInt()..sEnd.toInt()))
            }

            return@readDay pairs
        }
    }

}