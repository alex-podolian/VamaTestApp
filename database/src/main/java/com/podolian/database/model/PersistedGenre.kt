package com.podolian.database.model

import io.realm.kotlin.types.RealmObject

class PersistedGenre() : RealmObject {
    var name: String = ""

    constructor(name: String) : this() {
        this.name = name
    }
}