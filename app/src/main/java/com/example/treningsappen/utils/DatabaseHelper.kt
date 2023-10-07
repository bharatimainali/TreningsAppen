package com.example.treningsappen.utils

class DatabaseHelper {

    fun fetchData(query: String) {
        // Implement firebase because we are using anyway so i thought we can make a room for it also to prepare,
        // Storing data locally can improve the speed and responsiveness of an application. It also
    // allows the app to function offline. Once the device is online, it can then sync with the remote database.
        // so we need both i think.
    }

    fun readLocalData(query: String) {
        // Implement localdata
    }

    fun writeData(data: Any) {
        // Implement
    }

    fun writeLocalData(data: Any) {
        // Implement
    }

    fun updateData(data: Any) {
        // Implement
    }

    fun updateLocalData(data: Any) {
        // Implement
    }

    fun deleteData(query: String) {
        // Implement
    }

    fun deleteLocalData(query: String) {
        // Implement
    }
}