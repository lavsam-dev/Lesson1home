package lavsam.gb.profias.lesson1home.main.view

import lavsam.gb.profias.lesson1home.model.data.AppState

interface ViewFragment {
    fun renderData(appState: AppState)
}
