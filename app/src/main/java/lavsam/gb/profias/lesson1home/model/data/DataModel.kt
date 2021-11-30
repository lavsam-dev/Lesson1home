package lavsam.gb.profias.lesson1home.model.data

import com.google.gson.annotations.SerializedName

class Vocabulary(
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("text") val text: String?,
    @field:SerializedName("meanings") val meanings: List<Meanings>?
)

class Meanings(
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("translation") val translation: Translation?,
    @field:SerializedName("imageUrl") val imageUrl: String?,
    @field:SerializedName("transcription") val transcription: String?,
    @field:SerializedName("soundUrl") val soundUrl: String?
)

class Translation(
    @field:SerializedName("text") val translation: String?,
    @field:SerializedName("note") val note: String?
)