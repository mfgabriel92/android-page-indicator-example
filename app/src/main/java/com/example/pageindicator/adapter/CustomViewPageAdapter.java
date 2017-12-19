package com.example.pageindicator.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pageindicator.R;
import com.example.pageindicator.TabViewItem;
import com.example.pageindicator.model.Foo;
import com.hold1.pagertabsindicator.TabView;
import com.hold1.pagertabsindicator.TabViewProvider;

import java.util.List;

public class CustomViewPageAdapter extends PagerAdapter implements TabViewProvider.CustomView {
    List<Foo> foos;
    Context context;

    public CustomViewPageAdapter(List<Foo> foos, Context context) {
        this.foos = foos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return foos.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.layout_item, container, false);

        TextView tvTextView = itemView.findViewById(R.id.tvTextView);
        tvTextView.setText(foos.get(position).getTitle());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + (position + 1);
    }

    @Override
    public View getView(int i) {
        return new TabViewItem(context, foos.get(i).getTitle(), foos.get(i).getId(), 0xFF363636, 0xFFFF0000);
    }
}