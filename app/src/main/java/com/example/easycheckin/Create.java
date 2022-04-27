package com.example.easycheckin;

import static android.content.Context.WINDOW_SERVICE;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Create#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Create extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Create() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Create.
     */
    // TODO: Rename and change types and number of parameters
    public static Create newInstance(String param1, String param2) {
        Create fragment = new Create();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    private ImageView qrCode;
    private Button generateBtn;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;




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

        View inflate = inflater.inflate(R.layout.fragment_create, container, false);
        qrCode = inflate.findViewById(R.id.qr_code);
        generateBtn = inflate.findViewById(R.id.gencode);
        //System.out.println(getActivity());

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // below line is for getting
                // the windowmanager service.
                WindowManager manager = (WindowManager) getActivity().getSystemService(WINDOW_SERVICE);

                // initializing a variable for default display.
                Display display = manager.getDefaultDisplay();

                // creating a variable for point which
                // is to be displayed in QR Code.
                Point point = new Point();
                display.getSize(point);

                // getting width and
                // height of a point
                int width = point.x;
                int height = point.y;


                int dimen = width < height ? width : height;
                dimen = dimen * 3 / 4;

                // setting this dimensions inside our qr code
                // encoder to generate our qr code.

                // change the insert default data the information that we need to store
                qrgEncoder = new QRGEncoder("Insert Default data in generation", null, QRGContents.Type.TEXT, dimen);
                try {
                    // getting our qrcode in the form of bitmap.
                    bitmap = qrgEncoder.getBitmap();
                    // the bitmap is set inside our image
                    // view using .setimagebitmap method.
                    qrCode.setImageBitmap(bitmap);
                } catch (Exception e) {
                    // this method is called for
                    // exception handling.
                    Log.e("Tag", e.toString());
                }
            }
        });


        // Inflate the layout for this fragment
        return inflate;
    }
}