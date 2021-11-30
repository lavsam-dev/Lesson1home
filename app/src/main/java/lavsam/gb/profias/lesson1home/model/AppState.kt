package lavsam.gb.profias.lesson1home.model

import lavsam.gb.profias.lesson1home.model.data.Vocabulary

sealed class AppState {
    data class Success(val data: List<Vocabulary>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}
