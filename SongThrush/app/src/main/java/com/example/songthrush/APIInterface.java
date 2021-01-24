package com.example.songthrush;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/v1/me")
    Call<UserProfile> profile();

    @GET("/v1/artists/{id}")
    Call<Artist> getArtist(@Path(value = "id", encoded = true)String id);

    @GET("/v1/browse/categories")
    Call<Category> getCategories(@Query("locale") String locale);

    @GET("/v1/browse/categories/{category_id}/playlists")
    Call<Playlists> getCategoryPlaylist(@Path(value = "category_id", encoded = true) String id, @Query("country") String locale);

    @GET("/v1/playlists/{playlist_id}/tracks")
    Call<TracksByPlaylist> getTracksByPlaylists(@Path(value = "playlist_id",encoded = true)String id);

    @GET("/v1/browse/new-releases")
    Call<Object> getNewRelease(@Query("country") String locale);

    @GET("/v1/artists/{id}/top-tracks?market=IN")
    Call<Object> getArtistTopTrack(@Path(value = "id", encoded = true)String id);

}