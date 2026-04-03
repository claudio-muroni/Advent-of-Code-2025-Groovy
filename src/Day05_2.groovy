static void main() {

    def lines = new File("resources/Input_Day05_1.txt").readLines()

    def ranges = new ArrayList<Tuple2<BigInteger, BigInteger>>()
    for (l in lines.subList(0,lines.indexOf(""))) {
        def minR = l.split("-")[0].toBigInteger()
        def maxR = l.split("-")[1].toBigInteger()
        ranges.add(new Tuple2(minR, maxR))
    }

    def distRanges = new ArrayList<Tuple2<BigInteger, BigInteger>>()
    def numOvLap = 0

    while (true) {

        for (r in ranges) {
            def minR = r.getV1()
            def maxR = r.getV2()

            def ovLapFound = false
            for (int i = 0; i < distRanges.size(); i++) {
                def dr = distRanges[i]
                if (minR <= dr.getV2() && maxR >= dr.getV1()) {
                    minR = [minR, dr.getV1()].min()
                    maxR = [maxR, dr.getV2()].max()
                    distRanges[i] = new Tuple2(minR, maxR)
                    ovLapFound = true
                    numOvLap++
                    break
                }
            }

            if (!ovLapFound) {
                distRanges.add(new Tuple2(minR, maxR))
            }
        }

        if (numOvLap > 0) {
            numOvLap = 0
            ranges = distRanges
            distRanges = new ArrayList<Tuple2<BigInteger, BigInteger>>()
        } else {
            break
        }

    }

    BigInteger totFreshIdCount = 0
    for (dr in distRanges) {
        totFreshIdCount += (dr.getV2()-dr.getV1()+1)
    }

    println("Day 05 part 2 solution: "+totFreshIdCount)
}


