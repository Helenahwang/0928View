package com.appdev.a503_02.a0928view;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class TabUse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_use);

        TabHost host = (TabHost) findViewById(R.id.host);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("tab1");
        spec.setIndicator(null,
                ResourcesCompat.getDrawable(getResources(), R.drawable.camera, null));
        spec.setContent(R.id.tab_content1);
        host.addTab(spec);

        spec = host.newTabSpec("tab2");
        spec.setIndicator(null,
                ResourcesCompat.getDrawable(getResources(), R.drawable.calculator, null));
        spec.setContent(R.id.tab_content2);
        host.addTab(spec);

        spec = host.newTabSpec("tab2");
        spec.setIndicator(null,
                ResourcesCompat.getDrawable(getResources(), R.drawable.briefcase, null));

        spec.setContent(R.id.tab_content2);
        host.addTab(spec);

    }
}
