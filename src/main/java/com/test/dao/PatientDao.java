package com.test.dao;

import java.util.List;

import com.test.model.Patient;
import com.test.model.Treatment;

public interface PatientDao {

	Patient savePatient(Patient patient);
	List<Patient> getPatients();
	Treatment saveTreatment(int id,Treatment treatment);
	List<Treatment> getAllTreatments(int id);
	Treatment find(int id);
	Treatment update(Treatment treatment);
	Treatment delete(Treatment treatment,int id);
}

