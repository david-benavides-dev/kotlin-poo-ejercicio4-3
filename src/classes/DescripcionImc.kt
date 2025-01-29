package classes

/**
 * Enumera las descripciones del Índice de Masa Corporal (IMC).
 *
 * Esta enumeración proporciona las diferentes categorías de IMC que se pueden
 * utilizar para clasificar el estado de peso de una persona.
 *
 * @property descIMC La descripción asociada a cada categoría de IMC.
 */
enum class DescripcionImc(val descIMC: String) {
    INSUFICIENTE("peso insuficiente"),
    SALUDABLE("peso saludable"),
    SOBREPESO("sobrepeso"),
    OBESIDAD("obesidad")
}