package me.codego.example.view;

import android.view.View;

/**
 * Created by mengxn on 16-5-9.
 */
public class SimpleDrawableClickListener implements OnDrawableClickListener {

    @Override
    public boolean onLeftDrawableClick(View view) {
        return false;
    }

    @Override
    public boolean onRightDrawableClick(View view) {
        return false;
    }

    @Override
    public boolean onTopDrawableClick(View view) {
        return false;
    }

    @Override
    public boolean onBottomDrawableClick(View view) {
        return false;
    }
}
