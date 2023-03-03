package com.openpay.dogsapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.openpay.dogsapp.databinding.ActivityMainBinding
import com.openpay.dogsapp.model.repository.DogRepository
import com.openpay.dogsapp.view.adapter.DogAdapter
import com.openpay.dogsapp.viewmodel.DogViewModel
import com.openpay.dogsapp.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dogAdapter = DogAdapter(this@MainActivity)
    private lateinit var dogViewModel: DogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initViewModel()
        initViews()
        initErrorMessage()
        fetchData()
    }

    private fun initViewModel() {
        dogViewModel = ViewModelProvider(this, ViewModelFactory(DogRepository())).get(
            DogViewModel::class.java
        )
    }

    private fun initErrorMessage() {
        dogViewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun initViews() {
        binding.backButton.setOnClickListener { onBackPressed() }
        initRecycleView()
    }

    private fun initRecycleView() {
        binding.dogsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.dogsRecyclerView.adapter = dogAdapter

        dogViewModel.dogList.observe(this) {
            dogAdapter.setDogs(it)
        }
    }

    private fun fetchData() {
        dogViewModel.getDogs()
    }
}