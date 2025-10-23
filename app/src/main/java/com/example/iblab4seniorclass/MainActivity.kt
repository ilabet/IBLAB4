import TAG.Headers
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iblab4seniorclass.Campground
import com.example.iblab4seniorclass.CampgroundAdapter
import kotlinx.serialization.decodeFromString
import org.json.JSONException

annotation class TAG {
    annotation class Headers
}

private val JsonHttpResponseHandler.JSON.jsonObject: Any
private val JsonHttpResponseHandler.JSON.jsonObject: Any
private const val TAG = "MainActivity"

// Note: You should load PARKS_API_KEY from BuildConfig or your properties utility
private val CAMPGROUND_URL =
    "https://developer.nps.gov/api/v1/campgrounds?api_key=${BuildConfig.PARKS_API_KEY}"

class BuildConfig {
    companion object {
        val PARKS_API_KEY: String
            get() {
                TODO()
            }
    }

}

class MainActivity : AppCompatActivity() {
    private val campgrounds = mutableListOf<Campground>()
    private lateinit var campgroundAdapter: CampgroundAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.id.activity_main)

        val campgroundsRecyclerView = findViewById<RecyclerView>(R.id.campgroundsRecyclerView)
        campgroundAdapter = CampgroundAdapter(this, campgrounds)
        campgroundsRecyclerView.adapter = campgroundAdapter
        campgroundsRecyclerView.layoutManager = LinearLayoutManager(this)

        val client = AsyncHttpClient()
        client.get(CAMPGROUND_URL, object : JsonHttpResponseHandler() {
            fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "Failed to fetch campgrounds: $statusCode")
            }
            fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON,
                CampgroundResponse: Any
            ) {
                Log.i(TAG, "Successfully fetched campgrounds: $json")
                try {
                    val parsedJson = get().decodeFromString(
                        CampgroundResponse.serializer(),
                        json.run { jsonObject.toString() }
                    )
                    parsedJson.data?.let { list ->
                        campgrounds.addAll(list)
                        campgroundAdapter.notifyDataSetChanged()
                    }
                } catch (e: JSONException) {
                    Log.e(TAG, "Exception: $e") as K
                }
            }

            private fun createJson() {
                TODO("Not yet implemented")
            }
        })
    }

    private fun AsyncHttpClient() {
        TODO("Not yet implemented")
    }
}

class R {
    constructor(activityMain: Any)

    companion object {
        val id: Any
    }

}

private operator fun Unit.get(campgroundUrl: String, handler: `<anonymous>`) {
    val todo = TODO("Not yet implemented")
}

annotation class `<anonymous>`

open class JsonHttpResponseHandler {

}

class AsyncHttpClient(val get: Any) {

}
