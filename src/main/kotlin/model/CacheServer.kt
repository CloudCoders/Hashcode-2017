package model

class CacheServer(val id: Int,
                  val capacity: Int,
                  val videos: MutableList<Video> = mutableListOf())
