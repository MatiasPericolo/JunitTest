import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class CineTest {

    private val cine = Cine() ;

    @BeforeEach
    fun setup(){
        cine.savedMoney = 0
    }

    @Test
    fun buyValidTicketTest() {
        var result = cine.buyTicket(1,1,"Matias")

        assertEquals("Toy Story",result.film)
        assertEquals(300,result.cost)
        assertEquals("Matias",result.client)
    }

    @Test
    fun buyTicketInvalidZeroIdTest(){
        var result = cine.buyTicket(0,1,"Matias")

        assertEquals("",result.film)
        assertEquals(0,result.cost)
        assertEquals("Matias",result.client)
    }

    @Test
    fun buyTicketInvalidNegativeIdTest(){
        var result = cine.buyTicket(-1,1,"Matias")

        assertEquals("",result.film)
        assertEquals(0,result.cost)
        assertEquals("Matias",result.client)
    }

    @Test
    fun buyTicketInvalidUpperLimitIdTest(){
        var result = cine.buyTicket(5,1,"Matias")

        assertEquals("",result.film)
        assertEquals(0,result.cost)
        assertEquals("Matias",result.client)
    }

    @Test
    fun buyTicketInvalidNegativeCantTest(){
        var result = cine.buyTicket(1,-1,"Matias")

        assertEquals("",result.film)
        assertEquals(0,result.cost)
        assertEquals("Matias",result.client)
    }

    @Test
    fun buyTicketInvalidZeroCantTest(){
        var result = cine.buyTicket(1,0,"Matias")

        assertEquals("",result.film)
        assertEquals(0,result.cost)
        assertEquals("Matias",result.client)
    }

    @Test
    fun payTicketTest(){
        cine.payTicket(Ticket("Toy Story",300,"Matias"))

        assertEquals(300,cine.savedMoney)
    }

    @Test
    fun payZeroCostTicketTest(){
        cine.payTicket(Ticket("",0,"Matias"))

        assertEquals(0,cine.savedMoney)
    }

    @Test
    fun payNegativeCostTicketTest(){
        assertThrows<Exception> { cine.payTicket(Ticket("", -1, "Matias")) }
    }

    @Test
    fun findMovie(){
        var result = cine.findMovie("Toy Story")

        assertEquals(1,result)
    }

    @Test
    fun findEmptyMovie(){
        var result = cine.findMovie("")

        assertEquals(0,result)
    }

    @Test
    fun findInvalidMovie(){
        var result = cine.findMovie("Interstellar")

        assertEquals(0,result)
    }

}