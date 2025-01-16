package classes

// Constructor primario.
class Persona(var peso: Double, var altura: Double) {


    // Constructor secundario.
    var nombre = "NONAME"
    constructor(peso: Double, altura: Double, nombre: String) : this(peso, altura) {
        this.nombre = nombre
    }

    // Funcion que retorna si altura por encima de la media
    fun alturaEncimaMedia():Boolean = altura >= 1.75

    // Función que retorna si peso por encima de la media
    fun pesoEncimaMedia():Boolean = peso >= 70

    // Función que calcula IMC.
    fun calcularImc(): Double = peso / (altura * altura)

    // Función para saludar.
    fun saludar(): String = "$nombre te saluda."

    // toString para mostrar la información de la persona en cuestión.
    override fun toString(): String {
        return "nombre: $nombre, peso: $peso, altura: $altura, imc: ${"%.2f".format(calcularImc())}"
    }

    //
    fun obtenerDescImc(): String{
        when {
            calcularImc() > 18.5 -> return descripcionImc.INSUFICIENTE.descIMC
            calcularImc() in 18.5..24.9 -> return descripcionImc.SALUDABLE.descIMC
            calcularImc() in 25.0..29.9 -> return descripcionImc.SOBREPESO.descIMC
            calcularImc() > 30.0 -> return descripcionImc.OBESIDAD.descIMC
        }
        return ""
    }

    // "Julia con una altura de 1.72m (Por debajo de la media) y un peso 64.7kg (Por encima de la media) tiene un IMC de 21,87 (peso saludable)".
    fun obtenerDesc(): String {
        return "$nombre con una altura de ${altura}m (Por ${if(alturaEncimaMedia()) "encima" else "debajo"} de la media) y un peso de ${peso}kg (Por ${if(pesoEncimaMedia()) "encima" else "debajo"} de la media) tiene un IMC de ${"%.2f".format(calcularImc())} (${obtenerDescImc()})"
    }

    // Equals para verificar si dos objetos son iguales o no.
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false

        return this.peso == other.peso && this.altura == other.altura
    }
}