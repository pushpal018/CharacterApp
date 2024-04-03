package com.pushpal.task_two.feature.characters_list.model

import android.util.Log
import com.pushpal.task_two.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CharactersModelImpl : CharactersModel {

    private val characterApiInterface = RetrofitClient.client.create<CharactersApiInterface>()

    override fun fetchCharacterList(callback: ModelCallback) {

        val apiCall = characterApiInterface.getCharacterList()

        apiCall.enqueue(object : Callback<List<CharactersResponse>> {
            override fun onResponse(
                call: Call<List<CharactersResponse>>,
                response: Response<List<CharactersResponse>>
            ) {
                val characterList = response.body()

                if (characterList?.isEmpty() == true) {
                    callback.onError("Content not found")
                } else {
                    callback.onSuccess(characterList!!)
                }
            }

            override fun onFailure(call: Call<List<CharactersResponse>>, t: Throwable) {
                callback.onError(t.message ?: "Something went wrong")
                Log.d("Error-Message",t.message.toString())
            }
        })
    }
}