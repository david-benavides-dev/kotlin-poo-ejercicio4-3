import classes.Persona

fun main() {

    // * Instancia de tres objetos de clase Persona (La primera sin nombre).
    val persona1 = Persona(10.0, 1.70)
    val persona2 = Persona(50.0, 1.60, "Manuel")
    val persona3 = Persona(65.0,1.20, "Pepe")


    // * Mostrar por pantalla la información de cada Persona.
    println("\n*********************************************")
    println(persona1)
    println("*********************************************\n")
    println(persona2)
    println("*********************************************\n")
    println(persona3)
    println("*********************************************\n")


    // * Cambio de nombre para persona1.
    cambiarNombre(persona1)
    println("\n*********************************************")
    println("Nombre: ${persona1.nombre}, Peso: ${persona1.peso}, Altura: ${persona1.altura}")


    // * Mostramos peso, altura y IMC de persona 3, además de modificar su altura a 1.80.
    println("\n*********************************************\n")
    println("Peso: ${persona3.peso}, Altura: ${persona3.altura}, IMC: ${persona3.imc}")
    persona3.altura = 1.80
    println("Peso: ${persona3.peso}, Altura: ${persona3.altura}, IMC: ${persona3.imc}")


    // * Modificamos altura de persona2 para que sea igual que la de persona3.
    persona2.altura = persona3.altura
    println("*********************************************\n")
    println(persona2)
    println("*********************************************\n")
    println(persona3)
    println("*********************************************\n")


    // * Se comprueba si son iguales
    println(persona2 == persona3)

    if (persona2.equals(persona3)) {
        println("Es igual.")
    } else {
        println("No es igual.")
    }


    // * Lista de personas.
    val listaPersonas: List<Persona> = listOf(
        Persona(10.0, 1.70, "MuertoEnVida"),
        Persona(75.0, 1.75, "Eduardo"),
        Persona(55.0,1.65, "Yasmina"),
        Persona(65.0,1.80, "Julio"),
    )


    // * Recorremos la lista de personas, mostrando su información y haciendo que saluden.
    for (persona in listaPersonas) {
        persona.saludar()
        persona.obtenerDesc()
    }
}

/**
 * Cambia el nombre de una persona.
 *
 * Solicita al usuario un nuevo nombre para la persona. El nombre no puede ser nulo,
 * estar vacío o ser igual al nombre actual. Si se proporciona un nombre válido,
 * se actualiza y se devuelve `true`. En caso contrario, se muestra un mensaje de error.
 *
 * @param persona La instancia de [Persona] cuyo nombre se desea cambiar.
 * @return `true` si el nombre se ha modificado correctamente.
 */
fun cambiarNombre(persona: Persona): Boolean {
    val nombreActual = persona.nombre.ifBlank { "(Sin nombre)" }
    do {
        println("Introduce el nombre para ${nombreActual}: ")
        val nombreNuevo = readln()

        if (nombreNuevo.isNotBlank() && nombreNuevo != persona.nombre) {
            persona.nombre = nombreNuevo.trim()
            println("Nombre modificado correctamente.")
            return true
        } else {
            println("El nombre no puede ser nulo, estar vacío o ser igual al anterior.")
        }
    } while (true)
}