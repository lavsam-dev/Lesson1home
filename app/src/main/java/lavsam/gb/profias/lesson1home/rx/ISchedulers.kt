package lavsam.gb.profias.lesson1home.rx

import io.reactivex.Scheduler

interface ISchedulers {
    fun io(): Scheduler
    fun main() : Scheduler
}