// Generated code from Butter Knife. Do not modify!
package com.monashfriendfinder.friends;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.monashfriendfinder.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FriendListFragment_ViewBinding implements Unbinder {
  private FriendListFragment target;

  private View view2131689628;

  @UiThread
  public FriendListFragment_ViewBinding(final FriendListFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.change_map_view, "method 'changeMapView'");
    view2131689628 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.changeMapView();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131689628.setOnClickListener(null);
    view2131689628 = null;
  }
}
