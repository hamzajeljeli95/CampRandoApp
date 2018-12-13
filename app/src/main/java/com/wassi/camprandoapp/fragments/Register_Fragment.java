package com.wassi.camprandoapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.wassi.camprandoapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Register_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Register_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Register_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText name,password,re_password,email,ntel;
    String name_user,password_user,re_password_user,email_user,ntel_user;
    ImageView btn_sgn_in;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public Register_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Register_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Register_Fragment newInstance(String param1, String param2) {
        Register_Fragment fragment = new Register_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        initViews(view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    private void initViews(View view){

        btn_sgn_in = (ImageView)view.findViewById(R.id.replussign);
        ntel = (EditText) view.findViewById(R.id.tel_user);
        name= (EditText)view.findViewById(R.id.name_user);
        email = (EditText)view.findViewById(R.id.email_user);
        password = (EditText)view.findViewById(R.id.pwd_user);
        re_password= (EditText)view.findViewById(R.id.re_pwd_user);


        btn_sgn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             verif_champs();
            }
        });

    }
    public void verif_champs(){
        String ntel_user = ntel.getText().toString();
        String name_user = name.getText().toString();
        String email_user = email.getText().toString();
        String password_user = password.getText().toString();
        String re_password_user=re_password.getText().toString();

        if(!name_user.isEmpty() && !email_user.isEmpty() && !password_user.isEmpty() && !re_password_user.isEmpty() && !ntel_user.isEmpty()) {
            if(password_user.equals(re_password_user)){
                registerProcess(name_user,email_user,password_user,re_password_user,ntel_user);
            }
            else {
                Snackbar.make(getView(), "Enter the same password !", Snackbar.LENGTH_LONG).show();
            }
        } else {

            Snackbar.make(getView(), "Fields are empty !", Snackbar.LENGTH_LONG).show();
        }
    }
    public void registerProcess(String name_user,String email_user,String password_user,String re_password_user,String ntel_user){

    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
