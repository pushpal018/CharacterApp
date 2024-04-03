package com.pushpal.task_two.feature.characters_list.model

interface ModelCallback {
    fun onSuccess(list: List<CharactersResponse>)
    fun onError(error: String)
}