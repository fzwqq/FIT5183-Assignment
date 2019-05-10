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

public class Login_ViewBinding implements Unbinder {
  private Login target;

  private View view2131689615;

  private View view2131689614;

  @UiThread
  public Login_ViewBinding(Login target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Login_ViewBinding(final Login target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.register, "field 'register' and method 'newRegister'");
    target.register = Utils.castView(view, R.id.register, "field 'register'", TextView.class);
    view2131689615 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.newRegister();
      }
    });
    view = Utils.findRequiredView(source, R.id.submit, "field 'submit' and method 'submitLogin'");
    target.submit = Utils.castView(view, R.id.submit, "field 'submit'", TextView.class);
    view2131689614 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submitLogin();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    Login target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.register = null;
    target.submit = null;

    view2131689615.setOnClickListener(null);
    view2131689615 = null;
    view2131689614.setOnClickListener(null);
    view2131689614 = null;
  }
}
