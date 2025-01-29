package classes

/**
 * Representa a una persona con los atributos peso, altura y nombre.
 *
 * Esta clase permite calcular el Índice de Masa Corporal (IMC) de la persona
 * y proporciona métodos para comparar instancias de `Persona`.
 *
 * @property peso El peso de la persona en kilogramos.
 * @property altura La altura de la persona en metros.
 * @property nombre El nombre de la persona. Inicialmente es una cadena vacía.
 */
class Persona(var peso: Double, var altura: Double) {

    val imc: Double
        get() = calcularImc()

    var nombre = ""
    constructor(peso: Double, altura: Double, nombre: String) : this(peso, altura) {
        this.nombre = nombre
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC).
     *
     * @return El IMC calculado como un valor de tipo [Double].
     */
    private fun calcularImc(): Double = peso / (altura * altura)

    /**
     * Determina si la altura de la persona está por encima de la media.
     *
     * Se considera que la altura media es de 1.75 metros.
     *
     * @return `true` si la altura es mayor o igual a 1.75, `false` en caso contrario.
     */
    fun alturaEncimaMedia():Boolean = altura >= 1.75

    /**
     * Determina si el peso de la persona está por encima de la media.
     *
     * Se considera que el peso medio es de 70 kilogramos.
     *
     * @return `true` si el peso es mayor o igual a 70, `false` en caso contrario.
     */
    fun pesoEncimaMedia():Boolean = peso >= 70

    /**
     * Genera un saludo personalizado.
     *
     * @return Un saludo que incluye el nombre de la persona.
     */
    fun saludar() = println("$nombre te saluda.")

    /**
     * Devuelve una representación en forma de cadena de la persona.
     *
     * @return Una cadena que incluye el nombre, peso, altura e IMC de la persona.
     */
    override fun toString(): String {
        return "Nombre: $nombre, Peso: $peso, Altura: $altura, IMC: ${"%.2f".format(imc)}"
    }

    /**
     * Compara esta instancia de `Persona` con otra.
     *
     * Dos instancias de `Persona` son consideradas iguales si tienen el mismo peso y altura.
     *
     * @param other El otro objeto a comparar.
     * @return `true` si las instancias son iguales, `false` en caso contrario.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false

        return this.peso == other.peso && this.altura == other.altura
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    /**
     * Obtiene una descripción del IMC de la persona.
     *
     * Devuelve una cadena que describe la categoría del IMC según los valores
     * establecidos: insuficiente, saludable, sobrepeso u obesidad.
     *
     * @return Una descripción del IMC.
     */
    fun obtenerDescImc(): String{
        when {
            calcularImc() > 18.5 -> return DescripcionImc.INSUFICIENTE.descIMC
            calcularImc() in 18.5..24.9 -> return DescripcionImc.SALUDABLE.descIMC
            calcularImc() in 25.0..29.9 -> return DescripcionImc.SOBREPESO.descIMC
            calcularImc() > 30.0 -> return DescripcionImc.OBESIDAD.descIMC
        }
        return ""
    }

    /**
     * Genera una descripción completa de la persona, incluyendo su altura,
     * peso, IMC y comparaciones con la media.
     *
     * @return Una cadena que describe a la persona y su estado de salud.
     */
    fun obtenerDesc(){
        println("$nombre con una altura de ${altura}m (Por ${if(alturaEncimaMedia()) "encima" else "debajo"} de la media) y un peso de ${peso}kg (Por ${if(pesoEncimaMedia()) "encima" else "debajo"} de la media) tiene un IMC de $${"%.2f".format(imc)} (${obtenerDescImc()})")
    }
}