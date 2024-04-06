package com.pushpal.task_two.feature.characters_details.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.pushpal.task_two.R
import com.pushpal.task_two.databinding.ActivityCharacterDetailsBinding
import com.pushpal.task_two.feature.characters_list.view_model.CharactersItemUiModel

class CharactersDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCharacterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val characterUiModel = intent.getSerializableExtra("character") as CharactersItemUiModel

        Glide.with(binding.ivProfileImage)
            .load(characterUiModel.profileImage)
            .placeholder(R.drawable.user)
            .into(binding.ivProfileImage)

        binding.tvName.text = characterUiModel.name
        binding.tvGender.text = characterUiModel.gender
        binding.tvAddress.text = characterUiModel.house
        binding.tvDateOfBirth.text = characterUiModel.dateOfBirth
        binding.tvEyeColor.text = characterUiModel.eyeColor
        binding.tvHairColor.text = characterUiModel.hairColor
        binding.tvActor.text = "Actor of "+characterUiModel.actor

    }
}