package dam.pmdm.tarea2_manjoncarrascojosecarlos

data class CharacterToShow(
    val imageResId: Int,
    val name: Int,
    val description: Int,
    val abilities: Int
) {
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
            else -> R.drawable.pikmin_default // Imagen por defecto
        }

    }


    fun getName(name: String): String {
        return name
    }

    fun getDescription(description: String): String {
        return description
    }

    fun getColor(color: String): String {
        return color
    }

    fun getAbilities(abilities: String): String {
        return abilities
    }

    fun getImagResId(imageResId: Int): Int {
        return imageResId

    }

    companion object
}