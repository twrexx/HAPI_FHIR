package edu.gatech.hapifhir;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;

import org.hl7.fhir.r4.model.BooleanType;

import java.util.ArrayList;

import javax.swing.JSpinner.DefaultEditor;

public class BundleHandler {

    public BundleHandler() { }

    public String navigateBundle(Bundle bundle, String link) {

        // START STUDENT CODE HERE
        if(bundle.getLink(link) != null){
            return bundle.getLink(link).getUrl();
        } else {
            return "-1";
        }
        // END STUDENT CODE HERE
        // return ""; // Returning empty string so starter code compiles.
    }

    public ArrayList<Patient> getListOfDeceasedPatients(Bundle bundle) {
        ArrayList<Patient> patientArrayList = new ArrayList<>();

        // START STUDENT CODE HERE
        for(int i = 0; i < bundle.getEntry().size(); i++) {
            // System.out.println((Patient)bundle.getEntry().get(i).getResource());
            Patient p = new Patient();
            p = (Patient)bundle.getEntry().get(i).getResource();
            BooleanType t = new BooleanType(true);
            if(p.hasDeceasedBooleanType() == true) {
                if(p.getDeceasedBooleanType().booleanValue() == true  ) {
                    patientArrayList.add((Patient)bundle.getEntry().get(i).getResource());
                }
            } 
            if(p.hasDeceasedDateTimeType() == true) {
                patientArrayList.add((Patient)bundle.getEntry().get(i).getResource());
            }
            
        }
        // END STUDENT CODE HERE

        return patientArrayList; //
    }
}
