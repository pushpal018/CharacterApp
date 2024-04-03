package com.pushpal.task_two.feature.characters_list.model

import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.google.gson.annotations.Expose

@Keep
data class CharactersResponse(

    @Expose
    @SerializedName("id")
    var id : String,

    @Expose
    @SerializedName("name")
    var name : String ?=null,

    @Expose
    @SerializedName("alternate_names")
    var alternateNames  : ArrayList<String> = arrayListOf(),

    @Expose
    @SerializedName("species")
    var species : String,

    @Expose
    @SerializedName("gender")
    var gender : String,

    @Expose
    @SerializedName("house"            )
    var house : String,

    @Expose
    @SerializedName("dateOfBirth")
    var dateOfBirth : String?=null,

    @Expose
    @SerializedName("yearOfBirth")
    var yearOfBirth : Int,

    @Expose
    @SerializedName("wizard")
    var wizard : Boolean,

    @Expose
    @SerializedName("ancestry")
    var ancestry : String,

    @Expose
    @SerializedName("eyeColour")
    var eyeColour : String,

    @Expose
    @SerializedName("hairColour")
    var hairColour : String,

    @Expose
    @SerializedName("wand")
    var wand : Wand ,

    @Expose
    @SerializedName("patronus")
    var patronus : String,

    @Expose
    @SerializedName("hogwartsStudent")
    var hogwartsStudent : Boolean,

    @Expose
    @SerializedName("hogwartsStaff")
    var hogwartsStaff : Boolean,

    @Expose
    @SerializedName("actor")
    var actor : String,

    @Expose
    @SerializedName("alternate_actors")
    var alternateActors : ArrayList<String> = arrayListOf(),

    @Expose
    @SerializedName("alive")
    var alive : Boolean,

    @Expose
    @SerializedName("image")
    var image : String

)
data class Wand (

    @Expose
    @SerializedName("wood")
    var wood : String,

    @Expose
    @SerializedName("core")
    var core : String,

    @Expose
    @SerializedName("length")
    var length : Any

)