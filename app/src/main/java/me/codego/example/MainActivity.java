package me.codego.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import me.codego.example.view.SimpleDrawableClickListener;
import me.codego.example.view.ActionEditText;
import me.codego.example.view.ActionTextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private ActionEditText inputEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.layout);
        inputEdit = (ActionEditText) findViewById(R.id.input);

        inputEdit.setOnDrawableClickListener(new SimpleDrawableClickListener(){
            @Override
            public boolean onRightDrawableClick(View view) {
                inputEdit.setText("");
                return super.onRightDrawableClick(view);
            }
        });

    }

    public void addTag(View view) {
        layout.addView(initTag(inputEdit.getText().toString()));
        inputEdit.setText("");
    }

    private View initTag(String tag) {
        final View rootView = getLayoutInflater().inflate(R.layout.layout_tag, null);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ActionTextView tagView = (ActionTextView) rootView.findViewById(R.id.tag);
        tagView.setText(tag);
        tagView.setOnDrawableClickListener(new SimpleDrawableClickListener(){
            @Override
            public boolean onRightDrawableClick(View view) {
                layout.removeView(rootView);
                Toast.makeText(MainActivity.this, "delete", Toast.LENGTH_SHORT).show();
                return super.onRightDrawableClick(view);
            }
        });
//        tagView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
//            }
//        });
        return rootView;
    }
}
