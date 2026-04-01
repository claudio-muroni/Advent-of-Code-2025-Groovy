import groovyjarjarantlr4.v4.runtime.misc.Tuple2

static void main() {
    def lines = new ArrayList<char[]>()
    for (l in new File("resources/Input_Day04_1.txt").readLines()) {
        lines.add(l.toCharArray())
    }

    def removedRolls = 0

    def maxY = lines.size()-1
    def maxX = lines[0].length-1

    while (true) {

        def goodRolls = 0
        ArrayList<Tuple2<Integer, Integer>> rollsToRemoveList = []

        for (y in 0..maxY) {
            for (x in 0..maxX) {

                def pos = lines[y][x]
                if (pos == '@') {
                    def adjRolls = 0
                    for (py in -1..1) {
                        for (px in -1..1) {
                            if ((py != 0 || px != 0) && y + py >= 0 && x + px >= 0 && y + py <= maxY && x + px <= maxX) {
                                def adjPos = lines[y + py][x + px]
                                if (adjPos == '@') {
                                    adjRolls++
                                }
                            }
                        }
                    }

                    if (adjRolls < 4) {
                        goodRolls++
                        rollsToRemoveList.add(new Tuple2(y, x))
                    }
                }
            }
        }

        for (tup in rollsToRemoveList) {
            lines[tup.getItem1()][tup.getItem2()] = 'x'
        }

        removedRolls += goodRolls

        if (goodRolls == 0) break

    }

    println("Day 04 part 2 solution: "+removedRolls)

}



