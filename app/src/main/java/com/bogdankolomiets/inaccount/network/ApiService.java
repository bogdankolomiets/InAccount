package com.bogdankolomiets.inaccount.network;

import com.bogdankolomiets.inaccount.model.dto.RelationshipDTO;
import com.bogdankolomiets.inaccount.model.dto.UserDTO;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author bogdan
 * @version 1
 * @date 06.03.17
 */

public interface ApiService {
    @POST("oauth/access_token")
    @FormUrlEncoded
    Single<UserDTO> getAccessToken(@Field("client_id") String clientId,
                                   @Field("client_secret") String clientSecret,
                                   @Field("grant_type") String grantType,
                                   @Field("redirect_uri") String redirectUri,
                                   @Field("code") String code);

    @GET("tags/{tag-name}/media/recent")
    Observable<Void> getRecentlyTaggedMedia(@Path("tag-name") String tagName,
                                            @Field("access_token") String accessToken);

    @POST("media/{media-id}/likes")
    Observable<Void> likeMediaById(@Path("media-id") String id,
                                   @Field("access_token") String token);

    @POST("media/{media-id}/comments")
    Observable<Void> commentMediaById(@Path("media-id") String id,
                                      @Field("access_token") String token,
                                      @Field("text") String text);

    @POST("users/{user-id}/relationship?action=follow")
    Observable<RelationshipDTO> follow(@Path("user-id") String userId,
                                       @Field("access_token") String token);

    @POST("users/{user-id}/relationship?action=unfollow")
    Observable<RelationshipDTO> unfollow(@Path("user-id") String userId,
                                         @Field("access_token") String token);

}
