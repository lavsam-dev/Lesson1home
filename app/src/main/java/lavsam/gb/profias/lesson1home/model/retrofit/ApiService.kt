package lavsam.gb.profias.lesson1home.model.retrofit

import io.reactivex.Observable
import lavsam.gb.profias.lesson1home.model.data.Vocabulary
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<Vocabulary>>
}