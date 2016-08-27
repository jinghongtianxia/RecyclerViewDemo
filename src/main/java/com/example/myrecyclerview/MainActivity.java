package com.example.myrecyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private ArrayList<String> arrayList;
    private ViewGroup mainLayout;
    private int[] image = {R.drawable.bubble1, R.drawable.bubble2, R.drawable.bubble3,
            R.drawable.bubble4, R.drawable.bubble5, R.drawable.bubble6, R.drawable.bubble7, R.drawable.bubble8, R.drawable.bubble9, R.drawable.bubble10, R.drawable.bubble11,
            R.drawable.bubble12, R.drawable.bubble13, R.drawable.bubble14, R.drawable.bubble15,R.drawable.bubble16,R.drawable.bubble17,R.drawable.bubble18,R.drawable.bubble19,
    R.drawable.bubble20,R.drawable.bubble21};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<String>();
        init();
        recyclerView = ((RecyclerView) findViewById(R.id.main_recyclerView));
        //LinearLayoutManager布局
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
//        GridLayoutManager布局
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //分割线
//        recyclerView.addItemDecoration(new MyItemDecoration(this, MyItemDecoration.VERTICAL_LIST));
        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
    }

    public void init() {
        for (int i = 1; i < 101; i++) {
            StringBuilder stringBuilder = new StringBuilder("内容");
            stringBuilder.append(i);
            arrayList.add(String.valueOf(stringBuilder));
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = View.inflate(MainActivity.this, R.layout.item_layout, null);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
//            holder.itemText.setText(arrayList.get(position));
//            ViewGroup.LayoutParams layoutParams = holder.itemText.getLayoutParams();
//            layoutParams.height = ((int) (Math.random() * 100) + 400);
//            System.out.println(layoutParams.height);
            holder.itemImageView.getLayoutParams().height = ((int)(Math.random()*100+400));
            holder.itemImageView.setImageResource(image[position]);
        }

        @Override
        public int getItemCount() {
            return image.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView itemText;
            private ImageView itemImageView;

            public MyViewHolder(View itemView) {
                super(itemView);
                itemText = ((TextView) itemView.findViewById(R.id.item_text));
                itemImageView = (ImageView) itemView.findViewById(R.id.item_iamge);
            }
        }
    }

}
