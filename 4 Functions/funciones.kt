
import java.util.Random

fun main(args: Array<String>) {
    println("Hola Mundo! $args[0]")
    saludo()
}


fun saludo(){
    val dia = randomDay()
    val comida = food(dia)
    println("¿Hola que tal?, el plato de hoy $dia es $comida.")
    tamanioPlato()
    tamanioPlato("Grande")
}

fun randomDay() : String {
    val week = arrayOf ("Lunes", "Martes", "Miercoles", "Jueves",
            "Viernes", "Sabado", "Domingo")
    return week[Random().nextInt(week.size)]
}

fun food (day : String) : String {
    var food = ""
    when (day) {
        "Lunes" -> food = "Camaron"
        "Martes" -> food = "Tostadas"
        "Miercoles" -> food = "Res"
        "Jueves" -> food = "Pollo"
        "Viernes" -> food = "Spaguetti"
        "Sabado" -> food = "Ensalada"
        "Domingo" -> food = "Nacatamal"
    }
    return food
}

//Parametros con valor por defecto

fun tamanioPlato( tamanio: String = "Normal"){
    println("El tamanio de plato elegido es $tamanio")
}