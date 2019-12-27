package nyc.ignitelabs.civicduty.address.data.dataprovider

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://www.googleapis.com/"

private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

private val auth: CivicApiAuthInterceptor = CivicApiAuthInterceptor()

private val httpClient = OkHttpClient.Builder().addInterceptor(logging)
    .addInterceptor(auth)

val webservice: RepresenativesWebService by lazy {

    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .baseUrl(BASE_URL)
        .build()
        .create(RepresenativesWebService::class.java)
}