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

  private View view7f08008f;

  @UiThread
  public ShowWeatherActivity_ViewBinding(ShowWeatherActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShowWeatherActivity_ViewBinding(final ShowWeatherActivity target, View source) {
    this.target = target;

    View view;
    target.daysRecyclerview = Utils.findRequiredViewAsType(source, R.id.temp_recyclerview, "field 'daysRecyclerview'", RecyclerView.class);
    target.txtCurrentTempHeader = Utils.findRequiredViewAsType(source, R.id.txtCurrentTemp, "field 'txtCurrentTempHeader'", TextView.class);
    target.txtNoData = Utils.findRequiredViewAsType(source, R.id.no_data, "field 'txtNoData'", TextView.class);
    target.txtCurrentConditions = Utils.findRequiredViewAsType(source, R.id.txtCurrentCondition, "field 'txtCurrentConditions'", TextView.class);
    target.summaryLayout = Utils.findRequiredViewAsType(source, R.id.summary_layout, "field 'summaryLayout'", ConstraintLayout.class);
    target.txtMinTemp = Utils.findRequiredViewAsType(source, R.id.min_temp_text, "field 'txtMinTemp'", TextView.class);
    target.txtCurrentTemp = Utils.findRequiredViewAsType(source, R.id.current_temp_text, "field 'txtCurrentTemp'", TextView.class);
    target.txtMaxTemp = Utils.findRequiredViewAsType(source, R.id.max_temp_text, "field 'txtMaxTemp'", TextView.class);
    target.txtCity = Utils.findRequiredViewAsType(source, R.id.txtCity, "field 'txtCity'", TextView.class);
    target.imgMainIcon = Utils.findRequiredViewAsType(source, R.id.imgMainIcon, "field 'imgMainIcon'", ImageView.class);
    target.showWeatherView = Utils.findRequiredViewAsType(source, R.id.showWeatherView, "field 'showWeatherView'", ConstraintLayout.class);
    view = Utils.findRequiredView(source, R.id.imgFavorite, "field 'imgFavorite' and method 'saveFavorites'");
    target.imgFavorite = Utils.castView(view, R.id.imgFavorite, "field 'imgFavorite'", ImageView.class);
    view7f08008f = view;
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
    target.txtCurrentTempHeader = null;
    target.txtNoData = null;
    target.txtCurrentConditions = null;
    target.summaryLayout = null;
    target.txtMinTemp = null;
    target.txtCurrentTemp = null;
    target.txtMaxTemp = null;
    target.txtCity = null;
    target.imgMainIcon = null;
    target.showWeatherView = null;
    target.imgFavorite = null;

    view7f08008f.setOnClickListener(null);
    view7f08008f = null;
  }
}
