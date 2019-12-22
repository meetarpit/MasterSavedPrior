package com.test.service;

import java.util.List;

import com.test.model.Patient;
import com.test.model.Treatment;

public interface PatientService {
	Patient savePatient(Patient patient);
	List<Patient> getPatients();
	Treatment saveTreatment(int id,Treatment treatment);
	Treatment find(int id);
	Treatment update(Treatment treatment);
	List<Treatment> getAllTreatments(int id);
	Treatment delete(Treatment treatment,int id);
}
