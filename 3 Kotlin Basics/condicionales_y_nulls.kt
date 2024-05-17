fun main() {
    val edad = 18
    if(edad >= 18){
        println("Eres mayor de edad con $edad anios")
    }

    //comparacion por un rango
    if(edad in 12..19){
        println("Estas en la adolescencia")
    }else{
        println("No eres un adolescente")
    }

    //nulleables -> se definen variables que puden contener valor nullo colocando ? delante del nombre
    val lugarDeTrabajo: String? = null
    println(lugarDeTrabajo)
   
    //operador ?
    var trabaja = lugarDeTrabajo ?: "No trabaja"
    println(trabaja)
    val lugarDeTrabajo2 : String? = "Mi casa"
    trabaja = lugarDeTrabajo2?.toString() ?: "No trabaja"
    println(trabaja)

}