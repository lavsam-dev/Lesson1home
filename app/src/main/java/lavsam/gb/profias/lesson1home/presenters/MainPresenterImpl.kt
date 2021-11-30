package lavsam.gb.profias.lesson1home.presenters

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import lavsam.gb.profias.lesson1home.Contract
import lavsam.gb.profias.lesson1home.MainInteractor
import lavsam.gb.profias.lesson1home.model.AppState
import lavsam.gb.profias.lesson1home.model.repository.DataSourceLocal
import lavsam.gb.profias.lesson1home.model.repository.DataSourceRemote
import lavsam.gb.profias.lesson1home.model.repository.RepositoryImpl
import lavsam.gb.profias.lesson1home.rx.SchedulerProvider

class MainPresenterImpl<T : AppState, V : Contract.View>(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImpl(DataSourceRemote()),
        RepositoryImpl(DataSourceLocal())),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : Contract.Presenter<T, V> {
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