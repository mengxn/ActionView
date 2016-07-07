package me.codego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * EditText中Drawable加点击事件
 * Created by mengxn on 16-5-9.
 */
public class ActionEditText extends EditText {

    private OnActionClickListener onActionClickListener;

    public ActionEditText(Context context) {
        super(context);
    }

    public ActionEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnActionClickListener(OnActionClickListener onActionClickListener) {
        this.onActionClickListener = onActionClickListener;
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

    /**
     * 点击事件是否处于drawable上
     *
     * @param event
     * @return
     */
    private boolean isUpOnDrawable(MotionEvent event) {
        if (onActionClickListener != null) {
            Drawable[] drawables = getCompoundDrawables();
            for (Drawable drawable : drawables) {
                if (drawable != null) {
                    if (event.getX() < drawable.getBounds().width() + getCompoundDrawablePadding() + getPaddingLeft()) {
                        return onActionClickListener.onActionClick(OnActionClickListener.Action.LEFT, this);
                    } else if (event.getY() < drawable.getBounds().height() + getCompoundDrawablePadding() + getPaddingTop()) {
                        return onActionClickListener.onActionClick(OnActionClickListener.Action.TOP, this);
                    } else if (event.getX() > getWidth() - drawable.getBounds().width() - getCompoundDrawablePadding() - getPaddingRight()) {
                        return onActionClickListener.onActionClick(OnActionClickListener.Action.RIGHT, this);
                    } else if (event.getY() > getHeight() - drawable.getBounds().height() - getCompoundDrawablePadding() - getPaddingBottom()) {
                        return onActionClickListener.onActionClick(OnActionClickListener.Action.BOTTOM, this);
                    }
                }
            }
        }
        return false;
    }

}
