package logic

import model.CacheServer
import model.EndPoint
import model.Request
import model.Video

class Balancer {

    private fun getLargeEnoughVideos(videos: List<Video>, cacheSize: Int): List<Video> =
            videos.filter { it.sizeMB <= cacheSize }

    private fun sortVideosByRequests(videos: List<Video>): List<Video> {
        videos.forEach { it.requests.sortedByDescending { it.requests } }
        return videos.sortedByDescending { it.requests[0].requests }
    }

    private fun canPutVideoInCacheServer(video: Video, cacheServer: CacheServer): Boolean =
            video.sizeMB <= cacheServer.capacity

    private fun getCacheServersSortedByLatency(endPoint: EndPoint): List<CacheServer> {
        return emptyList()
    }


    fun balance(videos: List<Video>, endPoints: List<EndPoint>, cacheServers: List<CacheServer>): List<CacheServer> {
        val sortedVideos = sortVideosByRequests(getLargeEnoughVideos(videos, cacheServers[0].capacity))
        var resultCaches = emptyList<CacheServer>()

        sortedVideos.forEach { video ->
            video.requests.forEach { req ->
                val connectedCacheServers = getCacheServersSortedByLatency(req.fromEndPoint)
                connectedCacheServers.first { canPutVideoInCacheServer(video, it) }
            }
        }

        return resultCaches

    }


}