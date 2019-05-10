// Generated code from Butter Knife. Do not modify!
package com.monashfriendfinder.discover;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.monashfriendfinder.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MatchFriendDetailActivity_ViewBinding implements Unbinder {
  private MatchFriendDetailActivity target;

  private View view2131689619;

  private View view2131689627;

  @UiThread
  public MatchFriendDetailActivity_ViewBinding(MatchFriendDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MatchFriendDetailActivity_ViewBinding(final MatchFriendDetailActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.back, "method 'cilckBack'");
    target.back = Utils.castView(view, R.id.back, "field 'back'", TextView.class);
    view2131689619 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cilckBack();
      }
    });
    view = Utils.findRequiredView(source, R.id.add_to_friendlist, "field 'add_to_friendlist' and method 'addToFriendList'");
    target.add_to_friendlist = Utils.castView(view, R.id.add_to_friendlist, "field 'add_to_friendlist'", TextView.class);
    view2131689627 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addToFriendList();
      }
    });
    target.username = Utils.findRequiredViewAsType(source, R.id.tv_username, "field 'username'", TextView.class);
    target.gender = Utils.findRequiredViewAsType(source, R.id.tv_gender, "field 'gender'", TextView.class);
    target.DoB = Utils.findRequiredViewAsType(source, R.id.tv_DoB, "field 'DoB'", TextView.class);
    target.unit = Utils.findRequiredViewAsType(source, R.id.tv_unit, "field 'unit'", TextView.class);
    target.nationality = Utils.findRequiredViewAsType(source, R.id.tv_nationality, "field 'nationality'", TextView.class);
    target.studyMode = Utils.findRequiredViewAsType(source, R.id.tv_studymode, "field 'studyMode'", TextView.class);
    target.favoriteMovie = Utils.findRequiredViewAsType(source, R.id.tv_favoriteMovie, "field 'favoriteMovie'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MatchFriendDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.back = null;
    target.add_to_friendlist = null;
    target.username = null;
    target.gender = null;
    target.DoB = null;
    target.unit = null;
    target.nationality = null;
    target.studyMode = null;
    target.favoriteMovie = null;

    view2131689619.setOnClickListener(null);
    view2131689619 = null;
    view2131689627.setOnClickListener(null);
    view2131689627 = null;
  }
}
