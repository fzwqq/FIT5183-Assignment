// Generated code from Butter Knife. Do not modify!
package com.monashfriendfinder.me;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.monashfriendfinder.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MeFragment_ViewBinding implements Unbinder {
  private MeFragment target;

  private View view2131689705;

  private View view2131689702;

  private View view2131689703;

  private View view2131689704;

  @UiThread
  public MeFragment_ViewBinding(final MeFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.exit_account_finish, "method 'exitAccount'");
    view2131689705 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exitAccount();
      }
    });
    view = Utils.findRequiredView(source, R.id.update_personal_information_finish, "method 'updatePersonalInfo'");
    view2131689702 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.updatePersonalInfo();
      }
    });
    view = Utils.findRequiredView(source, R.id.visit_bar_chart, "method 'visitBarChart'");
    view2131689703 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.visitBarChart();
      }
    });
    view = Utils.findRequiredView(source, R.id.favorite_units_pie_graph, "method 'favoriteUnitsPieGraph'");
    view2131689704 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.favoriteUnitsPieGraph();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131689705.setOnClickListener(null);
    view2131689705 = null;
    view2131689702.setOnClickListener(null);
    view2131689702 = null;
    view2131689703.setOnClickListener(null);
    view2131689703 = null;
    view2131689704.setOnClickListener(null);
    view2131689704 = null;
  }
}
