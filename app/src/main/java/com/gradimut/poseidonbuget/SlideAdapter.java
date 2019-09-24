package com.gradimut.poseidonbuget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    // Setup list of images
    public int[] lst_images = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4
    };

    // Setup list of title
    public String[] lst_title = {
            "CHECK YOUR BUDGET",
            "COMPARE YOUR BUDGET",
            "CALCULATE YOUR BUDGET",
            "SPEND MONEY"

    };

    // Setup list of description.
    public String[] lst_description = {
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore ex odio odit quis ratione totam unde. Aperiam delectus deleniti dolore mollitia nihil, pariatur, provident quisquam quo, repellendus rerum saepe sint!",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore ex odio odit quis ratione totam unde. Aperiam delectus deleniti dolore mollitia nihil, pariatur, provident quisquam quo, repellendus rerum saepe sint!",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore ex odio odit quis ratione totam unde. Aperiam delectus deleniti dolore mollitia nihil, pariatur, provident quisquam quo, repellendus rerum saepe sint!",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore ex odio odit quis ratione totam unde. Aperiam delectus deleniti dolore mollitia nihil, pariatur, provident quisquam quo, repellendus rerum saepe sint!"

    };

    // Setup list of background color
    public int[] lst_color = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(11,188,212)
    };

    public SlideAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        // We define the number of page
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.slideview, container,false);
        LinearLayout layoutSlide = view.findViewById(R.id.slideLinearLayout);
        ImageView imgSlide = view.findViewById(R.id.slideImage);
        TextView txttitle = view.findViewById(R.id.txt_title);
        TextView description = view.findViewById(R.id.txtDescription);

        layoutSlide.setBackgroundColor(lst_color[position]);
        imgSlide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
