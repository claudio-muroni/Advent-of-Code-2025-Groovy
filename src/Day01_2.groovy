static void main(String[] args) {
    def lines = new File("resources/Input_Day01_1.txt").readLines()

    def pw = 0
    def pos = 50
    for (line in lines) {
        def direction = line.substring(0,1)

        def clickNumber = line.substring(1).toInteger()

        Integer round = clickNumber / 100
        //println("round: "+round)
        clickNumber = clickNumber % 100

        def newPos = direction=="R" ? pos + clickNumber : pos - clickNumber

        if (newPos > 99) newPos -= 100
        else if (newPos < 0) newPos += 100

        //println(newPos)

        pw += round
        if (newPos == 0) pw++
        else if (pos!=0 && ((newPos > pos && direction == "L") || (newPos < pos && direction == "R"))) pw++

        //println("pw: " + pw)

        pos = newPos
    }

    println("Day 01 part 2 solution: " + pw)
}