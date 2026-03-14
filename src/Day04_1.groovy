static void main() {
    def lines = new File("resources/Input_Day04_1.txt").readLines()

    def goodRolls = 0

    def maxY = lines.size()-1
    def maxX = lines[0].length()-1

    for (y in 0..maxY) {
        for (x in 0..maxX) {

            def pos = lines[y][x]
            if (pos == "@") {
                def adjRolls = 0
                for (py in -1..1) {
                    for (px in -1..1) {
                        if ( (py != 0 || px !=0) && y+py>=0 && x+px>=0 && y+py<=maxY && x+px<=maxX) {
                            def adjPos = lines[y+py][x+px]
                            if (adjPos == "@") {
                                adjRolls++
                            }
                        }
                    }
                }

                if (adjRolls<4) goodRolls++
            }
        }
    }

    println("Day 04 part 1 solution: "+goodRolls)

}


