package com.pushpal.task_two.feature.characters_list.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.pushpal.task_two.databinding.ActivityCharacterListBinding
import com.pushpal.task_two.feature.characters_list.view_model.CharactersViewModel

class CharactersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterListBinding
    private val viewModel: CharactersViewModel by viewModels { CharactersViewModel.Factory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel.getCharactersList()

        viewModel.showLoader.observe(this) { isVisible ->
            binding.progressBar.isVisible = isVisible
        }

        viewModel.showError.observe(this) { error ->
            if (error.isNotEmpty()) {
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            }
        }

        viewModel.charactersItemUiModelList.observe(this) { characterList ->
            if (characterList.isNotEmpty()) {
                val layoutManager = LinearLayoutManager(this)
                binding.recyclerView.layoutManager = layoutManager

                val adapter = CharactersRecyclerViewAdapter(characterList)
                binding.recyclerView.adapter = adapter

                binding.progressBar.isVisible = false
            }
        }
    }
}