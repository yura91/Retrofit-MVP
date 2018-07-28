package registration.testing.firebase.com.retrofitmvp.Activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import registration.testing.firebase.com.retrofitmvp.Adapter.ForecastAdapter;
import registration.testing.firebase.com.retrofitmvp.Core.GetDataContract;
import registration.testing.firebase.com.retrofitmvp.Core.Presenter;
import registration.testing.firebase.com.retrofitmvp.Model.Forecast;
import registration.testing.firebase.com.retrofitmvp.R;

public class MainFragment extends Fragment implements GetDataContract.View {
    private Presenter mPresenter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ForecastAdapter forecastAdapter;
    ;
    ProgressBar progressBar;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mPresenter = new Presenter(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getDataFromURL(getContext(), "");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onGetDataSuccess(List<Forecast> forecast) {
        progressBar.setVisibility(View.GONE);
        forecastAdapter = new ForecastAdapter(getContext(), forecast, mPresenter);
        recyclerView.setAdapter(forecastAdapter);
    }

    @Override
    public void onGetDataFailure(String message) {
        progressBar.setVisibility(View.GONE);
        Log.d("Status", message);
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String mesDate) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), mesDate, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }
}
