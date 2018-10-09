import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson


 data class Cancion (val isFavorite:Boolean= false, val year: String, val country: String, val region: String, val artistName: String,
               val song: String, val artistGender: String, val groupOrSolo: String, val place: String,
               val points: String, val isFinal: String, val isSongInEnglish: String, val songQuality: String,
               val normalizedPoints: String, val energy: String, val duration: String, val acousticness: String,
               val danceability: String, val tempo: String, val speechiness: String, val key:String, val liveness: String,
               val timeSignature: String, val mode:String, val loudness: String, val valence: String, val happiness: String){
     class CancionArrayDeserializer: ResponseDeserializable<Array<Cancion>>{
         override fun deserialize(contenido:String):Array<Cancion>?{
             return Gson().fromJson(contenido, Array<Cancion>::class.java)
         }
     }
}