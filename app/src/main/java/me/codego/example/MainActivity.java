package me.codego.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.codego.view.ActionEditText;
import me.codego.view.ActionTextView;
import me.codego.view.FlowLayout;
import me.codego.view.OnActionClickListener;

public class MainActivity extends AppCompatActivity {

    private ActionEditText inputEdit;
    private FlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEdit = (ActionEditText) findViewById(R.id.input);
        flowLayout = (FlowLayout) findViewById(R.id.flow_layout);

        inputEdit.setOnActionClickListener(new OnActionClickListener(){
            @Override
            public boolean onActionClick(Action action, View view) {
                switch (action) {
                    case RIGHT:
                        inputEdit.setText("");
                        break;
                }
                return false;
            }
        });

    }

    public void addTag(View view) {
        flowLayout.addView(initTag(inputEdit.getText().toString()));
        inputEdit.setText("");
    }

    private View initTag(String tag) {
        final View rootView = getLayoutInflater().inflate(R.layout.layout_tag, null);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ActionTextView tagView = (ActionTextView) rootView.findViewById(R.id.tag);
        tagView.setText(tag);
        tagView.setOnActionClickListener(new OnActionClickListener(){
            @Override
            public boolean onActionClick(Action action, View view) {
                flowLayout.removeView(view);
                Toast.makeText(MainActivity.this, "delete", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return rootView;
    }
}
