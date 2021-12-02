package lavsam.gb.profias.lesson1home.main

import io.reactivex.Observable
import lavsam.gb.profias.lesson1home.model.data.AppState
import lavsam.gb.profias.lesson1home.model.data.Vocabulary
import lavsam.gb.profias.lesson1home.model.repository.Repository
import lavsam.gb.profias.lesson1home.presenters.Interactor

class MainInteractor(
    private val remoteRepository: Repository<List<Vocabulary>>,
    private val localRepository: Repository<List<Vocabulary>>,
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}