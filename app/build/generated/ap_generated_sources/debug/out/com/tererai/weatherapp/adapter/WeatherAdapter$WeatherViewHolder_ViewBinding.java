// Generated code from Butter Knife. Do not modify!
package com.tererai.weatherapp.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.tererai.weatherapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WeatherAdapter$WeatherViewHolder_ViewBinding implements Unbinder {
  private WeatherAdapter.WeatherViewHolder target;

  @UiThread
  public WeatherAdapter$WeatherViewHolder_ViewBinding(WeatherAdapter.WeatherViewHolder target,
      View source) {
    this.target = target;

    target.dayText = Utils.findRequiredViewAsType(source, R.id.day_text, "field 'dayText'", TextView.class);
    target.sunImage = Utils.findRequiredViewAsType(source, R.id.sun_image, "field 'sunImage'", ImageView.class);
    target.temperatureText = Utils.findRequiredViewAsType(source, R.id.temperature_text, "field 'temperatureText'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WeatherAdapter.WeatherViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.dayText = null;
    target.sunImage = null;
    target.temperatureText = null;
  }
}
