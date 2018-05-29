package cl.magnet.mobileappsexample;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.magnet.mobileappsexample.db.Form;
import cl.magnet.mobileappsexample.db.FormViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFormFragment extends Fragment {

    private FormViewModel mFormViewModel;

    public NewFormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFormViewModel = ViewModelProviders.of(this).get(FormViewModel.class);
        Button submitButton = view.findViewById(R.id.formSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get basic form data
                TextView nameView = v.findViewById(R.id.name);
                final String name = nameView.getText().toString();
                TextView dateView = v.findViewById(R.id.date);
                final String date = dateView.getText().toString();

                Form newForm = new Form(name, date);
                List<Form> forms = new ArrayList<> ();
                forms.add(newForm);

                mFormViewModel.insert(forms);

                // TODO create new form and insert to db
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_form, container, false);
    }

}
