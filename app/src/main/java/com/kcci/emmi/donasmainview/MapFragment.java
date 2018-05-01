package com.kcci.emmi.donasmainview;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    private ClusterManager<TkykItem> tkykItemClusterManager;
    private GoogleMap mMap;
    private MapView mapView;
    private Geocoder geocoder;
    private List<Address> singleAddress = null;
    private ArrayList<List<Address>> addressArray;
    private HashMap<String, String> pointsDetails;
    private ArrayList<HashMap<String, String>> tkykPoints;

    FrameLayout mapLayout;
    View view;

    Fragment parentFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_map, null);
        mapView = view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

        mapLayout = view.findViewById(R.id.fragment_map);

        parentFragment = (Fragment) getArguments().getSerializable("parent");
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        geocoder = new Geocoder(getContext(), Locale.KOREA);
        addressArray = new ArrayList<>();

        //지도 뷰의 중심점 설정
        final LatLngBounds SEOUL = new LatLngBounds(
                new LatLng(15, 120), new LatLng(40, 150));
        mMap.setLatLngBoundsForCameraTarget(SEOUL);
        LatLng center = new LatLng(35.958438, 127.771991);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 7));

        tkykItemClusterManager = new ClusterManager<TkykItem>(getContext(), mMap);
        mMap.setOnCameraIdleListener(tkykItemClusterManager);
        mMap.setOnMarkerClickListener(tkykItemClusterManager);

        Bundle bundle = getArguments();

        tkykPoints = (ArrayList<HashMap<String, String>>) bundle.getSerializable("tkykPoints");

        for (int i = 0; i < tkykPoints.size(); i++) {
            HashMap<String, String> pointsDetails = tkykPoints.get(i);
            String[] coordinates = pointsDetails.get("coordinates").split(",");

            try {
                LatLng latLng = new LatLng(Double.parseDouble(coordinates[1]), Double.parseDouble(coordinates[0]));
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(pointsDetails.get("name"))
                        .snippet(pointsDetails.get("description"))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.takoyaki)));
                mMap.setOnInfoWindowClickListener(this);
            } catch (NumberFormatException e) {
                Log.e("coordinates_null", pointsDetails.get("name"));
            }
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(getContext(), "누구나 가슴에 삼천원쯤은 있는 거에요", Toast.LENGTH_SHORT).show();
        mapLayout.setVisibility(View.INVISIBLE);

        InfoFragment infoFragment = new InfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tkykPoints", tkykPoints);
        infoFragment.setArguments(bundle);

        ((RegionFragment)parentFragment).changeFragment(infoFragment);
    }
}
