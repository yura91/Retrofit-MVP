package registration.testing.firebase.com.retrofitmvp.Core;

import android.content.Context;

import java.util.List;

import registration.testing.firebase.com.retrofitmvp.Model.Forecast;

public interface GetDataContract {
    interface View {
        void onGetDataSuccess(List<Forecast> forecast);

        void onGetDataFailure(String message);

        void showToast(String mesDate);

        void showLoading();
    }

    interface Presenter {
        void getDataFromURL(Context context, String url);

        void clickItem(String date);
    }

    interface Interactor {
        void initRetrofitCall(Context context, String url);
    }

    interface onGetDataListener {
        void onSuccess(List<Forecast> forecast);

        void onFailure(String message);

        void onLoading();
    }
}
