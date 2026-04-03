static void main() {

    def lines = new File("resources/Input_Day05_1.txt").readLines()

    def ranges = lines.subList(0,lines.indexOf(""))
    def ids = lines.subList(lines.indexOf("")+1,lines.size())

    def freshIdCount = 0

    for (id in ids) {

        def idN = id.toBigInteger()

        for (r in ranges) {

            def minR = r.split("-")[0].toBigInteger()
            def maxR = r.split("-")[1].toBigInteger()

            if (idN >= minR && idN <= maxR) {
                freshIdCount++
                break
            }

        }

    }

    println("Day 05 part 1 solution: "+freshIdCount)
}

