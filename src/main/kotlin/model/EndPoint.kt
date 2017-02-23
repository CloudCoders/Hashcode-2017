package model

class EndPoint(
        val id: Int,
        val connections: Map<Int, CacheServer>,
        val requests: MutableList<Request> = = mutableListOf())

    fun add(request: Request) {
        requests.add(request)
    }

    fun add(cacheServers: List<CacheServer>) {
        cacheServers.forEach { this.cacheServers.add(it) }
    }
}
