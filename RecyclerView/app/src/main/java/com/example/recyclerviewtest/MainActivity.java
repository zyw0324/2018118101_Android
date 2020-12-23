package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager layoutManager=new
                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    public void initFruits(){
        for(int i = 0; i <3; i++){
            Fruit apple = new Fruit(getRandomLengthName("apple"), R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("banana"),R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("orange"),R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomLengthName("watermelon"), R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomLengthName("pear"), R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit(getRandomLengthName("grape"), R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit(getRandomLengthName("pineapple"), R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("strawberry"), R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomLengthName("cherry"), R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomLengthName("mango"), R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(10) + 1;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i++){
            builder.append(name);
        }
        return builder.toString();
    }
}