package registration.testing.firebase.com.retrofitmvp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import registration.testing.firebase.com.retrofitmvp.Core.Presenter;
import registration.testing.firebase.com.retrofitmvp.Model.Forecast;
import registration.testing.firebase.com.retrofitmvp.R;
import registration.testing.firebase.com.retrofitmvp.utils.DateTimeUtils;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.MyViewHolder> {
    private Context context;
    private Presenter mPresenter;
    private List<Forecast> forecast = new ArrayList<>();

    public ForecastAdapter(Context context, List<Forecast> forecast, Presenter mPresenter) {
        this.context = context;
        this.forecast = forecast;
        this.mPresenter = mPresenter;
    }

    @Override
    public ForecastAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view, mPresenter);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapter.MyViewHolder holder, int position) {
        holder.textDt.setText(DateTimeUtils.convertToReadableTime(forecast.get(position).getDt()));
        holder.textDay.setText(forecast.get(position).getTemp().getDay().toString());
        holder.textMin.setText(forecast.get(position).getTemp().getMin().toString());
        holder.textMax.setText(forecast.get(position).getTemp().getMax().toString());
        holder.textWeather.setText(forecast.get(position).getWeather().get(0).getDescription());


    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textDt;
        TextView textDay;
        TextView textMin;
        TextView textMax;
        TextView textWeather;
        Presenter mPresenter;

        public MyViewHolder(View itemView, Presenter mPresenter) {
            super(itemView);
            this.mPresenter = mPresenter;
            textDt = (TextView) itemView.findViewById(R.id.dt);
            textDay = (TextView) itemView.findViewById(R.id.day);
            textMin = (TextView) itemView.findViewById(R.id.min);
            textMax = (TextView) itemView.findViewById(R.id.max);
            textWeather = (TextView) itemView.findViewById(R.id.weather);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mPresenter.clickItem(DateTimeUtils.convertToReadableTime(forecast.get(getAdapterPosition()).getDt()));
        }
    }
}
