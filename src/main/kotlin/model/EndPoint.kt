package model

import jdk.nashorn.internal.ir.RuntimeNode

class EndPoint(
        val id: Int,
        val connections: Map<Int, CacheServer>)