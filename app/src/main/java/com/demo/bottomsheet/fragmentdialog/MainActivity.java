package com.demo.bottomsheet.fragmentdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.lhk.fragdialog.bottomsheet.BottomMenuFragment;
import com.lhk.fragdialog.bottomsheet.MenuItem;
import com.lhk.fragdialog.bottomsheet.MenuItemOnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private List<MenuItem> menuItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_bottom_pop_fragment_menu = (Button) this.findViewById(R.id.btn_bottom_pop_fragment_menu);
        btn_bottom_pop_fragment_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
                menuItemList.clear();
                for (int i=0;i<10;i++){
                    MenuItem menuItem = new MenuItem();
                    menuItem.setText("菜单"+i);
                    menuItemList.add(menuItem);
                }

                bottomMenuFragment.setMenuItems(menuItemList);
                bottomMenuFragment.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment) {
                    @Override
                    public void onClickMenuItem(AdapterView<?> parent, View view, int position, long id) {
                        Log.i("onClickMenuItem", "onClickMenuItem: "+menuItemList.get(position).getText());
                    }
                });
                bottomMenuFragment.show(getFragmentManager(), "BottomMenuFragment");
            }
        });


    }
}
