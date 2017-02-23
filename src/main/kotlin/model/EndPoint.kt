package model

import jdk.nashorn.internal.ir.RuntimeNode

class EndPoint(
        val id: Int,
        val latency: Int,
        val cacheServers: List<CacheServer>,
        val requests: List<Request>)