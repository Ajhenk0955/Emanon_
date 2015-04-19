package backdoor_;

import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class PatientFiles {

	private List<PDDocument> pictures;

	private List<PDDocument> claimForms;
	
	private List<PDDocument> insuranceCards;
	
	private List<PDDocument> professionalCommunication;
	
	private List<PDDocument> insuranceClaims;

	public List<PDDocument> getPictures() {
		return pictures;
	}

	public void setPictures(List<PDDocument> pictures) {
		this.pictures = pictures;
	}

	public List<PDDocument> getClaimForms() {
		return claimForms;
	}

	public void setClaimForms(List<PDDocument> claimForms) {
		this.claimForms = claimForms;
	}

	public List<PDDocument> getInsuranceCards() {
		return insuranceCards;
	}

	public void setInsuranceCards(List<PDDocument> insuranceCards) {
		this.insuranceCards = insuranceCards;
	}

	public List<PDDocument> getProfessionalCommunication() {
		return professionalCommunication;
	}

	public void setProfessionalCommunication(
			List<PDDocument> professionalCommunication) {
		this.professionalCommunication = professionalCommunication;
	}

	public List<PDDocument> getInsuranceClaims() {
		return insuranceClaims;
	}

	public void setInsuranceClaims(List<PDDocument> insuranceClaims) {
		this.insuranceClaims = insuranceClaims;
	}
	
}
