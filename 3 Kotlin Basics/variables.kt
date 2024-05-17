 fun main() {
    //operadores comunes

    println(1+1)
    println(5+8)
    println(7*6)
    println(8/3)
    println()
    //funciones de numero

    println(2.plus(25))
    println(2.times(2))
    println(6.div(3))
    println(9.minus(2))
    println()
    //casteo de numeros -> variable.toTipoDeDato

    val b1:Byte = 1
    val numero:Int = b1.toInt()
    println(numero) 
    println()

    //string e  interpolacion de variables en ellos -> se usa el simbolo $ antes del nombre de la variable 
    //para interpolarla dentro del string

    val n1 = 25
    val n2 = 23
    println("Tengo un numero n1: $n1 y un numero n2: $n2")
    println("La suma de n1 y n2 es ${n1 + n2}")
    println()
}