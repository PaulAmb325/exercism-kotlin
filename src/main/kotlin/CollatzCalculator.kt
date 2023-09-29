object CollatzCalculator {

    private var nbSteps: Int = 0

    fun computeStepCount(start: Int): Int {
        require(start > 0)
        resetSteps()
        collatzed(start)
        return nbSteps
    }

    private fun collatzed(number: Int): Int {
        if (number == 1) {
            return number
        }
        increaseStep()
         when (number % 2) {
            0 -> collatzed(number / 2)
            1 -> collatzed((3 * number) + 1)
        }
        return number
    }

    private fun increaseStep() {
        nbSteps++
    }

    private fun resetSteps() {
        nbSteps = 0
    }

}
