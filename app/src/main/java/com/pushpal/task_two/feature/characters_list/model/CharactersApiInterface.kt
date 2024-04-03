package com.pushpal.task_two.feature.characters_list.model

import retrofit2.Call
import retrofit2.http.GET

interface CharactersApiInterface {

    @GET("characters")
    fun getCharacterList() : Call<List<CharactersResponse>>
}