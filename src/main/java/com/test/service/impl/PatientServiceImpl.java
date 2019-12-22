package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.PatientDao;
import com.test.model.Patient;
import com.test.model.Treatment;
import com.test.service.PatientService;

@Service
@Transactional
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientDao patientDao;
	
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		patientDao.savePatient(patient);
		return patient;
	}

	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return patientDao.getPatients();
	}

	public Treatment saveTreatment(int id, Treatment treatment) {
		// TODO Auto-generated method stub
		patientDao.saveTreatment(id, treatment);
		return treatment;
	}

	public Treatment find(int id) {
		// TODO Auto-generated method stub
		return patientDao.find(id);
	}

	public Treatment update(Treatment treatment) {
		// TODO Auto-generated method stub
		patientDao.update(treatment);
		return treatment;
	}

	public List<Treatment> getAllTreatments(int id) {
		// TODO Auto-generated method stub
		return patientDao.getAllTreatments(id);
	}

	public Treatment delete(Treatment treatment, int id) {
		// TODO Auto-generated method stub
		return patientDao.delete(treatment, id);
	}

}
