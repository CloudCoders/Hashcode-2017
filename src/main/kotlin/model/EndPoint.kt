package model

class EndPoint(
        val id: Int,
        val connections: Map<Int, CacheServer>)