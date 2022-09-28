package com.podolian.database.model

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

class PersistedItemData() : RealmObject {
    var artistName: String = ""
    var id: String = ""
    var name: String = ""
    var releaseDate: String = ""
    var artworkUrl100: String = ""
    var genres: RealmList<PersistedGenre> = realmListOf()
    var url: String? = ""

    constructor(
        artistName: String,
        id: String,
        name: String,
        releaseDate: String,
        artworkUrl100: String,
        genres: RealmList<PersistedGenre>,
        url: String?
    ) : this() {
        this.artistName = artistName
        this.id = id
        this.name = name
        this.releaseDate = releaseDate
        this.artworkUrl100 = artworkUrl100
        this.genres = genres
        this.url = url
    }
}