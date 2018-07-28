package registration.testing.firebase.com.retrofitmvp.Core;

import android.content.Context;

import java.util.List;

import registration.testing.firebase.com.retrofitmvp.Model.Forecast;

public class Presenter implements GetDataContract.Presenter, GetDataContract.onGetDataListener {
    private GetDataContract.View mGetDataView;
    private Interactor mInteractor;

    public Presenter(GetDataContract.View mGetDataView) {
        this.mGetDataView = mGetDataView;
        mInteractor = new Interactor(this);
    }

    @Override
    public void getDataFromURL(Context context, String url) {
        mInteractor.initRetrofitCall(context, url);
    }

    @Override
    public void clickItem(String date) {
        mGetDataView.showToast(date);
    }


    @Override
    public void onSuccess(List<Forecast> forecasts) {
        mGetDataView.onGetDataSuccess(forecasts);
    }

    @Override
    public void onFailure(String message) {
        mGetDataView.onGetDataFailure(message);
    }

    @Override
    public void onLoading() {
        mGetDataView.showLoading();
    }
}
