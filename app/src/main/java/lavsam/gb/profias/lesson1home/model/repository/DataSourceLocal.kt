package lavsam.gb.profias.lesson1home.model.repository

import io.reactivex.Observable
import lavsam.gb.profias.lesson1home.model.data.Vocabulary
import lavsam.gb.profias.lesson1home.model.datasource.DataSource
import lavsam.gb.profias.lesson1home.model.datasource.RoomDataBaseImpl

class DataSourceLocal(private val remoteProvider: RoomDataBaseImpl = RoomDataBaseImpl()) :
    DataSource<List<Vocabulary>> {
    override fun getData(word: String): Observable<List<Vocabulary>> = remoteProvider.getData(word)
}