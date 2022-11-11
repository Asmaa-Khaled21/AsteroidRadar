package com.udacity.asteroidradar.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.udacity.asteroidradar.domain.Asteroid
import com.udacity.asteroidradar.domain.Image

@Entity
data class AsteroidDatabaseObj(
                    @PrimaryKey
                    val id: Long,
                    val codename: String,
                    val closeApproachDate: String,
                    val absoluteMagnitude: Double,
                    val estimatedDiameter: Double,
                    val relativeVelocity: Double,
                    val distanceFromEarth: Double,
                    val isPotentiallyHazardous: Boolean)
fun List<AsteroidDatabaseObj>.asDomainObj():List<Asteroid>
{
return map {
    Asteroid(
        id=it.id,
        codename =it.codename,
        closeApproachDate = it.closeApproachDate,
        absoluteMagnitude =it.absoluteMagnitude,
        estimatedDiameter = it.estimatedDiameter,
        relativeVelocity = it.relativeVelocity,
        distanceFromEarth = it.distanceFromEarth,
        isPotentiallyHazardous = it.isPotentiallyHazardous )
  }
}

@Entity
data class ImageDatabase( @PrimaryKey
 val url:String,
 val media_type:String,
  val title:String )

fun ImageDatabase.asImageDomain(): Image {
    return Image( url, media_type, title )
}

