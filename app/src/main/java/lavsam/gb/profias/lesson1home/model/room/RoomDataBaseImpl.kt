package lavsam.gb.profias.lesson1home.model.room

import io.reactivex.Observable
import lavsam.gb.profias.lesson1home.Contract
import lavsam.gb.profias.lesson1home.model.data.Vocabulary

class RoomDataBaseImpl : Contract.DataSource<List<Vocabulary>> {
    override fun getData(word: String): Observable<List<Vocabulary>> {
        TODO("Not yet implemented")
    }
}