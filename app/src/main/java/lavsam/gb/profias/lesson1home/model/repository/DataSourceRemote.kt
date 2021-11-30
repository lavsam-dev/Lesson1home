package lavsam.gb.profias.lesson1home.model.repository

import io.reactivex.Observable
import lavsam.gb.profias.lesson1home.Contract
import lavsam.gb.profias.lesson1home.model.data.Vocabulary
import lavsam.gb.profias.lesson1home.model.retrofit.RetrofitImpl

class DataSourceRemote(private val remoteProvider: RetrofitImpl = RetrofitImpl()) :
    Contract.DataSource<List<Vocabulary>> {
    override fun getData(word: String): Observable<List<Vocabulary>> = remoteProvider.getData(word)
}