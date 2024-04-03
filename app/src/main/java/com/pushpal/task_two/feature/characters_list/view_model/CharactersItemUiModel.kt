package com.pushpal.task_two.feature.characters_list.view_model

import java.io.Serializable

data class CharactersItemUiModel(
    val firstName: String,
    val lastName: String,
    val dateOfBirth: String,
    val profileImage: String
) : Serializable
