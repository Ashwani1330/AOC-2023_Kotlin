fun main() {
    fun calibrationValue(row: String): Int {
        val firstDigit = row.first { it.isDigit() }
        val lastDigit = row.last { it.isDigit() }
        return "$firstDigit$lastDigit".toInt()
    }

    fun part1(input: List<String>): Int {
        var sum = 0
        for (j in input) {
            sum += calibrationValue(j)
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val list1 = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var ans = 0

        for (i in input) {
            var first = 0
            var last = 0

            for (j in 0..<i.length) {
                var cur = 0

                if (i[j].isDigit()) {
                    cur = i[j].digitToInt()
                }

                list1.forEachIndexed {index, num ->
                    if (j <= i.length - num.length) {
                        if (i.subSequence(j, (j+num.length)) == num) {
                            cur = index + 1
                            return@forEachIndexed
                        }
                    }
                }

                if (cur > 0)
                {
                    if (first == 0)
                        first = cur
                    last = cur
                }
            }
            ans += first * 10 + last
        }
        return ans
    }




    // test if implementation meets criteria from the description, like:
    // val testInput = readInput("Day01_test")
    // check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}