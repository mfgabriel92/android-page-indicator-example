package com.example.pageindicator;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.hold1.pagertabsindicator.TabView;

public class TabViewItem extends TabView {

    private TextView tabTabName;
    private ImageView tabTabIcon;
    private int activeColor;
    private int tabColor;

    public TabViewItem(Context context, String title, int imageId, int tabColor, int activeColor) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.custom_item, this);

        tabTabName = findViewById(R.id.tabTabName);
        tabTabIcon = findViewById(R.id.tabTabIcon);

        tabTabName.setText(title);
        tabTabIcon.setImageResource(imageId);

        this.tabColor = tabColor;
        this.activeColor = activeColor;
        this.tabTabIcon.setColorFilter(tabColor);
        this.tabTabName.setTextColor(tabColor);
    }

    @Override
    public void onOffset(float offset) {
        this.tabTabIcon.setColorFilter(getColorWithOpacity(activeColor, (int) (100 * offset)));
        this.tabTabName.setTextColor(mixTwoColors(activeColor, tabColor, offset));
    }

    private int mixTwoColors(int c1, int c2, float offset) {
        byte ALPHA_CHANNEL = 24;
        byte RED_CHANNEL = 16;
        byte GREEN_CHANNEL = 8;
        byte BLUE_CHANNEL = 0;

        float inverseAmount = 1.0f - offset;

        int a = ((int) (((float) (c1 >> ALPHA_CHANNEL & 0xff) * offset) + ((float) (c2 >> ALPHA_CHANNEL & 0xff) * inverseAmount))) & 0xff;
        int r = ((int) (((float) (c1 >> RED_CHANNEL & 0xff) * offset) + ((float) (c2 >> RED_CHANNEL & 0xff) * inverseAmount))) & 0xff;
        int g = ((int) (((float) (c1 >> GREEN_CHANNEL & 0xff) * offset) + ((float) (c2 >> GREEN_CHANNEL & 0xff) * inverseAmount))) & 0xff;
        int b = ((int) (((float) (c1 & 0xff) * offset) + ((float) (c2 & 0xff) * inverseAmount))) & 0xff;

        return a << ALPHA_CHANNEL | r << RED_CHANNEL | g << GREEN_CHANNEL | b << BLUE_CHANNEL;
    }

    private int getColorWithOpacity(int activeColor, int i) {
        return Color.argb(i * 255/100, Color.red(activeColor), Color.green(activeColor), Color.blue(activeColor));
    }
}
