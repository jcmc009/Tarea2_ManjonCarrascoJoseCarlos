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


class listFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        val lista = getListaPersonajes()
//        binding.recyclerView.adapter = Adapter(loadCharacterFromJson()) { selectedCharacter ->
        binding.recyclerView.adapter = Adapter(getListaPersonajes()) { selectedCharacter ->
            Toast.makeText(
                requireContext(),
                "character=${selectedCharacter.name}",
                Toast.LENGTH_SHORT
            )
//                .show()
            val bundle = Bundle()
            //bundle.putString("name", selectedCharacter.name)
            bundle.putString("name", getString(selectedCharacter.name))
            //bundle.putString("description", selectedCharacter.description")
//            bundle.putString("description", selectedCharacter.description)
            bundle.putString("description", getString(selectedCharacter.description))
            bundle.putInt("image", selectedCharacter.getImage())
            bundle.putString("abilities", getString(selectedCharacter.abilities))

            findNavController().navigate(R.id.detailsFragment, bundle)

        }

    }

//    private fun loadCharacterFromJson(): List<CharacterToShow> {
//        val inputStream = resources.openRawResource(R.raw.characters)
//        val jsonString = inputStream.bufferedReader().use(BufferedReader::readText)
//        val listType = object : TypeToken<List<CharacterToShow>>() {}.type
//        return Gson().fromJson(jsonString, listType)
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Esto permite al fragmento modificar el menú de la Toolbar
        setHasOptionsMenu(true)
    }
    /**
     * Metódo que añade objetos de tipo PersonajesData y los añade a un Arraylist
     */
    private fun getListaPersonajes(): List<CharacterToShow> {
        val lista = ArrayList<CharacterToShow>()

        lista.add(
            CharacterToShow(

                // El Adapter se encargará de traducirlos con setText()
                R.drawable.pikmin_red,
                R.string.pikmin_red,
                R.string.pikmin_red_description,
                R.string.pikmin_red_abilities
            )
        )
        lista.add(
            CharacterToShow(

                // El Adapter se encargará de traducirlos con setText()
                R.drawable.pikmin_alado,
                R.string.pikmin_alado,
                R.string.pikmin_alado_description,
                R.string.pikmin_alado_abilities
            )
        )
        lista.add(
            CharacterToShow(

                // El Adapter se encargará de traducirlos con setText()
                R.drawable.pikmin_blue,
                R.string.pikmin_blue,
                R.string.pikmin_blue_description,
                R.string.pikmin_blue_abilities
            )
        )
        lista.add(
            CharacterToShow(

                // El Adapter se encargará de traducirlos con setText()
                R.drawable.pikmin_glow,
                R.string.pikmin_glow,
                R.string.pikmin_glow_description,
                R.string.pikmin_glow_abilities
            )
        )
        lista.add(
            CharacterToShow(

                // El Adapter se encargará de traducirlos con setText()
                R.drawable.pikmin_ice,
                R.string.pikmin_ice,
                R.string.pikmin_ice_description,
                R.string.pikmin_ice_abilities
            )
        )
        lista.add(
            CharacterToShow(

                // El Adapter se encargará de traducirlos con setText()
                R.drawable.pikmin_purple,
                R.string.pikmin_purple,
                R.string.pikmin_purple_description,
                R.string.pikmin_purple_abilities
            )
        )
        lista.add(
            CharacterToShow(

                // El Adapter se encargará de traducirlos con setText()
                R.drawable.pikmin_rock,
                R.string.pikmin_rock,
                R.string.pikmin_rock_description,
                R.string.pikmin_rock_abilities
            )
        )
        lista.add(
            CharacterToShow(

                // El Adapter se encargará de traducirlos con setText()
                R.drawable.pikmin_white,
                R.string.pikmin_white,
                R.string.pikmin_white_description,
                R.string.pikmin_white_abilities
            )
        )
        lista.add(
            CharacterToShow(

                // El Adapter se encargará de traducirlos con setText()
                R.drawable.pikmin_yellow,
                R.string.pikmin_yellow,
                R.string.pikmin_yellow_description,
                R.string.pikmin_yellow_abilities
            )
        )


        return lista
    }
}

private fun CharacterToShow.Companion.add(characterToShow: CharacterToShow) {}
