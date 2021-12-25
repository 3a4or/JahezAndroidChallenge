package net.jahez.jahezchallenge.data.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseRepository @Inject constructor(val api: Api) {
}