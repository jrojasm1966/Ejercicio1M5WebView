package com.example.ejercicio1m5;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.ejercicio1m5.databinding.FragmentWebViewBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentWebView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentWebView extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String urlActivity;
    private String param2;
    private WebView web;
    private Button Boton;

    private FragmentWebViewBinding binding;
    public FragmentWebView() {
        // Required empty public constructor
    }
    public static FragmentWebView newInstance(String urlActivity , String param2) {
        FragmentWebView fragment = new FragmentWebView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, urlActivity);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            urlActivity = getArguments().getString(ARG_PARAM1);
            param2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWebViewBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        WebView webView = binding.web1;
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        // Configurar el webView
        webView.getSettings().setJavaScriptEnabled(true);

        // Configurar webViewClient para cargar el contenido dentro del webVIew
        webView.setWebViewClient(new WebViewClient());

        // Obtener la url
        String url = urlActivity.trim();
        webView.loadUrl("https://" + url);

        // Se configura Boton para Volver desde Fragmento a Activity
        Button Boton = (Button) view.findViewById(R.id.volverBoton);
        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent (getActivity(), MainActivity.class);
                startActivity(in);
            }
        });
        return  view;
    }
}
