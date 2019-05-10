// Generated code from Butter Knife. Do not modify!
package com.monashfriendfinder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterImproveInfo_ViewBinding implements Unbinder {
  private RegisterImproveInfo target;

  private View view2131689658;

  @UiThread
  public RegisterImproveInfo_ViewBinding(RegisterImproveInfo target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterImproveInfo_ViewBinding(final RegisterImproveInfo target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.improve_personal_information_finish, "field 'finish' and method 'submitRegister'");
    target.finish = Utils.castView(view, R.id.improve_personal_information_finish, "field 'finish'", TextView.class);
    view2131689658 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submitRegister();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterImproveInfo target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.finish = null;

    view2131689658.setOnClickListener(null);
    view2131689658 = null;
  }
}
