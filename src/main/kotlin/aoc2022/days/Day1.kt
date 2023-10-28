package aoc2022.days

import Day
import readDay

fun main() {
    Day1().solve()
}

class Day1 : Day<List<List<Int>>> {

    override fun part1(input: List<List<Int>>): Int {
        val max = input.map {
            it.reduce(Int::plus)
        }.max()

        return max
    }

    override fun part2(input: List<List<Int>>): Int {
        val max = input.map {
            it.reduce(Int::plus)
        }.sortedDescending().take(3).sum()

        return max
    }

    override fun parse(): List<List<Int>> =
        readDay(2022, 1) {
            val allCalories = mutableListOf<List<Int>>()
            val calories = mutableListOf<Int>()

            while (true) {
                val line = readUtf8Line() ?: break
                if (line.isNotEmpty()) {
                    calories.add(Integer.valueOf(line))
                } else {
                    allCalories.add(calories.toList())
                    calories.clear()
                }
            }

            return@readDay allCalories
        }
}