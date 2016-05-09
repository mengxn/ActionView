package me.codego.example.view;

import android.view.View;

/**
 * Created by mengxn on 16-5-9.
 */
public interface OnDrawableClickListener {
    /**
     * 左侧drawable被点击
     * @param view
     * @return true已完全处理，不需要调用父类
     */
    boolean onLeftDrawableClick(View view);

    /**
     * 左侧drawable被点击
     * @param view
     * @return true已完全处理，不需要调用父类
     */
    boolean onRightDrawableClick(View view);

    boolean onTopDrawableClick(View view);

    boolean onBottomDrawableClick(View view);
}
