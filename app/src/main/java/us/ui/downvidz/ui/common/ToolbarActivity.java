package us.ui.downvidz.ui.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ui.downvid.R;

public abstract class ToolbarActivity extends AppCompatActivity {
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        mToolbar = this.findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
    }

    protected abstract int getLayoutResource();
}
