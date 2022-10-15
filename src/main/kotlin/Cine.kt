class Cine{

    var savedMoney : Int = 0

    private var movies : Map<Int,Room> = initMovies()

    private fun initMovies(): Map<Int, Room> {
        var movies : MutableMap<Int, Room> = mutableMapOf()

        movies[1] = Room("Toy Story",300)
        movies[2] = Room("Avatar",200)
        movies[3] = Room("Avengers",500)

        return movies
    }


    fun buyTicket(roomId: Int, cantPeople: Int, name: String): Ticket{
        var film = ""
        var cost = 0

        if(cantPeople>0 && roomId in 1..3){
            film=movies[roomId]!!.film
            cost=(movies[roomId]!!.cost*cantPeople)
        }

        return Ticket(film,cost,name)
    }

    fun payTicket(ticket: Ticket){
        if(ticket.cost>=0)
            savedMoney += ticket.cost
        else
            throw Exception("The cost of the ticket should not be lower than 0")
    }

    fun findMovie(film: String): Int{
        var ret = 0

        for(i: Int in movies.keys)
            if(movies[i]!!.film==film)
                ret = i

        return ret
    }
}

class Room(var film: String, var cost: Int)

class Ticket(var film: String, var cost: Int, var client: String)