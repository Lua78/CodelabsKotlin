fun main() {
    var  frutas = listOf("limon", "manzana", "mandarina") //lista no alterable
    println(frutas)

    frutas = mutableListOf("limon", "manzana", "mandarina") //lista alterable
    frutas.remove("limon")
    println(frutas)

    //combinacion de arrays
    val numbers = intArrayOf(1,2,3)
    val numbers3 = intArrayOf(4,5,6)
    val foo2 = numbers3 + numbers
    for(i in foo2){
        println(i)
    }
    
}