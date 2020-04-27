package com.example.overlappingcardsslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.overlappingcardsslider.bean.SlideBean;
import com.example.overlappingcardsslider.slide.ItemConfig;
import com.example.overlappingcardsslider.slide.ItemTouchHelperCallback;
import com.example.overlappingcardsslider.slide.OnSlideListener;
import com.example.overlappingcardsslider.slide.SlideLayoutManager;

import java.util.ArrayList;
import java.util.List;
//instructions
  //To implement this in your project
  //1.paste bean and slide package
  //2.paste MyAdapter class
  //3.paste item_slide.xml layout
  //4.paste all the drawables
  //5.paste the code from MainActivity and activity_main.xml to your
  //  activity and respective layout file.
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ItemTouchHelper mItemTouchHelper;
    private ItemTouchHelperCallback mItemTouchHelperCallback;
    private SlideLayoutManager mSlideLayoutManager;
    private MyAdapter mAdapter;
    private List<SlideBean> mList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=findViewById(R.id.recycler_view);
        initRec();
        initListener();
    }
    private void initRec()
    {
        //calling add data method which will prepare our list with dummy data
        addData();
        mAdapter = new MyAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);

        //Here mItemTouchHelperCallback and mItemTouchHelper instances are for touch and slide events.
        mItemTouchHelperCallback = new ItemTouchHelperCallback(mRecyclerView.getAdapter(), mList);
        mItemTouchHelper = new ItemTouchHelper(mItemTouchHelperCallback);

        //SlideLayoutManager is a custom LayoutManager which extends LinearLayoutManager
        mSlideLayoutManager = new SlideLayoutManager(mRecyclerView, mItemTouchHelper);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setLayoutManager(mSlideLayoutManager);
    }

    private void addData(){
        int[] icons = {R.drawable.header_icon_1, R.drawable.header_icon_2, R.drawable.header_icon_3,
                R.drawable.header_icon_4, R.drawable.header_icon_1, R.drawable.header_icon_2};
        String[] titles = {"Acknowledging", "Belief", "Confidence", "Dreaming", "Happiness", "Confidence"};
        String[] says = {
                "Do one thing at a time, and do well.",
                "Keep on going never give up.",
                "Whatever is worth doing is worth doing well.",
                "I can because i think i can.",
                "Jack of all trades and master of none.",
                "Keep on going never give up.",
                "Whatever is worth doing is worth doing well.",
        };
        int[] bgs = {
                R.drawable.img_slide_1,
                R.drawable.img_slide_2,
                R.drawable.img_slide_3,
                R.drawable.img_slide_4,
                R.drawable.img_slide_5,
                R.drawable.img_slide_6
        };


        //SlideBean is a model class which contains some fields.
        for (int i = 0; i < 6; i++) {
            mList.add(new SlideBean(bgs[i],titles[i],icons[i],says[i]));
        }


    }

    //Listener for slide
    private void initListener() {
        mItemTouchHelperCallback.setOnSlideListener(new OnSlideListener() {
            @Override
            public void onSliding(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {
                if (direction == ItemConfig.SLIDING_LEFT) {
                    //when we slide the card to the left
                } else if (direction == ItemConfig.SLIDING_RIGHT) {
                    //when we slide the card to the right
                }
            }

            @Override
            public void onSlided(RecyclerView.ViewHolder viewHolder, Object o, int direction) {
                if (direction == ItemConfig.SLIDED_LEFT) {
                    //When card has been slided to the left

                } else if (direction == ItemConfig.SLIDED_RIGHT) {
                    //When card has been slided to the Right
                }
                int position = viewHolder.getAdapterPosition();

            }

            @Override
            public void onClear() {
                //This will be called when list will reach to its end,In this case
                //we are here again putting data to the list.
                addData();
            }
        });
    }
}
