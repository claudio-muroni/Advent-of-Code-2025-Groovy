static void main() {
    def batteryBanks = new File("resources/Input_Day03_1.txt").readLines()

    BigInteger totJoltage = 0

    for (batteryBank in batteryBanks) {

        def firstNumPos = -1
        def joltage = ""

        for (num in 9..1) {
            firstNumPos = batteryBank.indexOf(num.toString())
            if (firstNumPos >= 0 && firstNumPos<batteryBank.length()-11) {
                joltage = num.toString()
                break
            }
        }

        for (d in 10..0) {
            for (num in 9..1) {
                def secondNumPos = batteryBank.indexOf(num.toString(), firstNumPos+1)
                if (secondNumPos > firstNumPos && secondNumPos<batteryBank.length()-d) {
                    joltage += num.toString()
                    firstNumPos = secondNumPos
                    break
                }
            }
        }

        totJoltage += joltage.toBigInteger()
    }

    println("Day 03 part 2 solution: "+totJoltage)
}


