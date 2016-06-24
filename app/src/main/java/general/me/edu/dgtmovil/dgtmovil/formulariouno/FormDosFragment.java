package general.me.edu.dgtmovil.dgtmovil.formulariouno;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import general.me.edu.dgtmovil.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormDosFragment extends Fragment {


    public FormDosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_dos, container, false);
    }

}
