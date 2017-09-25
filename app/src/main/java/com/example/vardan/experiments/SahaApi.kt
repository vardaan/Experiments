package com.myntra.android.saha

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import rx.Observable

interface SahaApi {

    @POST("conversations")
    fun createConversation(@Body request: CreateConversationRequest): Observable<Void>

    @GET("conversations/user/{userId}")
    fun getConversation(@Path("userId") userId: String): Observable<ConversationListWrapper>


    @GET("conversations/{id}/user/{userId}")
    fun getConversationId(@Path("id") id: String,
                          @Path("userId") userId: String): Observable<ConversationListWrapper>


    @POST("conversations/{conversationId}/users/{userid}")
    fun addUserToConversation(@Path("conversationId") conservationId: String,
                              @Path("userid") userId: String): Observable<GenericResponse>

    @POST("/conversations/{conversationId}/messages")
    fun addMessages(@Path("conversationId") conversationId: String): Observable<GenericResponse>

    @GET("/conversations/{conversationid}/messages?q:queryparam")
    fun getMessages(@Path("conversationid") conversationId: String)

}

data class ConversationListWrapper(val conversations: List<ConversationWrapper>)

data class CreateConversationRequest(val uidx: String,
                                     val userName: String,
                                     @SerializedName("context") val title: String,
                                     @SerializedName("contextAlias") val imageUrl: String)


data class GenericResponse(val responseCode: String, val responseMessage: String)

data class ConversationWrapper(@SerializedName("data") val conversations: List<ConversationAPI>)

data class ConversationAPI(val context: String, val conversationId: String, val contextAlias: String)
//{"context":"Hello","created_at":1506228428250,"conversationId":6,"members":["Vardan"],"roles":["owns"]}