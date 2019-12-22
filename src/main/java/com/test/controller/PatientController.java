package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Patient;
import com.test.model.Treatment;
import com.test.service.PatientService;

@Controller
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String register() {
		return "index";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseBody
	public Patient createPatient(@RequestBody Patient patient) {
		Patient response=patientService.savePatient(patient);
		return patient;
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public List<Patient> ListOfPatient() {
		List<Patient> response=patientService.getPatients();
		return response;
	}
	
	@RequestMapping(value = "/saveTreatment/{id}",method = RequestMethod.POST)
	@ResponseBody
	public Treatment createTreatment(@RequestBody Treatment treatment,@PathVariable("id")int id) {
		Treatment response=patientService.saveTreatment(id, treatment);
		return response;
	}
	
	@RequestMapping(value = "/treatmentlist/{id}",method = RequestMethod.GET)
	@ResponseBody
	public List<Treatment> ListOfTreatment(@PathVariable("id")int id) {
		List<Treatment> response=patientService.getAllTreatments(id);
		return response;
	}
	@RequestMapping(value = "/editTreatment/{treatId}",method = RequestMethod.PUT)
	@ResponseBody
	public Treatment editTreatment(@PathVariable("treatId")int treatId,@RequestBody Treatment treatment) {
		Treatment trIdObj = patientService.find(treatId);
		trIdObj.setName(treatment.getName());
		trIdObj.setType(treatment.getType());
		trIdObj.setTreatedBy(treatment.getTreatedBy());
		Treatment response=patientService.update(trIdObj);
		return response;
	}
	@RequestMapping(value = "/deleteTreatment/{treatId}",method = RequestMethod.DELETE)
	@ResponseBody
	public Treatment deleteTreatment(@PathVariable("treatId")int treatId, Treatment treatment) {
		Treatment  response=patientService.delete(treatment, treatId);
		return response;
	}
}
