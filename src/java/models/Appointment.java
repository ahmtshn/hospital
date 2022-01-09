/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ahmetsahin
 */
public class Appointment {

    private String appointmentId, personelTckn, patientTckn, personelName, patientName, appointmentDate, appointmentNotes;
    private boolean appointmentStatus;

    public Appointment() {
    }

    public Appointment(String appointmentId, String personelTckn, String patientTckn, String personelName, String patientName, String appointmentDate, String appointmentNotes, boolean appointmentStatus) {
	this.appointmentId = appointmentId;
	this.personelTckn = personelTckn;
	this.patientTckn = patientTckn;
	this.personelName = personelName;
	this.patientName = patientName;
	this.appointmentDate = appointmentDate;
	this.appointmentNotes = appointmentNotes;
	this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentId() {
	return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
	this.appointmentId = appointmentId;
    }

    public String getPersonelTckn() {
	return personelTckn;
    }

    public void setPersonelTckn(String personelTckn) {
	this.personelTckn = personelTckn;
    }

    public String getPatientTckn() {
	return patientTckn;
    }

    public void setPatientTckn(String patientTckn) {
	this.patientTckn = patientTckn;
    }

    public String getPersonelName() {
	return personelName;
    }

    public void setPersonelName(String personelName) {
	this.personelName = personelName;
    }

    public String getPatientName() {
	return patientName;
    }

    public void setPatientName(String patientName) {
	this.patientName = patientName;
    }

    public String getAppointmentDate() {
	return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
	this.appointmentDate = appointmentDate;
    }

    public String getAppointmentNotes() {
	return appointmentNotes;
    }

    public void setAppointmentNotes(String appointmentNotes) {
	this.appointmentNotes = appointmentNotes;
    }

    public boolean isAppointmentStatus() {
	return appointmentStatus;
    }

    public void setAppointmentStatus(boolean appointmentStatus) {
	this.appointmentStatus = appointmentStatus;
    }

    

}
