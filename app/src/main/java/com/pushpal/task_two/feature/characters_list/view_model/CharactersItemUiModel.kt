package com.pushpal.task_two.feature.characters_list.view_model

import java.io.Serializable

data class CharactersItemUiModel(
    val name: String,
    val dateOfBirth: String,
    val profileImage: String,
    val gender: String,
    val house: String,
    val eyeColor: String,
    val hairColor: String,
    val actor: String
) : Serializable
