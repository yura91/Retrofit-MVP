package registration.testing.firebase.com.retrofitmvp.Core;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import registration.testing.firebase.com.retrofitmvp.Model.Forecast;
import registration.testing.firebase.com.retrofitmvp.Model.ForecastRequest;
import registration.testing.firebase.com.retrofitmvp.Model.ForecastResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Intractor implements GetDataContract.Interactor {
    private GetDataContract.onGetDataListener mOnGetDatalistener;
    List<Forecast> forecasts = new ArrayList<>();

    public Intractor(GetDataContract.onGetDataListener mOnGetDatalistener) {
        this.mOnGetDatalistener = mOnGetDatalistener;
    }

    @Override
    public void initRetrofitCall(Context context, String url) {
        mOnGetDatalistener.onLoading();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ForecastRequest request = retrofit.create(ForecastRequest.class);
        retrofit2.Call<ForecastResponse> call = request.getForecast();
        call.enqueue(new retrofit2.Callback<ForecastResponse>() {
            @Override
            public void onResponse(retrofit2.Call<ForecastResponse> call, retrofit2.Response<ForecastResponse> response) {
                ForecastResponse jsonResponse = response.body();
                forecasts = jsonResponse.getList();
                mOnGetDatalistener.onSuccess(forecasts);
            }

            @Override
            public void onFailure(retrofit2.Call<ForecastResponse> call, Throwable t) {
                Log.v("Error", t.getMessage());
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });
    }
}
