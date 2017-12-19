package com.example.pageindicator;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pageindicator.adapter.CustomViewPageAdapter;
import com.example.pageindicator.model.Foo;
import com.hold1.pagertabsindicator.PagerTabsIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Foo> foos = new ArrayList<>();
    ViewPager viewPager;
    PagerTabsIndicator tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        viewPager = findViewById(R.id.vpViewPager);
        tabs = findViewById(R.id.tabsIndicator);
        viewPager.setAdapter(new CustomViewPageAdapter(foos, this));
        tabs.setViewPager(viewPager);
    }

    private void init() {
        Foo foo = new Foo(R.drawable.ic_android_black_24dp, "Page 1");
        foos.add(foo);

        foo = new Foo(R.drawable.ic_android_black_24dp, "Page 2");
        foos.add(foo);

        foo = new Foo(R.drawable.ic_dashboard_black_24dp, "Page 3");
        foos.add(foo);

        foo = new Foo(R.drawable.ic_android_black_24dp, "Page 4");
        foos.add(foo);

        foo = new Foo(R.drawable.ic_android_black_24dp, "Page 4");
        foos.add(foo);
    }
}
