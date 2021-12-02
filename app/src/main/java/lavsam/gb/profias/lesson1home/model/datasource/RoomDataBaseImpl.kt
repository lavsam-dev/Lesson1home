package lavsam.gb.profias.lesson1home.model.datasource

import io.reactivex.Observable
import lavsam.gb.profias.lesson1home.model.data.Vocabulary

class RoomDataBaseImpl : DataSource<List<Vocabulary>> {
    override fun getData(word: String): Observable<List<Vocabulary>> {
        TODO("Not yet implemented")
    }
}