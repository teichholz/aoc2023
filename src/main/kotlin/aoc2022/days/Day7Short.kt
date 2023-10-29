package aoc2022.days

import Day
import aoc2022.days.CommandParser.dir
import aoc2022.days.CommandParser.path
import com.github.h0tk3y.betterParse.combinators.oneOrMore
import com.github.h0tk3y.betterParse.combinators.or
import com.github.h0tk3y.betterParse.combinators.times
import com.github.h0tk3y.betterParse.combinators.unaryMinus
import com.github.h0tk3y.betterParse.combinators.use
import com.github.h0tk3y.betterParse.combinators.zeroOrMore
import com.github.h0tk3y.betterParse.grammar.Grammar
import com.github.h0tk3y.betterParse.grammar.parseToEnd
import com.github.h0tk3y.betterParse.grammar.parser
import com.github.h0tk3y.betterParse.lexer.literalToken
import com.github.h0tk3y.betterParse.lexer.regexToken
import com.github.h0tk3y.betterParse.parser.Parser
import readDay

fun main() {
    Day7S().solve()
}


class Day7S : Day<List<Command>> {
    override fun part1(input: List<Command>): Any {
        val dirs = HashMap<String, Int>()
        val history = ArrayDeque<String>()

        input.forEach {
            when (it) {
                is Command.Cd -> {
                    when (it.path) {
                        "/" -> {
                            history.clear()
                            history.addLast("/")
                        }
                        ".." -> {
                            history.removeLast()
                        }
                        else -> {
                            history.addLast(history.last() + "/" + it.path)
                        }
                    }
                }
                is Command.Ls -> {
                    it.output.forEach { out ->
                        if (out.size >= 0) {
                            history.forEach { dir ->
                                dirs[dir] = (dirs[dir] ?: 0) + out.size
                            }
                        }
                    }
                }
            }
        }

        println(dirs)

        return dirs.values.filter {
            it <= 100_000
        }.sum()
    }

    override fun part2(input: List<Command>): Any {
        return "TODO"
    }

    override fun parse(): List<Command> = readDay(2022, 7) {
        CommandParser.parseToEnd(readUtf8())
    }

}