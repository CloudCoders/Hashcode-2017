package store

import model.*
import java.io.File
import java.util.*

class Store() {

    fun read(fileName: String): DataCenter {

        val scanner = Scanner(File(fileName))

        val nVideos = scanner.nextInt()
        val nEndpoints = scanner.nextInt()
        val nRequests = scanner.nextInt()
        val nCacheServers = scanner.nextInt()
        val nCapacities = scanner.nextInt()
        scanner.nextLine()

        val cacheServers = Array<CacheServer>(nCacheServers) {
            index ->
            CacheServer(id = index, capacity = nCapacities)
        }

        val videos = (0..(nVideos - 1)).map {
            Video(id = it, sizeMB = scanner.nextInt())
        }

        val endPoints = (0..(nEndpoints - 1)).map {
            scanner.nextLine()
            val endPoint = EndPoint(id = it, lantency = scanner.nextInt())

            val nCaches = scanner.nextInt()
            scanner.nextLine()

            for (i in (0..(nCaches - 1))) {
                val cacheId = scanner.nextInt()
                val latency = scanner.nextInt()
                var cacheServer = cacheServers.find { it.id == cacheId }!!
                endPoint.connections.put(cacheServer, latency)
            }
            endPoint
        }

        for (i in (0..(nRequests - 1))) {
            val videoId = scanner.nextInt()
            val endPointId = scanner.nextInt()
            val requests = scanner.nextInt()

            val endPoint = endPoints.find { it.id == endPointId}!!
            val request = Request(requests = requests, fromEndPoint = endPoint)
            videos.find { it.id == videoId }!!.requests.add(request)
            if (scanner.hasNextLine()) scanner.nextLine()
        }

        return DataCenter(videos)
    }

}