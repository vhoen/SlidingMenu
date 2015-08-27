package me.hoen.slidingmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

abstract public class BaseActivity extends FragmentActivity {
    static final int REQUEST_CODE_RECOVER_PLAY_SERVICES = 1001;

    private SlidingPaneLayout sp;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        sp = (SlidingPaneLayout) findViewById(R.id.slidingpanel);

        initOnclick();
        initMenu();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {

        switch (requestCode) {
            case REQUEST_CODE_RECOVER_PLAY_SERVICES:
                if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "Google Play Services must be " +
                                    "installed.",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
                return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    abstract protected void goHome();
    abstract protected ArrayList<MenuItem>getSlidingMenuItems();
    abstract protected void onSideMenuClick(MenuItem item);

    private void initMenu() {
        ListView menuLv = (ListView) findViewById(R.id.left_navi_listview);

        final ArrayList<MenuItem> list = getSlidingMenuItems();

        MenuAdapter adapter = new MenuAdapter(this, list);
        menuLv.setAdapter(adapter);

        menuLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long id) {
                MenuItem item = (MenuItem) parent.getItemAtPosition(position);

                onSideMenuClick(item);

                if(sp.closeAfterItemSelection()) {
                    sp.closePane();
                }
            }
        });
    }

    protected void initOnclick() {
        ImageView menuHomeIv = (ImageView) findViewById(R.id.slide_menu_home);
        menuHomeIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();

                if(sp.closeAfterItemSelection()) {
                    sp.closePane();
                }
            }
        });

        ImageView menuOpenerIv = (ImageView) findViewById(R.id
                .slide_menu_opener);
        menuOpenerIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.openPane();
            }
        });
    }

}
