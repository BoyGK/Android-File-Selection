package com.gkpoter.application1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.gkpoter.localfileselectionlibrary.callback.CallBack;
import com.gkpoter.localfileselectionlibrary.factory.SelectionFactory;
import com.gkpoter.localfileselectionlibrary.interface_.Selection;
import com.gkpoter.localfileselectionlibrary.interface_.SelectionImage;

public class MainActivity extends AppCompatActivity {

    Selection<Bitmap> selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button select = findViewById(R.id.select);
        final ImageView image = findViewById(R.id.image);

        selection = SelectionFactory.getSelection(MainActivity.this, SelectionImage.class);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection.getType().main();
                selection.getType().async();

                selection.getType().file();
                selection.getType().bitmap();
                selection.getType().path();
                selection.select(new CallBack<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        image.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        selection.getSelection().onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        selection.getSelection().flush();
    }
}
