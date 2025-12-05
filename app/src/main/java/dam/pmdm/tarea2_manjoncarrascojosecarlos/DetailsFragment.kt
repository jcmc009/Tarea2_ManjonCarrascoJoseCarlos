package dam.pmdm.tarea2_manjoncarrascojosecarlos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dam.pmdm.tarea2_manjoncarrascojosecarlos.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val name = arguments?.getString("name")
//        val description = arguments?.getString("description")
//        val image = arguments?.getInt("image")
        val nombrePikmin = arguments?.getString("name") ?: "desconocido"

        val mensaje = "${getString(R.string.toast_selected)} $nombrePikmin"
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()
        binding.characterName.text = arguments?.getString("name")
        binding.characterImage.setImageResource(arguments?.getInt("image")!!)
        binding.characterDescription.text = arguments?.getString("description")
        binding.characterAbilities.text = arguments?.getString("abilities")

    }

}