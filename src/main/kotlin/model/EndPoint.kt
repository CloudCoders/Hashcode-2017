package model

class EndPoint(
        val id: Int,
        val latency: Int,
        val cacheServers: MutableList<CacheServer> = mutableListOf(),
        val requests: MutableList<Request> = mutableListOf()) {

    fun add(request: Request) {
        requests.add(request)
    }

    fun add(cacheServers: List<CacheServer>) {
        cacheServers.forEach { this.cacheServers.add(it) }
    }
}