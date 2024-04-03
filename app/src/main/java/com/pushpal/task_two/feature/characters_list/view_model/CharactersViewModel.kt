package com.pushpal.task_two.feature.characters_list.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pushpal.task_two.feature.characters_list.model.CharactersModel
import com.pushpal.task_two.feature.characters_list.model.CharactersModelImpl
import com.pushpal.task_two.feature.characters_list.model.CharactersResponse
import com.pushpal.task_two.feature.characters_list.model.ModelCallback
import java.text.SimpleDateFormat
import java.util.Locale


class CharactersViewModel(private val charactersModel : CharactersModel) : ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {

                val charactersModel : CharactersModel = CharactersModelImpl()

                return CharactersViewModel(charactersModel) as T
            }
        }
    }

    val showLoader: MutableLiveData<Boolean> = MutableLiveData(false)
    val showError: MutableLiveData<String> = MutableLiveData("")
    val charactersItemUiModelList: MutableLiveData<List<CharactersItemUiModel>> = MutableLiveData()

    fun getCharactersList() {

        showLoader.postValue(true)

        charactersModel.fetchCharacterList(object : ModelCallback{
            override fun onSuccess(list: List<CharactersResponse>) {

                val characterListUiModel : List<CharactersItemUiModel> = getCharactersUiModelList(list)

                charactersItemUiModelList.postValue(characterListUiModel)
                showLoader.postValue(false)
            }

            override fun onError(error: String) {
                showLoader.postValue(false)
                showError.postValue(error)
            }

        })
    }

    private fun getCharactersUiModelList(charactersResponseList: List<CharactersResponse>) : List<CharactersItemUiModel> {
        val  charactersUiModelList = mutableListOf<CharactersItemUiModel>()

        charactersResponseList.forEach {

            val charactersUiModel = it.name?.let { it1 ->
                it.dateOfBirth?.let { it2 ->
                    CharactersItemUiModel(
                        firstName = it1,
                        lastName = it.name!!,
                        dateOfBirth = it2,
                        profileImage = it.image
                    )
                }
            }

            if (charactersUiModel != null) {
                charactersUiModelList.add(charactersUiModel)
            }
        }

        return charactersUiModelList
    }

    private fun getFormattedDate(dateInput: String) : String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())

        val charactersModifiedDate = inputFormat.parse(dateInput)

        return outputFormat.format(charactersModifiedDate)
    }
}