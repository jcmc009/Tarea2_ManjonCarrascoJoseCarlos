package dam.pmdm.tarea2_manjoncarrascojosecarlos

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import dam.pmdm.tarea2_manjoncarrascojosecarlos.databinding.ActivityMainBinding

/**
 * Actividad principal de la aplicación.
 *
 * Se encarga de inicializar la interfaz principal, configurar la Toolbar
 * con el sistema de navegación y gestionar las opciones del menú.
 * Además, muestra un mensaje de bienvenida mediante un Snackbar al iniciar.
 */
class MainActivity : AppCompatActivity() {

    /** Enlace al layout de la actividad mediante ViewBinding. */
    private lateinit var binding: ActivityMainBinding

    /**
     * Método llamado al crear la actividad.
     *
     * Configura la Toolbar como ActionBar, inicializa el controlador de navegación
     * y define la configuración de la barra de aplicación. También muestra un
     * mensaje de bienvenida si la actividad se inicia por primera vez.
     *
     * @param savedInstanceState Estado guardado de la instancia, si existe.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, _, _ ->
            // Fuerza a Android a llamar a 'onPrepareOptionsMenu' de nuevo
            invalidateOptionsMenu()
        }

        if (savedInstanceState == null) {
            Snackbar.make(binding.root, R.string.snack_bar_welcome, Snackbar.LENGTH_SHORT).show()
        }
    }

    /**
     * Infla el menú de opciones en la Toolbar.
     *
     * @param menu El objeto Menu en el que se añadirán los ítems.
     * @return true si el menú se ha creado correctamente.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_items, menu)
        return true
    }

    /**
     * Maneja las acciones al pulsar un ítem del menú.
     *
     * @param item El ítem del menú que ha sido seleccionado.
     * @return true si la acción ha sido gestionada correctamente, false en caso contrario.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        return when (item.itemId) {
            R.id.menu_settings -> {
                try {
                    navController.navigate(R.id.settingsFragment)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                true
            }
            R.id.menu_about -> {
                AlertDialog.Builder(this)
                    .setTitle(R.string.about_title)
                    .setMessage(R.string.about_message)
                    .setPositiveButton("ok", null)
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Prepara el menú de opciones antes de mostrarse.
     *
     * Dependiendo del destino actual de la navegación, muestra u oculta
     * los ítems del menú (settings y about).
     *
     * @param menu El menú que se va a preparar.
     * @return true si el menú se ha preparado correctamente.
     */
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        val navController =
            navHostFragment?.navController ?: return super.onPrepareOptionsMenu(menu)

        val idDestinoActual = navController.currentDestination?.id

        if (idDestinoActual == R.id.listFragment) {
            menu?.findItem(R.id.menu_settings)?.isVisible = true
            menu?.findItem(R.id.menu_about)?.isVisible = true
        } else {
            menu?.findItem(R.id.menu_settings)?.isVisible = false
            menu?.findItem(R.id.menu_about)?.isVisible = false
        }

        return super.onPrepareOptionsMenu(menu)
    }

    /**
     * Gestiona la acción de navegación hacia atrás desde la Toolbar.
     *
     * Conecta la flecha de la Toolbar con la acción de "ir atrás" del sistema,
     * utilizando el controlador de navegación.
     *
     * @return true si la navegación hacia atrás se ha realizado correctamente.
     */
    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
