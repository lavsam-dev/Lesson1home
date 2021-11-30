package lavsam.gb.profias.lesson1home.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class SchedulerProvider : ISchedulers {
    override fun io(): Scheduler = io.reactivex.schedulers.Schedulers.io()
    override fun main(): Scheduler = AndroidSchedulers.mainThread()
}