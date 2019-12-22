package com.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.PatientDao;
import com.test.model.Patient;
import com.test.model.Treatment;

@Repository
@Transactional
public class PatientDaoImpl implements PatientDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		currentSession().save(patient);
		return patient;
	}

	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return currentSession().createCriteria(Patient.class).list();
	}

	public Treatment saveTreatment(int id, Treatment treatment) {
		// TODO Auto-generated method stub
		Patient p = (Patient) currentSession().get(Patient.class, id);
		treatment.setPatient(p);
		currentSession().save(treatment);
		return treatment;
	}

	public List<Treatment> getAllTreatments(int id) {
		// TODO Auto-generated method stub
		Criteria ct = currentSession().createCriteria(Treatment.class);
		Criteria prdCrit = ct.createCriteria("patient");
		prdCrit.add(Restrictions.eq("id", id));
		System.out.println("ct" + ct);
		return ct.list();
	}

	public Treatment find(int id) {
		// TODO Auto-generated method stub
		return (Treatment) currentSession().get(Treatment.class, id);
	}

	public Treatment update(Treatment treatment) {
		// TODO Auto-generated method stub

		currentSession().update(treatment);
		return treatment;
	}

	public Treatment delete(Treatment treatment, int id) {
		// TODO Auto-generated method stub
		currentSession().delete(currentSession().get(Treatment.class, id));
		return null;
	}

}
