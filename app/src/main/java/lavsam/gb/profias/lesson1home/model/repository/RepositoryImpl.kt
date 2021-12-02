package lavsam.gb.profias.lesson1home.model.repository

import io.reactivex.Observable
import lavsam.gb.profias.lesson1home.model.data.Vocabulary
import lavsam.gb.profias.lesson1home.model.datasource.DataSource

class RepositoryImpl (private val dataSource: DataSource<List<Vocabulary>>) :
    Repository<List<Vocabulary>> {
    override fun getData(word: String): Observable<List<Vocabulary>> {
        return dataSource.getData(word)
    }
}