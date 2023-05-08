package com.example.bscs_sec_a_batch_20.RestApiExample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyRetrofitInter {
    @GET("posts")
    Call<List<MyPostModel>> getPosts();


    @GET("posts/1/comments")
    Call<List<MyCommentsModel>> getComments();

    @GET("posts/{id}/comments")
   Call<List<MyCommentsModel>> getComments(@Path("id")int id);

    @GET("posts/{id}/comments")
    Call<List<MyCommentsModel>> getCommentsbyID(@Path("id")int id);


    @GET("comments")
    Call<List<MyCommentsModel>> getMyCommentsByQuery(@Query("postId") int id);

    @GET("comments")
    Call<List<MyCommentsModel>> getCommentsbyQuery2(@Query("postId") int id,
                                                    @Query("_sort") String sort,
                                                    @Query("_order") String orderby
                                                    );




    @POST("posts")
    Call<MyPostModel> createPost(@Body MyPostModel post);




}
