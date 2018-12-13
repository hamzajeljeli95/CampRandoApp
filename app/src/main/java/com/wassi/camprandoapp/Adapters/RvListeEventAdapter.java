package com.wassi.camprandoapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wassi.camprandoapp.DetailEvenement;
import com.wassi.camprandoapp.R;
import com.wassi.camprandoapp.model.Infoevt;

import java.util.List;

public class RvListeEventAdapter extends RecyclerView.Adapter<RvListeEventAdapter.ViewHolder> {
    private Context mContext;
    private List<Infoevt> infoevts;

    public RvListeEventAdapter(List<Infoevt> infoevts,Context mContext) {
        this.infoevts = infoevts;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_liste_evt, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       final Infoevt infoevt = infoevts.get(i);
        viewHolder.title.setText(infoevt.getNom());
        viewHolder.type.setText(infoevt.getType());
        viewHolder.org.setText(infoevt.getOrigin());
        viewHolder.des.setText(infoevt.getDes());
        viewHolder.dt.setText(infoevt.getDate());
        viewHolder.hd.setText(infoevt.getHd());
        viewHolder.hf.setText(infoevt.getHf());
        viewHolder.nb_place.setText(infoevt.getNb_place());
        viewHolder.prix.setText(infoevt.getPrix());
        Glide.with(mContext).load(infoevt.getEvt_img()).into(viewHolder.img);
        viewHolder.myCurrView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailEvenement.class);
                i.putExtra("infos", infoevt);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return infoevts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView img;
        public final TextView title;
        public final TextView type;
        public final TextView org;
        public final TextView des;
        public final TextView dt;
        public final TextView hd;
        public final TextView hf;
        public final TextView nb_place;
        public final TextView prix;
        public final View myCurrView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.evtimage);
            title = itemView.findViewById(R.id.text_titre);
            type = itemView.findViewById(R.id.text_type);
            org = itemView.findViewById(R.id.text_org);
            des = itemView.findViewById(R.id.text_des);
            dt = itemView.findViewById(R.id.text_Date);
            hd =  itemView.findViewById(R.id.text_hd);
            hf = itemView.findViewById(R.id.text_hf);
            nb_place = itemView.findViewById(R.id.text_nbp);
            prix = itemView.findViewById(R.id.text_Prix);
            myCurrView = itemView;

        }
    }
}
