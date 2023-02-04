package edu.gatech.hapifhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import junit.framework.TestCase;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;

public class BundleHandlerTest extends TestCase {

    FhirContext ctx = null;
    String serverBase = "http://hapi.fhir.org/baseR4"; // This is an example server base using a common test FHIR Server.

    public void testNavigateBundle() {
        // This test is written for you to demonstrate how you can check your method using a live FHIR server for
        // practice. Please note that this is not the approach used in Gradescope, but as long as you are returning
        // the expected string your method will pass.

        if (ctx == null) ctx = FhirContext.forR4(); // Context specified the FHIR context (version).

        IGenericClient client = ctx.newRestfulGenericClient(serverBase); // Build the FHIR client.

        // The follow lines execute a search using the client, placing the results into a Bundle object, which is what
        // a search operation will always return. Here it is searching for Patient resources with a family name of
        // "duck".
        Bundle results = client
                .search()
                .forResource(Patient.class)
                .where(Patient.FAMILY.matches().value("duck"))
                .returnBundle(Bundle.class)
                .execute();

        BundleHandler bundleHandler = new BundleHandler(); // Instantiate your bundle handler.
        String nextUrl = bundleHandler.navigateBundle(results, Bundle.LINK_SELF); // Call your navigateBundle method.

        // You will have to build out any additional parts of this test needed here.
        // System.out.println(nextUrl);
    }

    public void testGetListOfDeceasedPatients() {
        BundleHandler bundleHandler = new BundleHandler();
        // Build your tests here.
        if (ctx == null) ctx = FhirContext.forR4();
        IGenericClient client = ctx.newRestfulGenericClient(serverBase); // Build the FHIR client.

        Bundle results = client
                .search()
                .forResource(Patient.class)
                .where(Patient.FAMILY.matches().value("duck"))
                .returnBundle(Bundle.class)
                .execute();
        System.out.println(bundleHandler.getListOfDeceasedPatients(results));
    }

}
