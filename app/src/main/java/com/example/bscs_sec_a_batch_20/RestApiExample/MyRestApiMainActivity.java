package com.example.bscs_sec_a_batch_20.RestApiExample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bscs_sec_a_batch_20.R;
import com.example.bscs_sec_a_batch_20.RestApiExample.MyPostModel;
import com.example.bscs_sec_a_batch_20.RestApiExample.MyRestAdapter;
import com.example.bscs_sec_a_batch_20.RestApiExample.MyRetrofitConnection;
import com.example.bscs_sec_a_batch_20.RestApiExample.MyRetrofitInter;
import com.example.bscs_sec_a_batch_20.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRestApiMainActivity extends AppCompatActivity {
    MyRetrofitInter apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rest_api_main);
        recyclerView = findViewById(R.id.myrestrecyclerview);
        apiInterface = MyRetrofitConnection.getMyRetrofit().create(MyRetrofitInter.class);
        //GetAllPosts();
        //GetComments();
        //GetCommentsbyID();
        //GetCommentsbyQuery();
     //   GetCommentsbyQuery2();
       CreatePost();



    }

    private void CreatePost() {

    MyPostModel postModel = new MyPostModel(10,5,"TitleofMyPost","Body of my post");
    //apiInterface.createPost(postModel);
    Call<MyPostModel>myPost=apiInterface.createPost(postModel);

    myPost.enqueue(new Callback<MyPostModel>() {
        @Override
        public void onResponse(Call<MyPostModel> call, Response<MyPostModel> response) {

            Log.d("TAG","  "+response.body().getUserId()
            +"\n"+response.body().getId()
                    +"\n  " +response.body().getTitle()

            );
        }

        @Override
        public void onFailure(Call<MyPostModel> call, Throwable t) {

        }
    });
    }

    private void GetCommentsbyQuery2() {
        apiInterface.getCommentsbyQuery2(3,"id","desc").enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if (response.body().size()>0)
                {
                    Log.d("TAG","Comments Data");
                    for (MyCommentsModel myCommentsModel : response.body())
                    {
                        Log.d("TAG","id"+myCommentsModel.getPostId()+
                                "POST Name"+myCommentsModel.getName()+
                                "Email"+myCommentsModel.getEmail()
                        );
                    }
                }
                else {
                    Log.d("TAG","Failure");
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

            }
        });
    }

    private void GetComments() {
    apiInterface.getComments().enqueue(new Callback<List<MyCommentsModel>>() {
        @Override
        public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
            if (response.body().size()>0)
            {
                Log.d("TAG","Comments Data");
                for (MyCommentsModel myCommentsModel : response.body())
                {
                    Log.d("TAG","id"+myCommentsModel.getPostId()+
                            "POST Name"+myCommentsModel.getName()+
                            "Email"+myCommentsModel.getEmail()


                            );
                }
            }
            else {
                Log.d("TAG","Failure");
            }
        }

        @Override
        public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

        }
    });
    }

    private void GetCommentsbyID() {
        apiInterface.getCommentsbyID(3).enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if (response.body().size()>0)
                {
                    Log.d("TAG","Comments Data");
                    for (MyCommentsModel myCommentsModel : response.body())
                    {
                        Log.d("TAG","id"+myCommentsModel.getPostId()+
                                "POST Name"+myCommentsModel.getName()+
                                "Email"+myCommentsModel.getEmail()
                        );
                    }
                }
                else {
                    Log.d("TAG","Failure");
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

            }
        });
    }

    private void GetCommentsbyQuery() {
        apiInterface.getMyCommentsByQuery(3).enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if (response.body().size()>0)
                {
                    Log.d("TAG","Comments Data");
                    for (MyCommentsModel myCommentsModel : response.body())
                    {
                        Log.d("TAG","id"+myCommentsModel.getPostId()+
                                "POST Name"+myCommentsModel.getName()+
                                "Email"+myCommentsModel.getEmail()
                        );
                    }
                }
                else {
                    Log.d("TAG","Failure");
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

            }
        });
    }


    private void GetAllPosts() {
        apiInterface.getPosts().enqueue(new Callback<List<MyPostModel>>() {
            @Override
            public void onResponse(Call<List<MyPostModel>> call, Response<List<MyPostModel>> response) {
                if(response.body().size()>0)
                {
                    Log.d("TAG","DATA Retrieved");
                    List<MyPostModel> list = response.body();
                    MyRestAdapter adapter = new MyRestAdapter(list,MyRestApiMainActivity.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyRestApiMainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                }
                else
                {
                    Log.d("TAG","List is EMPTY!");
                }
            }

            @Override
            public void onFailure(Call<List<MyPostModel>> call, Throwable t) {
                Log.d("TAG","FAILURE");

            }
        });
    }
}