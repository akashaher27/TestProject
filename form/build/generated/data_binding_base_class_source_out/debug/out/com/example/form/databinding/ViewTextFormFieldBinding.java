// Generated by view binder compiler. Do not edit!
package com.example.form.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.form.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ViewTextFormFieldBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextInputEditText etValue;

  @NonNull
  public final TextInputLayout tlTextField;

  private ViewTextFormFieldBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextInputEditText etValue, @NonNull TextInputLayout tlTextField) {
    this.rootView = rootView;
    this.etValue = etValue;
    this.tlTextField = tlTextField;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ViewTextFormFieldBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ViewTextFormFieldBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.view_text_form_field, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ViewTextFormFieldBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      TextInputEditText etValue = rootView.findViewById(R.id.etValue);
      if (etValue == null) {
        missingId = "etValue";
        break missingId;
      }
      TextInputLayout tlTextField = rootView.findViewById(R.id.tlTextField);
      if (tlTextField == null) {
        missingId = "tlTextField";
        break missingId;
      }
      return new ViewTextFormFieldBinding((ConstraintLayout) rootView, etValue, tlTextField);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
