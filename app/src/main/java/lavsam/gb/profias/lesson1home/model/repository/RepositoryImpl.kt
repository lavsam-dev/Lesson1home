package lavsam.gb.profias.lesson1home.model.repository

import io.reactivex.Observable
import lavsam.gb.profias.lesson1home.Contract
import lavsam.gb.profias.lesson1home.model.data.Vocabulary

class RepositoryImpl (private val dataSource: Contract.DataSource<List<Vocabulary>>) :
    Contract.Repository<List<Vocabulary>> {
    override fun getData(word: String): Observable<List<Vocabulary>> {
        return dataSource.getData(word)
    }
}