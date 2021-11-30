package lavsam.gb.profias.lesson1home

import io.reactivex.Observable
import lavsam.gb.profias.lesson1home.model.AppState
import lavsam.gb.profias.lesson1home.model.data.Vocabulary

class MainInteractor(
    private val remoteRepository: Contract.Repository<List<Vocabulary>>,
    private val localRepository: Contract.Repository<List<Vocabulary>>,
) : Contract.Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}