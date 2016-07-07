package me.codego.view;

import android.view.View;

/**
 * Created by mengxn on 16-5-9.
 */
public interface OnActionClickListener {

    /**
     * action点击回调
     * @param action
     * @param view
     * @return
     */
    boolean onActionClick(Action action, View view);

    enum Action {
        LEFT(0), TOP(1), RIGHT(2), BOTTOM(3);

        private int direct;

        Action(int direct) {
            this.direct = direct;
        }

        public Action build(int direct) {
            for (Action action : values()) {
                if (action.direct == direct) {
                    return action;
                }
            }
            return null;
        }
    }

}
