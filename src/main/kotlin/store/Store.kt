package store

import model.*
import java.io.File
import java.util.*
import javax.xml.ws.Endpoint

class Store() {

    fun read(fileName: String): DataCenter {

        val scanner = Scanner(File(fileName))

        val nVideos = scanner.nextInt()
        val nEndpoints = scanner.nextInt()
        val nRequests = scanner.nextInt()
        val nCacheServers = scanner.nextInt()
        val nCapacities = scanner.nextInt()
        scanner.nextLine()

        val videos = (0..(nVideos - 1)).map {
            Video(id = it, sizeMB = scanner.nextInt())
        }
        scanner.nextLine()

        val endPoints = (0..(nEndpoints - 1)).map {
            val endPoint = EndPoint(
                    id = it,
                    latency = scanner.nextInt()
            )

            val nCaches = scanner.nextInt()
            scanner.nextLine()

            endPoint.add((0..(nCaches - 1)).map {
                CacheServer(
                        id = scanner.nextInt(),
                        latency = scanner.nextInt())
            })

            scanner.nextLine()
            endPoint
        }

        for (i in (0..nRequests)) {
            val videoId = scanner.nextInt()
            val endPointId = scanner.nextInt()
            val requests = scanner.nextInt()

            val video = videos.find { it.id == videoId }!!
            val request = Request(requests = requests, video = video)
            val endPoint = endPoints.find { it.id == endPointId}!!
            endPoint.add(request)
        }


        return DataCenter(3, emptyList())
    }


}