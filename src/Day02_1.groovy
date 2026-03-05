static void main() {
    def line = new File("resources/Input_Day02_1.txt").readLines()[0]
    def rangesList = line.split(',')

    BigInteger invId = 0

    for (range in rangesList) {
        def start = range.split('-')[0].toBigInteger()
        def end = range.split('-')[1].toBigInteger()

        for (num in start..end) {
            def numStr = num.toString()
            if (numStr.length()%2==0) {
                if ( numStr.substring(0, (numStr.length()/2).toInteger()) == numStr.substring((numStr.length()/2).toInteger()) ) {
                    invId+=numStr.toBigInteger()
                }
            }
        }
    }

    println("Day 02 part 1 solution: "+invId)
}
