package com.example.easycheckin;

import static android.Manifest.permission.VIBRATE;
import static android.Manifest.permission_group.CAMERA;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import eu.livotov.labs.android.camview.ScannerLiveView;
import eu.livotov.labs.android.camview.scanner.decoder.BarcodeDecoder;
import eu.livotov.labs.android.camview.scanner.decoder.zxing.ZXDecoder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Scan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Scan extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Scan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Scan.
     */
    // TODO: Rename and change types and number of parameters
    public static Scan newInstance(String param1, String param2) {
        Scan fragment = new Scan();
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

    private ScannerLiveView camera;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflat = inflater.inflate(R.layout.fragment_scan, container, false);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 0);

        } else {

            // initialize scannerLiveview and textview.
            camera = (ScannerLiveView) inflat.findViewById(R.id.camview);

            camera.setScannerViewEventListener(new ScannerLiveView.ScannerViewEventListener() {
                @Override
                public void onScannerStarted(ScannerLiveView scanner) {
                    // method is called when scanner is started
                    Toast.makeText(inflat.getContext(), "Scanner Started", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onScannerStopped(ScannerLiveView scanner) {
                    // method is called when scanner is stopped.
                    Toast.makeText(inflat.getContext(), "Scanner Stopped", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onScannerError(Throwable err) {
                    // method is called when scanner gives some error.
                    Toast.makeText(inflat.getContext(), "Scanner Error: " + err.getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCodeScanned(String data) {
                    // method is called when camera scans the
                    // qr code and the data from qr code is
                    // stored in data in string format.
                    System.out.println(data);
                }
            });
        }
        // Inflate the layout for this fragment
        return inflat;
    }


    @Override
    public void onResume() {
        super.onResume();
        BarcodeDecoder decoder = new ZXDecoder();
        // 0.5 is the area where we have
        // to place red marker for scanning.
        decoder.setScanAreaPercent(0.8);
        // below method will set secoder to camera.
        camera.setDecoder(decoder);
        camera.startScanner();
    }

    @Override
    public void onPause() {
        // on app pause the
        // camera will stop scanning.
        camera.stopScanner();
        super.onPause();
    }



}