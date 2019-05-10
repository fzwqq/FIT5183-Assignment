// Generated code from Butter Knife. Do not modify!
package com.monashfriendfinder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditActivity_ViewBinding implements Unbinder {
  private EditActivity target;

  private View view2131689605;

  private View view2131689604;

  @UiThread
  public EditActivity_ViewBinding(EditActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EditActivity_ViewBinding(final EditActivity target, View source) {
    this.target = target;

    View view;
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
    target.content = Utils.findRequiredViewAsType(source, R.id.content, "field 'content'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_save, "method 'editSave'");
    view2131689605 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.editSave();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cancel, "method 'editCancel'");
    view2131689604 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.editCancel();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    EditActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.title = null;
    target.content = null;

    view2131689605.setOnClickListener(null);
    view2131689605 = null;
    view2131689604.setOnClickListener(null);
    view2131689604 = null;
  }
}
