package com.lhk.fragdialog.bottomsheet;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by guorui.he on 2016/6/19.
 */
public class MenuItemAdapter extends BaseAdapter{


    private Context context;//运行上下文

    private LayoutInflater listContainer;  //视图容器

    private List<MenuItem> menuItems;

    public MenuItemAdapter(Context _context, List<MenuItem> _menuItems){
        this.context = _context;
        this.listContainer = LayoutInflater.from(_context);
        this.menuItems = _menuItems;
    }
    @Override
    public int getCount() {
        return this.menuItems.size();
    }

    @Override
    public Object getItem(int position) {
        if(position >= menuItems.size() || position < 0) {
            return null;
        } else {
            return menuItems.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MenuHolder holder = null;
        if (convertView==null){
            convertView = listContainer.inflate(R.layout.menu_item, null);
            holder = new MenuHolder();
            holder.tv_title = (TextView) convertView.findViewById(R.id.menu_item);
            convertView.setTag(holder);
        } else {
            holder = (MenuHolder) convertView.getTag();
        }
        MenuItem menuItem = menuItems.get(position);
        holder.tv_title.setText(menuItem.getText());
        if(menuItems.size() == 1) {
            holder.tv_title.setBackgroundResource(R.drawable.bottom_menu_btn_selector);
        } else if(position == 0) {
            holder.tv_title.setBackgroundResource(R.drawable.bottom_menu_top_btn_selector);
        } else if(position < menuItems.size() - 1) {
            holder.tv_title.setBackgroundResource(R.drawable.bottom_menu_mid_btn_selector);
        } else {
            holder.tv_title.setBackgroundResource(R.drawable.bottom_menu_bottom_btn_selector);
        }
        if(menuItem.getStyle() == MenuItem.MenuItemStyle.STRESS) {
            holder.tv_title.setTextColor(ContextCompat.getColor(context, R.color.bottom_menu_btn_text_stress_color));
        } else if (menuItem.getStyle() == MenuItem.MenuItemStyle.COMMON){
            holder.tv_title.setTextColor(ContextCompat.getColor(context, R.color.bottom_menu_btn_text_commom_color));
        } else {
            holder.tv_title.setTextColor(ContextCompat.getColor(context, android.R.color.black));
        }

        return convertView;
    }

    private static class MenuHolder {
        TextView tv_title;
    }
}
