package lavsam.gb.profias.lesson1home.main

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import lavsam.gb.profias.lesson1home.main.view.ViewFragment
import lavsam.gb.profias.lesson1home.model.data.AppState
import lavsam.gb.profias.lesson1home.model.repository.DataSourceLocal
import lavsam.gb.profias.lesson1home.model.repository.DataSourceRemote
import lavsam.gb.profias.lesson1home.model.repository.RepositoryImpl
import lavsam.gb.profias.lesson1home.presenters.Presenter
import lavsam.gb.profias.lesson1home.rx.SchedulerProvider

class MainPresenterImpl<T : AppState, V : ViewFragment>(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImpl(DataSourceRemote()),
        RepositoryImpl(DataSourceLocal())),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : Presenter<T, V> {
    private var currentView: V? = null

    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detachView(view: V) {
        compositeDisposable.clear()
        if (view == currentView) {
            currentView = null
        }
    }

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.addAll(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.main())
                .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {
            override fun onNext(t: AppState) {
                currentView?.renderData(t)
            }

            override fun onError(e: Throwable) {
                currentView?.renderData(AppState.Error(e))
            }

            override fun onComplete() {}
        }
    }
}