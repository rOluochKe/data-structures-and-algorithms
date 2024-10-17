class EmergencyDepartment {
  constructor() {
    this.patients = [];
  }

  patientEnters(name) {
    this.patients.push(name);
    console.log(`${name} has entered the Emergency Department.`);
  }

  patientSeenByDoctor() {
    if (this.patients.length === 0) {
      console.log("No patients waiting to be seen.");
    } else {
      let seenPatient = this.patients.shift();
      console.log(`${seenPatient} has been seen by the doctor.`);
    }
  }

  displayPatientsWaiting() {
    console.log("Patients waiting to be seen:");
    this.patients.forEach((patient, index) => {
      console.log(`${index + 1}. ${patient}`);
    });
  }
}

let ed = new EmergencyDepartment();

ed.patientEnters("Alice");
ed.patientEnters("Bob");
ed.displayPatientsWaiting();

ed.patientSeenByDoctor();
ed.displayPatientsWaiting();
