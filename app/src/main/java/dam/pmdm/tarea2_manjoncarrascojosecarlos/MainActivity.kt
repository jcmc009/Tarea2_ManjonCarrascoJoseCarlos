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

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val toolbar = findViewById<Toolbar>(R.id.toolbar)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflar el menú añade los ítems a la action bar si está presente.
        menuInflater.inflate(R.menu.toolbar_items, menu)
        return true
    }

    // Este metodo se usa para manejar las acciones al pulsar un ítem
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 1. Obtenemos el controlador de navegación
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        return when (item.itemId) {
            R.id.menu_settings -> {

                
                // Esto hace que el sistema sepa que has cambiado de pantalla y MUESTRE LA FLECHA sola.
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

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        // 1. Buscamos el controlador para saber dónde estamos
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        val navController =
            navHostFragment?.navController ?: return super.onPrepareOptionsMenu(menu)
        val idDestinoActual = navController.currentDestination?.id
        // 2. Verificamos si estamos en la lista
        if (idDestinoActual == R.id.listFragment) {
            // Si estamos en pantalla principal , se muestran las opciones
            menu?.findItem(R.id.menu_settings)?.isVisible = true
            menu?.findItem(R.id.menu_about)?.isVisible = true
        } else {
            //Se ocultan
            menu?.findItem(R.id.menu_settings)?.isVisible = false
            menu?.findItem(R.id.menu_about)?.isVisible = false
        }

        return super.onPrepareOptionsMenu(menu)
    }

    // Esto conecta la flecha de la Toolbar con la acción de "ir atrás" del sistema
    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        // Esto le dice al sistema: "Intenta navegar hacia atrás usando el controlador"
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}