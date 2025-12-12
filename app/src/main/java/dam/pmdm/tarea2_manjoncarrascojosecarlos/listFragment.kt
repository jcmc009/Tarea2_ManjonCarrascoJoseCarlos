package dam.pmdm.tarea2_manjoncarrascojosecarlos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dam.pmdm.tarea2_manjoncarrascojosecarlos.databinding.FragmentListBinding

/**
 * Fragmento encargado de mostrar la lista de personajes en un RecyclerView.
 *
 * Este fragmento utiliza un {@link RecyclerView} con un {@link GridLayoutManager}
 * para mostrar los personajes en una cuadrícula de dos columnas. Al seleccionar
 * un personaje, se navega al {@link DetailsFragment} mostrando sus detalles.
 */
class listFragment : Fragment() {

    /** Enlace al layout del fragmento mediante ViewBinding. */
    private lateinit var binding: FragmentListBinding

    /**
     * Infla el layout asociado al fragmento y crea el objeto de binding.
     *
     * @param inflater Objeto utilizado para inflar el layout XML.
     * @param container Contenedor padre en el que se insertará la vista.
     * @param savedInstanceState Estado guardado de la instancia, si existe.
     * @return La vista raíz del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Configura la vista del fragmento una vez creada.
     *
     * Inicializa el RecyclerView con un {@link GridLayoutManager} de dos columnas,
     * asigna el adaptador con la lista de personajes y define la acción al seleccionar
     * un personaje: mostrar un Toast y navegar al fragmento de detalles con los datos
     * del personaje seleccionado.
     *
     * @param view La vista raíz del fragmento.
     * @param savedInstanceState Estado guardado de la instancia, si existe.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = Adapter(getListaPersonajes()) { selectedCharacter ->
            Toast.makeText(
                requireContext(),
                "character=${selectedCharacter.name}",
                Toast.LENGTH_SHORT
            )
            val bundle = Bundle()
            bundle.putString("name", getString(selectedCharacter.name))
            bundle.putString("description", getString(selectedCharacter.description))
            bundle.putInt("image", selectedCharacter.getImage())
            bundle.putString("abilities", getString(selectedCharacter.abilities))

            findNavController().navigate(R.id.detailsFragment, bundle)
        }
    }

    /**
     * Método llamado al crear el fragmento.
     *
     * Permite al fragmento modificar el menú de la Toolbar mediante
     * la llamada a {@link #setHasOptionsMenu}.
     *
     * @param savedInstanceState Estado guardado de la instancia, si existe.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    /**
     * Construye y devuelve una lista de personajes Pikmin.
     *
     * Cada personaje se define con su imagen, nombre, descripción y habilidades,
     * referenciados mediante recursos. El {@link Adapter} se encargará de traducir
     * estos identificadores en texto e imagen para mostrarlos en la interfaz.
     *
     * @return Una lista de objetos {@link CharacterToShow} que representan los personajes.
     */
    private fun getListaPersonajes(): List<CharacterToShow> {
        val lista = ArrayList<CharacterToShow>()

        lista.add(
            CharacterToShow(
                R.drawable.pikmin_red,
                R.string.pikmin_red,
                R.string.pikmin_red_description,
                R.string.pikmin_red_abilities
            )
        )
        lista.add(
            CharacterToShow(
                R.drawable.pikmin_alado,
                R.string.pikmin_alado,
                R.string.pikmin_alado_description,
                R.string.pikmin_alado_abilities
            )
        )
        lista.add(
            CharacterToShow(
                R.drawable.pikmin_blue,
                R.string.pikmin_blue,
                R.string.pikmin_blue_description,
                R.string.pikmin_blue_abilities
            )
        )
        lista.add(
            CharacterToShow(
                R.drawable.pikmin_glow,
                R.string.pikmin_glow,
                R.string.pikmin_glow_description,
                R.string.pikmin_glow_abilities
            )
        )
        lista.add(
            CharacterToShow(
                R.drawable.pikmin_ice,
                R.string.pikmin_ice,
                R.string.pikmin_ice_description,
                R.string.pikmin_ice_abilities
            )
        )
        lista.add(
            CharacterToShow(
                R.drawable.pikmin_purple,
                R.string.pikmin_purple,
                R.string.pikmin_purple_description,
                R.string.pikmin_purple_abilities
            )
        )
        lista.add(
            CharacterToShow(
                R.drawable.pikmin_rock,
                R.string.pikmin_rock,
                R.string.pikmin_rock_description,
                R.string.pikmin_rock_abilities
            )
        )
        lista.add(
            CharacterToShow(
                R.drawable.pikmin_white,
                R.string.pikmin_white,
                R.string.pikmin_white_description,
                R.string.pikmin_white_abilities
            )
        )
        lista.add(
            CharacterToShow(
                R.drawable.pikmin_yellow,
                R.string.pikmin_yellow,
                R.string.pikmin_yellow_description,
                R.string.pikmin_yellow_abilities
            )
        )

        return lista
    }
}

/**
 * Función de extensión vacía para la clase Companion de {@link CharacterToShow}.
 *
 * Actualmente no implementa ninguna lógica, pero puede ser utilizada en el futuro
 * para añadir personajes de forma dinámica.
 *
 * @param characterToShow Objeto de tipo {@link CharacterToShow} que se podría añadir.
 */
private fun CharacterToShow.Companion.add(characterToShow: CharacterToShow) {}
