static void main() {
    def batteryBanks = new File("resources/Input_Day03_1.txt").readLines()

    BigInteger totJoltage = 0

    for (batteryBank in batteryBanks) {

        def firstNumPos = -1
        def secondNumPos = -1
        def firstNum = ""
        def secondNum = ""

        for (num in 9..1) {
            firstNumPos = batteryBank.indexOf(num.toString())
            if (firstNumPos >= 0 && firstNumPos<batteryBank.length()-1) {
                firstNum = num.toString()
                break
            }
        }

        for (num in 9..1) {
            secondNumPos = batteryBank.indexOf(num.toString(), firstNumPos+1)
            if (secondNumPos > firstNumPos) {
                secondNum = num.toString()
                break
            }
        }

        def joltage = (firstNum+secondNum).toInteger()
        totJoltage += joltage
    }

    println("Day 03 part 1 solution: "+totJoltage)
}

