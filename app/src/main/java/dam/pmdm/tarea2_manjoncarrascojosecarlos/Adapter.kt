package dam.pmdm.tarea2_manjoncarrascojosecarlos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.pmdm.tarea2_manjoncarrascojosecarlos.databinding.CharacterItemBinding

/**
 * Adapter para gestionar y mostrar una lista de personajes en un RecyclerView.
 *
 * Este adaptador recibe una lista de objetos {@link CharacterToShow} y una función
 * de callback que se ejecuta al hacer clic sobre un elemento de la lista.
 *
 * @property characterList Lista de personajes que se mostrarán en el RecyclerView.
 * @property onClick Función lambda que se ejecuta al pulsar sobre un personaje.
 */
class Adapter(
    private val characterList: List<CharacterToShow>,
    private val onClick: (CharacterToShow) -> Unit
) : RecyclerView.Adapter<Adapter.MyViewHolder>() {
    /**
     * Crea un nuevo ViewHolder cuando el RecyclerView lo necesita.
     *
     * @param parent El ViewGroup padre en el que se añadirá la vista.
     * @param viewType Tipo de vista (no usado en este caso).
     * @return Un objeto {@link MyViewHolder} que contiene la vista inflada.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    /**
     * Asocia los datos de un personaje con el ViewHolder correspondiente.
     *
     * @param holder El ViewHolder que se actualizará con los datos.
     * @param position La posición del elemento dentro de la lista.
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bin(characterList[position])
    }

    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return El tamaño de la lista de personajes.
     */
    override fun getItemCount(): Int {
        return characterList.size
    }

    /**
     * Clase interna que representa el ViewHolder para cada elemento del RecyclerView.
     *
     * Se encarga de vincular los datos de un objeto {@link CharacterToShow}
     * con las vistas definidas en el layout {@link CharacterItemBinding}.
     *
     * @property binding Objeto de enlace que contiene las vistas del item.
     */
    //View holder class
    inner class MyViewHolder(private val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        /**
         * Vincula los datos de un personaje con las vistas del layout.
         *
         * @param character El objeto {@link CharacterToShow} cuyos datos se mostrarán.
         */
        fun bin(character: CharacterToShow) {
            // binding.characterName.text = character.name
            binding.characterName.setText(character.name)
            binding.characterImage.setImageResource(character.getImage())
            binding.root.setOnClickListener {
                onClick(character)
            }
        }


    }
}