package com.example.simeiling.dialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

/**
 * Created by simeiling on 2016/11/16.
 */
public class CustomDialog extends Dialog {
    public CustomDialog(Context context) {
        super(context, R.style.CustomDialog_style);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    static public class Builder {
        Context context;
        LayoutParam layoutParam;

        public Builder(Context context) {
            this.context = context;
            layoutParam = new LayoutParam();
        }

        public void setGravity(int gravity) {
            if (layoutParam != null)
                layoutParam.setGravity(gravity);
        }

        public void setHeight(int height) {
            if (layoutParam != null) {
                layoutParam.setHeight(height);
            }
        }

        public void setWidth(int width) {
            if (layoutParam != null) {
                layoutParam.setWidth(width);
            }
        }

        public void setView(View view) {
            if (layoutParam != null) {
                layoutParam.setContentView(view);
            }
        }

        public CustomDialog create() {
            CustomDialog dialog = new CustomDialog(context);

            dialog.setContentView(layoutParam.contentView);
            return dialog;
        }

        public void show() {
            CustomDialog dialog = create();
            dialog.show();
            if (layoutParam.width > 0) {

                dialog.getWindow().getDecorView().setMinimumWidth(layoutParam.width);
                dialog.getWindow().getAttributes().width = layoutParam.width;
            }
            if (layoutParam.height > 0) {

                dialog.getWindow().getAttributes().height = layoutParam.height;
                dialog.getWindow().getDecorView().setMinimumHeight(layoutParam.height);
            }
            dialog.getWindow().setGravity(layoutParam.gravity);
        }

    }

    static private class LayoutParam {
        int gravity;
        int height;
        int width;
        View contentView;

        public void setContentView(View contentView) {
            this.contentView = contentView;
        }


        public void setGravity(int gravity) {
            this.gravity = gravity;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }
}
