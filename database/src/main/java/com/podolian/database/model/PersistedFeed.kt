package com.podolian.database.model

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class PersistedFeed() : RealmObject {
    @PrimaryKey
    var id: String = ""
    var copyright: String = ""
    var results: RealmList<PersistedItemData> = realmListOf()

    constructor(
        id: String,
        copyright: String,
        results: RealmList<PersistedItemData>,
    ) : this() {
        this.id = id
        this.copyright = copyright
        this.results = results
    }
}