import okio.BufferedSource
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.buffer

fun <T> readDay(year: Int, day: Int, block: BufferedSource.() -> T): T {
    val home = System.getenv("HOME").toPath()
    val path = home.resolve("git/aoc/input/$year/$day".toPath())

    FileSystem.SYSTEM.source(path).use { fileSource ->
        fileSource.buffer().use { bufferedFileSource ->
            return block(bufferedFileSource)
        }
    }
}

interface Day<T> {
    fun part1(input: T): Any
    fun part2(input: T): Any
    fun parse(): T

    fun solve () {
        println("Part 1:\n${part1(parse())}")
        println("Part 2:\n${part2(parse())}")
    }
}