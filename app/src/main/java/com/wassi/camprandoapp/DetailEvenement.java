package com.wassi.camprandoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wassi.camprandoapp.model.Infoevt;

public class DetailEvenement extends AppCompatActivity {
    private Infoevt myInfoevt;
    private ImageView bannerImg;
    private TextView titre, type, org, des, date, hd, hf, nb_place, prix;
    private Button btn_part, btn_share, btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_evt);
        myInfoevt = (Infoevt) getIntent().getSerializableExtra("infos");
        initView();
        Glide.with(this).load(myInfoevt.getEvt_img()).into(bannerImg);
        titre.setText(myInfoevt.getNom());
        type.setText(myInfoevt.getType());
        org.setText(myInfoevt.getOrigin());
        titre.setText(myInfoevt.getDes());
        date.setText(myInfoevt.getDate());
        hd.setText(myInfoevt.getHd());
        hf.setText(myInfoevt.getHf());
        nb_place.setText(myInfoevt.getNb_place());
        prix.setText(myInfoevt.getPrix());

    }

    public void initView() {
        bannerImg = (ImageView) findViewById(R.id.image_view_image);
        titre = (TextView) findViewById(R.id.titre);
        type = (TextView) findViewById(R.id.type);
        org = (TextView) findViewById(R.id.org);
        des = (TextView) findViewById(R.id.ds);
        date = (TextView) findViewById(R.id.date);
        hd = (TextView) findViewById(R.id.text_hd);
        hf = (TextView) findViewById(R.id.text_hf);
        nb_place = (TextView) findViewById(R.id.nb_participent);
        prix = (TextView) findViewById(R.id.prix);
        btn_part = (Button) findViewById(R.id.btn_participe);
        btn_share = (Button) findViewById(R.id.btn_partage);
        btn_call = (Button) findViewById(R.id.btn_call);
        btn_part.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                participer();
            }
        });
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prartager();
            }
        });
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call();
            }
        });

    }

    private void call() {
    }

    private void prartager() {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, myInfoevt.getNom());
        sharingIntent.putExtra(Intent.EXTRA_TEXT, myInfoevt.getType() + "\n\n" + myInfoevt.getDate() + "\n\n" + myInfoevt.getDes());
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.share_via)));
    }

    public void participer() {

    }


}
