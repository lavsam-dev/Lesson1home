package lavsam.gb.profias.lesson1home.presenters

import io.reactivex.Observable

interface Interactor<T> {
        fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
    }
