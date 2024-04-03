package com.pushpal.task_two.feature.characters_list.model

interface CharactersModel {
    fun fetchCharacterList(callback: ModelCallback)
}