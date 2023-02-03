package edu.gatech.hapifhir;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;

import java.util.ArrayList;

public class BundleHandler {

    public BundleHandler() { }

    public String navigateBundle(Bundle bundle, String link) {

        // START STUDENT CODE HERE
        System.out.println(bundle.getEntry().get(0).getFullUrl());
        // END STUDENT CODE HERE

        return ""; // Returning empty string so starter code compiles.
    }

    public ArrayList<Patient> getListOfDeceasedPatients(Bundle bundle) {
        ArrayList<Patient> patientArrayList = new ArrayList<>();

        // START STUDENT CODE HERE

        // END STUDENT CODE HERE

        return patientArrayList; //
    }
}
