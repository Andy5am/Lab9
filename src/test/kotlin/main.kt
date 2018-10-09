import com.github.kittinunf.fuel.Fuel
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction


//Andy Castillo 18040
//Marco Fuentes 18188

fun main(args: Array<String>){

    val url = "https://next.json-generator.com/api/json/get/EkeSgmXycS"
    val (request, response, result) = Fuel.get(url).responseObject(Cancion.CancionArrayDeserializer())
        val (canciones, err) = result



    Database.connect(
            "jdbc:postgresql:Canciones",
            "org.postgresql.Driver",
            "postgres",
            "gamecube"
    )

    transaction {
        SchemaUtils.create(Canciones)
        SchemaUtils.create(CancionesFavoritas)
        if (canciones != null) {
            for (cancion in canciones) {
                Canciones.insert {
                    it[isFavorite] = cancion.isFavorite
                    it[year] = cancion.year
                    it[country] = cancion.country
                    it[region] = cancion.region
                    it[artistName] = cancion.artistName
                    it[song] = cancion.song
                    it[artistGender] = cancion.artistGender
                    it[groupOrSolo] = cancion.groupOrSolo
                    it[place] = cancion.place
                    it[points] = cancion.points
                    it[isFinal] = cancion.isFinal
                    it[isSongInEnglish] = cancion.isSongInEnglish
                    it[songQuality] = cancion.songQuality
                    it[normalizedPoints] = cancion.normalizedPoints
                    it[energy] = cancion.energy
                    it[duration] = cancion.duration
                    it[acousticness] = cancion.acousticness
                    it[danceability] = cancion.danceability
                    it[tempo] = cancion.tempo
                    it[speechiness] = cancion.speechiness
                    it[key] = cancion.key
                    it[liveness] = cancion.liveness
                    it[timeSignature] = cancion.timeSignature
                    it[mode] = cancion.mode
                    it[loudness] = cancion.loudness
                    it[valence] = cancion.valence
                    it[happiness] = cancion.happiness
                }
            }
        }
        var menu = """
        Menu Principal:
        --------------------------
        1. Buscar canciones por nombre
        2. Buscar canciones por artista
        3. Mosrar todas las canciones favoritas
        4. Salir
    """.trimIndent()
        var sigue = true
        do {
            println(menu)
            val respuesta = readLine()!!
            when (respuesta) {
                "1" -> {
                    println("Ingrese parte del nombre de la cancion que desea buscar: ")
                    val busqueda = readLine()!!
                    for (cancion in Canciones.select { Canciones.song.like("%${busqueda}%") }) {
                        println("Id: ${cancion[Canciones.id]}: Nombre: ${cancion[Canciones.song]}")
                    }
                    println("Deseas agregar alguna a tus favoritos?")
                    val confirmar = readLine()!!.toString()
                    if (confirmar == "si") {
                        println("Cual? (escriba el id)")
                        val numero = readLine()!!.toInt()
                        for (c in Canciones.select { Canciones.id.eq(numero) }) {
                            c[Canciones.isFavorite] = true
                            CancionesFavoritas.insert {
                                it[isFavorite] = c[Canciones.isFavorite]
                                it[year] = c[Canciones.year]
                                it[country] = c[Canciones.country]
                                it[region] = c[Canciones.region]
                                it[artistName] = c[Canciones.artistName]
                                it[song] = c[Canciones.song]
                                it[artistGender] = c[Canciones.artistGender]
                                it[groupOrSolo] = c[Canciones.groupOrSolo]
                                it[place] = c[Canciones.place]
                                it[points] = c[Canciones.points]
                                it[isFinal] = c[Canciones.isFinal]
                                it[isSongInEnglish] = c[Canciones.isSongInEnglish]
                                it[songQuality] = c[Canciones.songQuality]
                                it[normalizedPoints] = c[Canciones.normalizedPoints]
                                it[energy] = c[Canciones.energy]
                                it[duration] = c[Canciones.duration]
                                it[acousticness] = c[Canciones.acousticness]
                                it[danceability] = c[Canciones.danceability]
                                it[tempo] = c[Canciones.tempo]
                                it[speechiness] = c[Canciones.speechiness]
                                it[key] = c[Canciones.key]
                                it[liveness] = c[Canciones.liveness]
                                it[timeSignature] = c[Canciones.timeSignature]
                                it[mode] = c[Canciones.mode]
                                it[loudness] = c[Canciones.loudness]
                                it[valence] = c[Canciones.valence]
                                it[happiness] = c[Canciones.happiness]
                            }
                        }
                    }

                }
                "2" -> {
                    println("Ingrese parte del nombre del artista que desea buscar: ")
                    val busqueda = readLine()!!.toString()
                    for (cancion in Canciones.select { Canciones.artistName.like("%${busqueda}%") }) {
                        println("Id: ${cancion[Canciones.id]}: Nombre: ${cancion[Canciones.song]}")
                    }
                    println("Deseas agregar alguna a tus favoritos?")
                    val r = readLine()!!
                    if (r == "si") {
                        println("Cual?")
                        val numero = readLine()!!.toInt()
                        println(numero)
                        for (c in Canciones.select { Canciones.id.eq(numero) }) {
                            c[Canciones.isFavorite] = true
                            CancionesFavoritas.insert {
                                it[isFavorite] = c[Canciones.isFavorite]
                                it[year] = c[Canciones.year]
                                it[country] = c[Canciones.country]
                                it[region] = c[Canciones.region]
                                it[artistName] = c[Canciones.artistName]
                                it[song] = c[Canciones.song]
                                it[artistGender] = c[Canciones.artistGender]
                                it[groupOrSolo] = c[Canciones.groupOrSolo]
                                it[place] = c[Canciones.place]
                                it[points] = c[Canciones.points]
                                it[isFinal] = c[Canciones.isFinal]
                                it[isSongInEnglish] = c[Canciones.isSongInEnglish]
                                it[songQuality] = c[Canciones.songQuality]
                                it[normalizedPoints] = c[Canciones.normalizedPoints]
                                it[energy] = c[Canciones.energy]
                                it[duration] = c[Canciones.duration]
                                it[acousticness] = c[Canciones.acousticness]
                                it[danceability] = c[Canciones.danceability]
                                it[tempo] = c[Canciones.tempo]
                                it[speechiness] = c[Canciones.speechiness]
                                it[key] = c[Canciones.key]
                                it[liveness] = c[Canciones.liveness]
                                it[timeSignature] = c[Canciones.timeSignature]
                                it[mode] = c[Canciones.mode]
                                it[loudness] = c[Canciones.loudness]
                                it[valence] = c[Canciones.valence]
                                it[happiness] = c[Canciones.happiness]
                            }
                        }

                    }
                }
                "3" -> {
                    for (cancion in CancionesFavoritas.selectAll()) {
                        println(cancion)
                    }
                }
                "4" -> {
                    sigue = false
                }
            }
        } while (sigue)

    }
}
