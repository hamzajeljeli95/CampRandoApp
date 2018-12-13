package com.wassi.camprandoapp.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wassi.camprandoapp.Adapters.RvListeEventAdapter;
import com.wassi.camprandoapp.R;
import com.wassi.camprandoapp.model.Infoevt;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_liste_evt extends Fragment {
    private RecyclerView rv;
    private View v;

    public Fragment_liste_evt() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liste_evt, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rv = getView().findViewById(R.id.eventsRv);
        v = view;
        new getAllEvents(getContext()).execute();

    }

    private class getAllEvents extends AsyncTask<Void, Void, List<Infoevt>> {
        private ProgressDialog pd;
        private Context context;

        public getAllEvents(Context mContext) {
            context = mContext;
            pd = new ProgressDialog(mContext);
            pd.setTitle(getString(R.string.please_wait));
            pd.setMessage(getString(R.string.loading));
            pd.setIndeterminate(false);
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.setCancelable(false);
        }

        @Override
        protected void onPreExecute() {
            pd.show();
        }

        @Override
        protected void onCancelled() {
            pd.dismiss();
        }

        @Override
        protected List<Infoevt> doInBackground(Void... voids) {
            //return EventWS.getEvents();
            return null;
        }

        @Override
        protected void onPostExecute(List<Infoevt> infoBeans) {
            if (infoBeans != null) {
                rv.setLayoutManager(new LinearLayoutManager(context));
                rv.setItemAnimator(new DefaultItemAnimator());
                RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
                rv.addItemDecoration(dividerItemDecoration);
                rv.setAdapter(new RvListeEventAdapter(infoBeans, context));
            } else {
                Snackbar.make(v, Html.fromHtml(getString(R.string.hintcnx)), Snackbar.LENGTH_SHORT).setActionTextColor(getResources().getColor(R.color.actionbar_text))
                        .setAction("Action", null).show();
            }
            pd.dismiss();
        }
    }


}
