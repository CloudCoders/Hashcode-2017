import logic.Balancer
import model.CacheServer
import model.EndPoint
import model.Request
import model.Video

fun main(args: Array<String>) {

    val CACHE_CAPACITY = 100

    val cacheServer0 = CacheServer(0, CACHE_CAPACITY, emptyList<Video>())
    val cacheServer1 = CacheServer(1, CACHE_CAPACITY, emptyList<Video>())
    val cacheServer2 = CacheServer(2, CACHE_CAPACITY, emptyList<Video>())

    val connectionsEP0 = mapOf(
            Pair(100, cacheServer0),
            Pair(300, cacheServer1),
            Pair(200, cacheServer2)
    )

    val endPoint0 = EndPoint(0, connectionsEP0)
    val endPoint1 = EndPoint(1, emptyMap())

    val video0 = Video(0, 50, listOf(Request(1000, endPoint1)))
    val video1 = Video(1, 50, listOf(Request(1000, endPoint0)))
    val video2 = Video(2, 80, emptyList())
    val video3 = Video(3, 30, listOf(Request(3000, endPoint0)))
    val video4 = Video(4, 110, listOf(Request(500, endPoint0)))

    val balancer = Balancer()
    val balance = balancer.balance(
            listOf(video0, video1, video2, video3, video4),
            listOf(cacheServer0, cacheServer1, cacheServer2))

    balance.map(::println)

}