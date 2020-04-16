package com.example.recyclerviewmvvm.data.network

import com.example.recyclerviewmvvm.data.models.Movie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface MoviesApi {

    @GET("movies")
    suspend fun getMovies(): Response<List<Movie>>


    companion object {
        operator fun invoke(): MoviesApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
                .client(getOkhttpInterceptor())//when you offline then comment this
                .build()
                .create(MoviesApi::class.java)
        }

        //okhttp response interceptor
        fun getOkhttpInterceptor(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor)
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build()
            return client as OkHttpClient
        }
    }
}
