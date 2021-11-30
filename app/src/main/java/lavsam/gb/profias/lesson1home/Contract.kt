package lavsam.gb.profias.lesson1home

import io.reactivex.Observable

class Contract {

    interface Interactor<T> {
        fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
    }

    interface Repository<T> {
        fun getData(word: String): Observable<T>
    }

    interface DataSource<T> {
        fun getData(word: String): Observable<T>
    }
}