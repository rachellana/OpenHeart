package openheart.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Patient;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		FhirContext context = FhirContext.forR4();
		IGenericClient client = context.newRestfulGenericClient("https://hapi.fhir.org/baseR4");
		// Read a patient resource from the FHIR server
		Patient patient = client.read().resource(Patient.class).withId("nhanes-112200").execute();
		System.out.println(patient.getNameFirstRep().getNameAsSingleString());
	}

}
