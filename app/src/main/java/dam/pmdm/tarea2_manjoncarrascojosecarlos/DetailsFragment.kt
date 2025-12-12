package dam.pmdm.tarea2_manjoncarrascojosecarlos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dam.pmdm.tarea2_manjoncarrascojosecarlos.databinding.FragmentDetailsBinding

/**
 * Fragmento encargado de mostrar los detalles de un personaje seleccionado.
 *
 * Este fragmento recibe argumentos (nombre, descripción, imagen y habilidades)
 * desde otro componente y los muestra en la interfaz de usuario. Además,
 * muestra un mensaje Toast indicando el personaje seleccionado.
 */
class DetailsFragment : Fragment() {
    /** Enlace al layout del fragmento mediante ViewBinding. */
    private lateinit var binding: FragmentDetailsBinding

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
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Configura la vista del fragmento una vez creada.
     *
     * Obtiene los argumentos pasados al fragmento (nombre, descripción, imagen y habilidades),
     * los asigna a las vistas correspondientes y muestra un mensaje Toast con el nombre
     * del personaje seleccionado.
     *
     * @param view La vista raíz del fragmento.
     * @param savedInstanceState Estado guardado de la instancia, si existe.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nombrePikmin = arguments?.getString("name") ?: "desconocido"

        val mensaje = "${getString(R.string.toast_selected)} $nombrePikmin"
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()
        binding.characterName.text = arguments?.getString("name")
        binding.characterImage.setImageResource(arguments?.getInt("image")!!)
        binding.characterDescription.text = arguments?.getString("description")
        binding.characterAbilities.text = arguments?.getString("abilities")

    }

}