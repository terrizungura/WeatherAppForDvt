// Generated code from Butter Knife. Do not modify!
package com.tererai.weatherapp.Controller;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.tererai.weatherapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShowWeatherActivity_ViewBinding implements Unbinder {
  private ShowWeatherActivity target;

  private View view7f08008d;

  @UiThread
  public ShowWeatherActivity_ViewBinding(ShowWeatherActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShowWeatherActivity_ViewBinding(final ShowWeatherActivity target, View source) {
    this.target = target;

    View view;
    target.daysRecyclerview = Utils.findRequiredViewAsType(source, R.id.temp_recyclerview, "field 'daysRecyclerview'", RecyclerView.class);
    target.currentTempHeader = Utils.findRequiredViewAsType(source, R.id.txtCurrentTemp, "field 'currentTempHeader'", TextView.class);
    target.noDataText = Utils.findRequiredViewAsType(source, R.id.no_data, "field 'noDataText'", TextView.class);
    target.currentConditions = Utils.findRequiredViewAsType(source, R.id.txtCurrentCondition, "field 'currentConditions'", TextView.class);
    target.summaryLayout = Utils.findRequiredViewAsType(source, R.id.summary_layout, "field 'summaryLayout'", ConstraintLayout.class);
    target.minTemp = Utils.findRequiredViewAsType(source, R.id.min_temp_text, "field 'minTemp'", TextView.class);
    target.currentTemp = Utils.findRequiredViewAsType(source, R.id.current_temp_text, "field 'currentTemp'", TextView.class);
    target.maxTemp = Utils.findRequiredViewAsType(source, R.id.max_temp_text, "field 'maxTemp'", TextView.class);
    target.txtCity = Utils.findRequiredViewAsType(source, R.id.txtCity, "field 'txtCity'", TextView.class);
    target.imgMainIcon = Utils.findRequiredViewAsType(source, R.id.imgMainIcon, "field 'imgMainIcon'", ImageView.class);
    target.showWeatherView = Utils.findRequiredViewAsType(source, R.id.showWeatherView, "field 'showWeatherView'", ConstraintLayout.class);
    view = Utils.findRequiredView(source, R.id.imgFavorite, "field 'imgFavorite' and method 'saveFavorites'");
    target.imgFavorite = Utils.castView(view, R.id.imgFavorite, "field 'imgFavorite'", ImageView.class);
    view7f08008d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.saveFavorites();
      }
    });

    Context context = source.getContext();
    target.fav = ContextCompat.getDrawable(context, R.drawable.fav);
  }

  @Override
  @CallSuper
  public void unbind() {
    ShowWeatherActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.daysRecyclerview = null;
    target.currentTempHeader = null;
    target.noDataText = null;
    target.currentConditions = null;
    target.summaryLayout = null;
    target.minTemp = null;
    target.currentTemp = null;
    target.maxTemp = null;
    target.txtCity = null;
    target.imgMainIcon = null;
    target.showWeatherView = null;
    target.imgFavorite = null;

    view7f08008d.setOnClickListener(null);
    view7f08008d = null;
  }
}
