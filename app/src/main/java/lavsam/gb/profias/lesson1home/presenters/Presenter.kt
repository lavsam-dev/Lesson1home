package lavsam.gb.profias.lesson1home.presenters

import lavsam.gb.profias.lesson1home.main.view.ViewFragment
import lavsam.gb.profias.lesson1home.model.data.AppState

interface Presenter<T : AppState, V : ViewFragment> {
    fun attachView(view: V)
    fun detachView(view: V)
    fun getData(word: String, isOnline: Boolean)
}