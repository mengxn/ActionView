package me.codego.example.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * EditText中Drawable加点击事件
 * Created by mengxn on 16-5-9.
 */
public class XEditText extends EditText {

    private OnDrawableClickListener onDrawableClickListener;

    public XEditText(Context context) {
        super(context);
    }
    public XEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnDrawableClickListener(OnDrawableClickListener onDrawableClickListener) {
        this.onDrawableClickListener = onDrawableClickListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (isUpOnDrawable(event)) {
                    return true;
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private boolean isUpOnDrawable(MotionEvent event) {
        if (onDrawableClickListener != null) {
            Drawable drawable = getCompoundDrawables()[0];
            if (drawable != null && event.getX() < drawable.getBounds().width() + getCompoundDrawablePadding() + getPaddingLeft()) {
                return onDrawableClickListener.onLeftDrawableClick(this);
            }
            drawable = getCompoundDrawables()[1];
            if (drawable != null && event.getY() < drawable.getBounds().height() + getCompoundDrawablePadding() + getPaddingTop()) {
                return onDrawableClickListener.onTopDrawableClick(this);
            }
            drawable = getCompoundDrawables()[2];
            if (drawable != null && event.getX() > getWidth() - drawable.getBounds().width() - getCompoundDrawablePadding() - getPaddingRight()) {
                return onDrawableClickListener.onRightDrawableClick(this);
            }
            drawable = getCompoundDrawables()[3];
            if (drawable != null && event.getY() > getWidth() - drawable.getBounds().height() - getCompoundDrawablePadding() - getPaddingBottom()) {
                return onDrawableClickListener.onBottomDrawableClick(this);
            }
        }
        return false;
    }

}
