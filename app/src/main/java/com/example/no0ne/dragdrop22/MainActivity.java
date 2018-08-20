package com.example.no0ne.dragdrop22;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    boolean moving = false;
    float x, y = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        //layout = (RelativeLayout) findViewById(R.id.rootView);

        imageView.setOnTouchListener(new ChoiceTouchListener());
        //imageView.setOnDragListener(new ChoiceDragListener());
    }

    private final class ChoiceTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    moving = true;
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (moving) {
                        x = event.getRawX() - imageView.getWidth();
                        y = event.getRawY() - imageView.getHeight();

                        imageView.setX(x);
                        imageView.setY(y);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }

            return true;
        }
    }

//    private final class ChoiceDragListener implements View.OnDragListener {
//        @Override
//        public boolean onDrag(View v, DragEvent event) {
//            final View view = (View) event.getLocalState();
//
//            switch (event.getAction()) {
//                case DragEvent.ACTION_DRAG_STARTED:
//                    //imageView.setVisibility(View.INVISIBLE);
//
//                    break;
//                case DragEvent.ACTION_DRAG_ENTERED:
//                    break;
//                case DragEvent.ACTION_DRAG_EXITED:
//                    break;
//                case DragEvent.ACTION_DROP:
//                    imageView.setVisibility(View.VISIBLE);
//
//                    break;
//                case DragEvent.ACTION_DRAG_ENDED:
//                    break;
//            }
//
//            return true;
//        }
//    }
}
