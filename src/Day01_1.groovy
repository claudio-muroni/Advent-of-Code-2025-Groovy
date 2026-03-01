static void main(String[] args) {
    def lines = new File("resources/Input_Day01_1.txt").readLines()

    def pw = 0
    def pos = 50
    for (line in lines) {
        def direction = line.substring(0,1)

        def clickNumber = line.substring(1)
        if (clickNumber.length() > 2) clickNumber = clickNumber.substring(clickNumber.length()-2)
        clickNumber = clickNumber.toInteger()

        pos = direction=="R" ? pos + clickNumber : pos - clickNumber

        if (pos > 99) pos -= 100
        else if (pos < 0) pos += 100

        //println(pos)

        if (pos == 0) pw++
    }

    println("Day 01 part 1 solution: " + pw)
}