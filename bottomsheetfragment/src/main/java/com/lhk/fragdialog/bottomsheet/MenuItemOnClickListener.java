package com.lhk.fragdialog.bottomsheet;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * Created by guorui.he on 2016/6/20.
 */
public abstract class MenuItemOnClickListener implements OnItemClickListener {

    private final String TAG = "MenuItemOnClickListener";

    private BottomMenuFragment bottomMenuFragment;

    public MenuItemOnClickListener(BottomMenuFragment bottomMenuFragment) {
        this.bottomMenuFragment = bottomMenuFragment;
    }

    public BottomMenuFragment getBottomMenuFragment() {
        return bottomMenuFragment;
    }

    public void setBottomMenuFragment(BottomMenuFragment bottomMenuFragment) {
        this.bottomMenuFragment = bottomMenuFragment;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, "onClick: ");
        if(bottomMenuFragment != null && bottomMenuFragment.isVisible()) {
            bottomMenuFragment.dismiss();
        }
        this.onClickMenuItem(parent, view, position, id);
    }

    public abstract void onClickMenuItem(AdapterView<?> parent, View view, int position, long id);
}
