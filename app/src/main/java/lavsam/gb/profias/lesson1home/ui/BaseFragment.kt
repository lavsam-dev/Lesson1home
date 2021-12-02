package lavsam.gb.profias.lesson1home.ui

import androidx.fragment.app.Fragment
import lavsam.gb.profias.lesson1home.main.view.ViewFragment
import lavsam.gb.profias.lesson1home.model.data.AppState
import lavsam.gb.profias.lesson1home.presenters.Presenter

abstract class BaseFragment<T : AppState> : Fragment(), ViewFragment {
    protected abstract fun createPresenter(): Presenter<T, ViewFragment>
    abstract override fun renderData(appState: AppState)
    protected val presenter: Presenter<T, ViewFragment> by lazy { createPresenter() }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }
}