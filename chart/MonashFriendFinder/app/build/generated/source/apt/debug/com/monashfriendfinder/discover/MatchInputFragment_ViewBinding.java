// Generated code from Butter Knife. Do not modify!
package com.monashfriendfinder.discover;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.monashfriendfinder.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MatchInputFragment_ViewBinding implements Unbinder {
  private MatchInputFragment target;

  private View view2131689688;

  private View view2131689691;

  private View view2131689697;

  private View view2131689694;

  private View view2131689700;

  private View view2131689701;

  @UiThread
  public MatchInputFragment_ViewBinding(final MatchInputFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.age_switch, "field 'ageSwitch' and method 'editMatchInfo'");
    target.ageSwitch = Utils.castView(view, R.id.age_switch, "field 'ageSwitch'", SwitchCompat.class);
    view2131689688 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.editMatchInfo(Utils.castParam(p0, "onCheckedChanged", 0, "editMatchInfo", 0, SwitchCompat.class), p1);
      }
    });
    target.ageValue = Utils.findRequiredViewAsType(source, R.id.age_value, "field 'ageValue'", TextView.class);
    view = Utils.findRequiredView(source, R.id.gender_switch, "field 'genderSwitch' and method 'editMatchInfo'");
    target.genderSwitch = Utils.castView(view, R.id.gender_switch, "field 'genderSwitch'", SwitchCompat.class);
    view2131689691 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.editMatchInfo(Utils.castParam(p0, "onCheckedChanged", 0, "editMatchInfo", 0, SwitchCompat.class), p1);
      }
    });
    target.genderValue = Utils.findRequiredViewAsType(source, R.id.gender_value, "field 'genderValue'", TextView.class);
    view = Utils.findRequiredView(source, R.id.unit_switch, "field 'courseSwitch' and method 'editMatchInfo'");
    target.courseSwitch = Utils.castView(view, R.id.unit_switch, "field 'courseSwitch'", SwitchCompat.class);
    view2131689697 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.editMatchInfo(Utils.castParam(p0, "onCheckedChanged", 0, "editMatchInfo", 0, SwitchCompat.class), p1);
      }
    });
    target.courseValue = Utils.findRequiredViewAsType(source, R.id.unit_value, "field 'courseValue'", TextView.class);
    view = Utils.findRequiredView(source, R.id.nationality_switch, "field 'nationalitySwitch' and method 'editMatchInfo'");
    target.nationalitySwitch = Utils.castView(view, R.id.nationality_switch, "field 'nationalitySwitch'", SwitchCompat.class);
    view2131689694 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.editMatchInfo(Utils.castParam(p0, "onCheckedChanged", 0, "editMatchInfo", 0, SwitchCompat.class), p1);
      }
    });
    target.nationalityValue = Utils.findRequiredViewAsType(source, R.id.nationality_value, "field 'nationalityValue'", TextView.class);
    view = Utils.findRequiredView(source, R.id.studymode_switch, "field 'studymodeSwitch' and method 'editMatchInfo'");
    target.studymodeSwitch = Utils.castView(view, R.id.studymode_switch, "field 'studymodeSwitch'", SwitchCompat.class);
    view2131689700 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.editMatchInfo(Utils.castParam(p0, "onCheckedChanged", 0, "editMatchInfo", 0, SwitchCompat.class), p1);
      }
    });
    target.studymodeValue = Utils.findRequiredViewAsType(source, R.id.studymode_value, "field 'studymodeValue'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_start_condition_match, "method 'showMatchedResult'");
    view2131689701 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showMatchedResult();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MatchInputFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ageSwitch = null;
    target.ageValue = null;
    target.genderSwitch = null;
    target.genderValue = null;
    target.courseSwitch = null;
    target.courseValue = null;
    target.nationalitySwitch = null;
    target.nationalityValue = null;
    target.studymodeSwitch = null;
    target.studymodeValue = null;

    ((CompoundButton) view2131689688).setOnCheckedChangeListener(null);
    view2131689688 = null;
    ((CompoundButton) view2131689691).setOnCheckedChangeListener(null);
    view2131689691 = null;
    ((CompoundButton) view2131689697).setOnCheckedChangeListener(null);
    view2131689697 = null;
    ((CompoundButton) view2131689694).setOnCheckedChangeListener(null);
    view2131689694 = null;
    ((CompoundButton) view2131689700).setOnCheckedChangeListener(null);
    view2131689700 = null;
    view2131689701.setOnClickListener(null);
    view2131689701 = null;
  }
}
