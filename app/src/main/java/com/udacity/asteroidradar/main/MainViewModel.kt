package com.udacity.asteroidradar.main

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.*
import com.udacity.asteroidradar.database.AsteroidDatabase
import com.udacity.asteroidradar.Repo
import com.udacity.asteroidradar.Util
import com.udacity.asteroidradar.domain.Asteroid
import kotlinx.coroutines.launch


class MainViewModel(app: Application) : ViewModel() {

        private val database=AsteroidDatabase.getDatabase(app)
        private val repositoryAstroid= Repo(database)
        val image=repositoryAstroid.image

    private val asteroidFilter = MutableLiveData(Util.AsteroidFilter.SHOW_SAVED)

    private val repo = Repo(database)
    init {
        viewModelScope.launch {
            repo.refresh()
        }
    }

    private val _asteroidSelected = MutableLiveData<Asteroid?>()
    val selectedProperty: MutableLiveData<Asteroid?>
        get() = _asteroidSelected
    fun displayAsteroid() {
        _asteroidSelected.value = null
    }

    val asteroids = Transformations.switchMap(asteroidFilter){
        when (it) {
            Util.AsteroidFilter.SHOW_TODAY -> repositoryAstroid.asteroidToday
            Util.AsteroidFilter.SHOW_WEEK -> repositoryAstroid.asteroidWeek
            else -> repositoryAstroid.asteroidAll
        }
    }
fun applyFilter(selectedDateItem: Util.AsteroidFilter) {
    asteroidFilter.value=selectedDateItem } }

 //    Factory for constructing MainViewModel with parameter
class Factory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}