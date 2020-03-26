package com.rujirakongsomran.bubblescrollbars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rujirakongsomran.bubblescrollbars.Adapter.MyAdapter;
import com.trendyol.bubblescrollbarlib.BubbleScrollBar;
import com.trendyol.bubblescrollbarlib.BubbleTextProvider;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> listData;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    BubbleScrollBar scrollBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));

        initData();
        Collections.sort(listData);
        recyclerView.setAdapter(new MyAdapter(listData));

        scrollBar = (BubbleScrollBar) findViewById(R.id.scrollBar);
        scrollBar.attachToRecyclerView(recyclerView);
        scrollBar.setBubbleTextProvider(new BubbleTextProvider() {
            @Override
            public String provideBubbleText(int i) {
                return new StringBuilder(listData.get(i).substring(0, 1)).toString();
            }
        });

    }

    private void initData() {
        listData.add("Biwberry");
        listData.add("Benz");
        listData.add("Bankki");
        listData.add("Cake88");
        listData.add("Emmy");
        listData.add("Notto");
        listData.add("Nun");
        listData.add("Nutta");
        listData.add("Pat");
        listData.add("Tor");
        listData.add("You");
    }
}
