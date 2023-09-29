import kotlin.math.*

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0)

fun ComplexNumber.abs(): Double {
    return sqrt(real*real + imag*imag)
}

fun ComplexNumber.conjugate(): ComplexNumber {
    return ComplexNumber(this.real, this.imag * -1)
}

operator fun ComplexNumber.plus(complexNumber: ComplexNumber): ComplexNumber {
    return ComplexNumber(this.real + complexNumber.real, this.imag + complexNumber.imag)
}

operator fun ComplexNumber.minus(complexNumber: ComplexNumber): ComplexNumber {
    return ComplexNumber(this.real - complexNumber.real, this.imag - complexNumber.imag)
}

operator fun ComplexNumber.times(complexNumber: ComplexNumber): ComplexNumber {
    //(a + i * b) * (c + i * d) = (a * c - b * d) + (b * c + a * d) * i
    val real = (this.real * complexNumber.real) - (this.imag * complexNumber.imag)
    val imag = (this.imag * complexNumber.imag) + (this.real * complexNumber.real)
    return ComplexNumber(real, imag)
}

operator fun ComplexNumber.div(complexNumber: ComplexNumber): ComplexNumber {
    //(a + i * b) / (c + i * d) = (a * c + b * d)/(c^2 + d^2) + (b * c - a * d)/(c^2 + d^2) * i
    return ComplexNumber(real = (((this.real * complexNumber.real) + (this.imag * complexNumber.imag)) / (complexNumber.real.pow(2) + complexNumber.imag.pow(2))),
        imag = ((this.imag * complexNumber.real) - (this.real * complexNumber.imag)/ (complexNumber.real.pow(2) + complexNumber.imag.pow(2))))
}

fun exponential(complexNumber: ComplexNumber) : ComplexNumber {
    //e^(a + i * b) = e^a * e^(i * b),
    //the last term of which is given by Euler's formula e^(i * b) = cos(b) + i * sin(b)
    val real: Double = E.pow(complexNumber.real) * E.pow(complexNumber.imag)
    val imag: Double = (cos(complexNumber.imag) * sin(complexNumber.imag))
    return ComplexNumber(real, imag)
}
