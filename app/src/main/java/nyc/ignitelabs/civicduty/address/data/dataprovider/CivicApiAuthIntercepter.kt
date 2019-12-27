package nyc.ignitelabs.civicduty.address.data.dataprovider


import nyc.ignitelabs.civicduty.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class CivicApiAuthInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        val url: HttpUrl = request
            .url
            .newBuilder()
            .addQueryParameter(
                API_KEY,
                BuildConfig.CIVIC_API_KEY
            )
            .build()

        request = request
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }

    companion object {
        //TODO: remove from repo
        private const val API_KEY = "key"
    }
}