package model

class Video(val id: Int,
            val sizeMB: Int,
            val requests: MutableList<Request> = mutableListOf())