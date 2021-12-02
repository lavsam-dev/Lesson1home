package lavsam.gb.profias.lesson1home.model.repository

import io.reactivex.Observable

interface Repository<T> {
    fun getData(word: String): Observable<T>
}