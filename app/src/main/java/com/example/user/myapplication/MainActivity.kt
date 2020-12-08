package com.example.user.myapplication

import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("OnCreate\t V")
        setContentView(R.layout.navigation_activity)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?:return

        val navController = host.navController
        val drawerLayout : DrawerLayout? = findViewById(R.id.drawer_layout)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home_dest, R.id.deeplink_dest),
            drawerLayout
        )

        setupActionBar(navController, appBarConfiguration)
        setupNavigationMenu(navController)
        setupBottomNavMenu(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                destination.id.toString()
            }
        }
    }

    private fun setupBottomNavMenu(navController: NavController) {
        // Use NavigationUI to set up Bottom Navigation Menu

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.setupWithNavController(navController)
    }

    private fun setupNavigationMenu(navController: NavController) {
        // Use NavigationUI to set up a Navigation menu
        val sideNavView = findViewById<NavigationView>(R.id.nav_view)
        sideNavView?.setupWithNavController(navController)

    }

    private fun setupActionBar(navController: NavController, appBarConfig: AppBarConfiguration) {
        setupActionBarWithNavController(navController, appBarConfig)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val returnValue =  super.onCreateOptionsMenu(menu)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)

        if (navigationView == null) {
            menuInflater.inflate(R.menu.overflow_menu, menu)
            return true
        }
        return returnValue
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.my_nav_host_fragment))
                || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.my_nav_host_fragment).navigateUp(appBarConfiguration)
    }

    override fun onStart() {
        super.onStart()
        Timber.i("OnStart\t >")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume\t >>")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause\t ||")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy\t X")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart\t |>")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("OnStop\t []")
    }
}
