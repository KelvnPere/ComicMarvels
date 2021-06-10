package com.example.comicmarvels

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.comicmarvels.data.repository.ComicRepository
import com.example.comicmarvels.ui.viewmodel.ComicViewModel
import com.example.comicmarvels.ui.viewmodel.ComicsViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ComicViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = ComicRepository()
        val viewModelProviderFactory = ComicsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(ComicViewModel::class.java)

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
    }
}