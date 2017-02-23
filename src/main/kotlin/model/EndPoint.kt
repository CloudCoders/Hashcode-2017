package model


class EndPoint(
        val id: Int,
        val lantency: Int,
        val connections: MutableMap<CacheServer, Int> = mutableMapOf())
