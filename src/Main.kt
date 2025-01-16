import classes.Persona
import java.util.*


fun pedirNombre(msj: String): String {
    var nombre: String = readln()
    do {
        println(msj)
        nombre = readln()
    } while (nombre.isBlank())

    return nombre
}


fun main() {

    val persona1 = Persona(10.0, 1.70)
    val persona2 = Persona(50.0, 1.60, "Manuel")
    val persona3 = Persona(65.0,1.20, "Pepe")
    val persona4 = Persona(65.0,1.20, "Julio")

    print(persona4.obtenerDesc())

}