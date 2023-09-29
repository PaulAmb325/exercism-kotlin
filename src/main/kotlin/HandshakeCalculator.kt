object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        val signals: MutableList<Signal> = mutableListOf<Signal>()

        val binary = "00000${number.toString(2)}"

        if (binary[binary.length - 1] == '1') signals.add(Signal.WINK)
        if (binary[binary.length - 2] == '1') signals.add(Signal.DOUBLE_BLINK)
        if (binary[binary.length - 3] == '1') signals.add(Signal.CLOSE_YOUR_EYES)
        if (binary[binary.length - 4] == '1') signals.add(Signal.JUMP)
        if (binary[binary.length - 5] == '1') signals.reverse()

        return signals;

    }
}

enum class Signal() {
    WINK,
    JUMP,
    DOUBLE_BLINK,
    CLOSE_YOUR_EYES,
}
