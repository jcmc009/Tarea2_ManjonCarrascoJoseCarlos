package dam.pmdm.tarea2_manjoncarrascojosecarlos

import android.content.res.Configuration
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import dam.pmdm.tarea2_manjoncarrascojosecarlos.databinding.FragmentSettingsBinding
import java.util.Locale

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mantenemos esto para poder limpiar el menú
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflamos una sola vez usando el binding
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        // Devolvemos la raíz del binding
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //  Detectar idioma actual para marcar el botón correcto al entrar
        val currentLang = resources.configuration.locales[0].language

        // Evitamos que el listener salte durante la configuración inicial
        binding.rgIdioma.setOnCheckedChangeListener(null)

        if (currentLang == "es") {
            binding.rbSpanish.isChecked = true
        } else {
            binding.rbEnglish.isChecked = true
        }

        // Detectar estado actual para marcar el RadioButton correcto
        val modoActual = AppCompatDelegate.getDefaultNightMode()

        if (modoActual == AppCompatDelegate.MODE_NIGHT_YES) {
            binding.rbOscuro.isChecked = true
        } else {
            binding.rbClaro.isChecked = true
        }
        // Listener del Grupo entero (detecta cualquier cambio)
        binding.rgIdioma.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbSpanish -> {
                    // Solo cambiamos si no estaba ya en español
                    if (currentLang != "es") cambiarIdioma("es")
                }

                R.id.rbEnglish -> {
                    // Solo cambiamos si no estaba ya en inglés
                    if (currentLang != "en") cambiarIdioma("en")
                }
            }
        }

        // Listener del Grupo entero (detecta cualquier cambio)

        binding.rgModo.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbClaro -> {
                    // Activar Modo Claro
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }

                R.id.rbOscuro -> {
                    // Activar Modo Oscuro
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }

        }
    }


    // --- Lógica de cambio de idioma ---
    private fun cambiarIdioma(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        // Reiniciamos la actividad para aplicar cambios
        activity?.recreate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}