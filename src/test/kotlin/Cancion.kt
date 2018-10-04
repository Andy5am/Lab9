import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson


 data class Cancion (val year: Int, val country: String, val region: String, val artistName: String,
               val song: String, val artistGender: String, val groupOrSolo: String, val place: Int,
               val points: Int, val isFinal: Int, val isSongInEnglish: Int, val songQuality: String,
               val normalizedPoints: String, val energy: String, val duration: String, val acousticness: String,
               val danceability: String, val tempo: String, val speechiness: String, val key:Int, val liveness: String,
               val timeSignature: Int, val mode:Int, val lougness: String, val valence: String, val happiness: String){
     class CancionArrayDeserializer: ResponseDeserializable<Array<Cancion>>{
         override fun deserialize(contenido:String):Array<Cancion>?{
             return Gson().fromJson(contenido, Array<Cancion>::class.java)
         }
     }
}