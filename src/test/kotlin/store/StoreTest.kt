package store

import model.DataCenter
import org.hamcrest.core.Is.`is`
import org.junit.Test

import org.junit.Assert.*

class StoreTest {

    fun dataCenter(): DataCenter {
        return Store().read("input.in")
    }

    @Test
    fun `should get data center`() {
        var dataCenter = dataCenter()
        assertThat(dataCenter.videos.size, `is`(5))
    }

}