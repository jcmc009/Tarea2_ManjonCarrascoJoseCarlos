package dam.pmdm.tarea2_manjoncarrascojosecarlos

/**
 * Clase de datos que representa un personaje a mostrar en la aplicación.
 *
 * Contiene referencias a los recursos de imagen, nombre, descripción y habilidades
 * asociados a cada personaje Pikmin. Proporciona métodos auxiliares para obtener
 * los valores de estos recursos.
 *
 * @property imageResId Identificador del recurso de imagen asociado al personaje.
 * @property name Identificador del recurso de texto para el nombre del personaje.
 * @property description Identificador del recurso de texto para la descripción del personaje.
 * @property abilities Identificador del recurso de texto para las habilidades del personaje.
 */

data class CharacterToShow(
    val imageResId: Int,
    val name: Int,
    val description: Int,
    val abilities: Int
) {
    /**
     * Devuelve el recurso de imagen correspondiente al personaje según su nombre.
     *
     * @return El identificador del recurso drawable que representa al personaje.
     *         Si el nombre no coincide con ninguno de los definidos, devuelve
     *         una imagen por defecto.
     */
    fun getImage(): Int {
        return when (name) {

            R.string.pikmin_red -> R.drawable.pikmin_red
            R.string.pikmin_rock -> R.drawable.pikmin_rock
            R.string.pikmin_yellow -> R.drawable.pikmin_yellow
            R.string.pikmin_blue -> R.drawable.pikmin_blue
            R.string.pikmin_white -> R.drawable.pikmin_white
            R.string.pikmin_purple -> R.drawable.pikmin_purple
            R.string.pikmin_alado -> R.drawable.pikmin_alado
            R.string.pikmin_glow -> R.drawable.pikmin_glow
            R.string.pikmin_ice -> R.drawable.pikmin_ice
            else -> R.drawable.pikmin_default
        }

    }

    /**
     * Devuelve el nombre del personaje como cadena.
     *
     * @param name Nombre del personaje en formato String.
     * @return El nombre recibido como parámetro.
     */
    fun getName(name: String): String {
        return name
    }

    /**
     * Devuelve la descripción del personaje como cadena.
     *
     * @param description Descripción del personaje en formato String.
     * @return La descripción recibida como parámetro.
     */
    fun getDescription(description: String): String {
        return description
    }

    /**
     * Devuelve el color asociado al personaje como cadena.
     *
     * @param color Color del personaje en formato String.
     * @return El color recibido como parámetro.
     */
    fun getColor(color: String): String {
        return color
    }

    /**
     * Devuelve las habilidades del personaje como cadena.
     *
     * @param abilities Habilidades del personaje en formato String.
     * @return Las habilidades recibidas como parámetro.
     */
    fun getAbilities(abilities: String): String {
        return abilities
    }

    /**
     * Devuelve el identificador del recurso de imagen asociado al personaje.
     *
     * @param imageResId Identificador del recurso drawable.
     * @return El mismo identificador recibido como parámetro.
     */
    fun getImagResId(imageResId: Int): Int {
        return imageResId
    }

    /**
     * Objeto companion para posibles métodos estáticos o utilitarios relacionados
     * con la clase {@link CharacterToShow}.
     */
    companion object
}