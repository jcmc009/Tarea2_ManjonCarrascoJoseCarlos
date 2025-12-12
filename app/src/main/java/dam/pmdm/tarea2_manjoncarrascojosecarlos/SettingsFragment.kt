package dam.pmdm.tarea2_manjoncarrascojosecarlos

import android.content.res.Configuration
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import dam.pmdm.tarea2_manjoncarrascojosecarlos.databinding.FragmentSettingsBinding
import java.util.Locale

/**
 * Fragmento encargado de gestionar la configuración de la aplicación.
 *
 * Permite al usuario cambiar el idioma (español/inglés) y el modo de la interfaz
 * (claro/oscuro). Los cambios se aplican de forma inmediata y se reflejan en toda
 * la aplicación reiniciando la actividad principal.
 */
class SettingsFragment : Fragment() {

    /** Enlace al layout del fragmento mediante ViewBinding. */
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    /**
     * Método llamado al crear el fragmento.
     *
     * Se habilita la opción de modificar el menú de la Toolbar desde este fragmento.
     *
     * @param savedInstanceState Estado guardado de la instancia, si existe.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Limpia el menú de la Toolbar al entrar en este fragmento.
     *
     * @param menu El menú actual.
     * @param inflater Objeto utilizado para inflar menús.
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

    /**
     * Configura la vista del fragmento una vez creada.
     *
     * Detecta el idioma y el modo actual de la aplicación para marcar los
     * RadioButtons correspondientes. Define los listeners para cambiar idioma
     * y modo de la interfaz cuando el usuario selecciona una opción distinta.
     *
     * @param view La vista raíz del fragmento.
     * @param savedInstanceState Estado guardado de la instancia, si existe.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentLang = resources.configuration.locales[0].language
        binding.rgIdioma.setOnCheckedChangeListener(null)

        if (currentLang == "es") {
            binding.rbSpanish.isChecked = true
        } else {
            binding.rbEnglish.isChecked = true
        }

        val modoActual = AppCompatDelegate.getDefaultNightMode()
        if (modoActual == AppCompatDelegate.MODE_NIGHT_YES) {
            binding.rbOscuro.isChecked = true
        } else {
            binding.rbClaro.isChecked = true
        }

        binding.rgIdioma.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbSpanish -> if (currentLang != "es") cambiarIdioma("es")
                R.id.rbEnglish -> if (currentLang != "en") cambiarIdioma("en")
            }
        }

        binding.rgModo.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbClaro -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                R.id.rbOscuro -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }

    /**
     * Cambia el idioma de la aplicación.
     *
     * @param languageCode Código del idioma a aplicar (por ejemplo, "es" para español, "en" para inglés).
     */
    private fun cambiarIdioma(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        // Reiniciamos la actividad para aplicar cambios
        activity?.recreate()
    }

    /**
     * Limpia el objeto de binding al destruir la vista del fragmento.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
