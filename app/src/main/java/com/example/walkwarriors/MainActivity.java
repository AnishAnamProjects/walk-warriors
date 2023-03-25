package com.example.walkwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

   private TextView text;
   private ImageView sprite;
   private Button switchSprites;
   private Hero mainCharacter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainCharacter = new Hero();
        switchSprites = (Button)findViewById(R.id.switchSprites);

        // Switch Genders
        switchSprites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mainCharacter.heroSprite == 0){
                    sprite = (ImageView)findViewById(R.id.heroSprite);
                    sprite.setImageResource(R.drawable.sprite_girl);
                    mainCharacter.heroSprite = 1;
                } else {
                    sprite = (ImageView)findViewById(R.id.heroSprite);
                    sprite.setImageResource(R.drawable.sprite_boy);
                    mainCharacter.heroSprite = 0;
                }
            }
        });
    }
}