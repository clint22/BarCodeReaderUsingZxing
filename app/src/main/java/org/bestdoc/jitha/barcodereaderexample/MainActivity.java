package org.bestdoc.jitha.barcodereaderexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.start_scanning_front_camera)
    TextView start_scanning_front_camera;
    @BindView(R.id.txt_content)
    TextView txt_content;
    @BindView(R.id.start_scanning_back_camera)
    TextView start_scanning_back_camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        start_scanning_front_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new IntentIntegrator(MainActivity.this)
                        .setCameraId(1)
                        .initiateScan();
            }
        });

        start_scanning_back_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new IntentIntegrator(MainActivity.this).initiateScan();

            }
        });


    }



    public void onActivityResult(int requestCode, int resultCode, Intent intent)

    {
//retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {

            String scanContent = scanningResult.getContents();
            txt_content.setText(scanContent);


        }
    }
}
