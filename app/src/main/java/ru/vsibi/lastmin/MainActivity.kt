package ru.vsibi.lastmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import ru.movemove.presentation.helpers.Router

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val router : Router by lazy { Router.instance }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        router.parentNavHostFragment = navHostFragment
    }

    override fun onBackPressed() {
        if (router.childNavController?.popBackStack() == false) {
            if(router.parentNavController?.popBackStack() == false){
                finish()
            }
        }
    }
}