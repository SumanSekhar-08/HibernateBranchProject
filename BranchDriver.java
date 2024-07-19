# HibernateBranchProject
package HibernateProject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class BranchDriver {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sonu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        Address address = new Address();
        address.setId(1);
        address.setName("Main Street");
        address.setPincode(123456);
        address.setCity("Bangolor");
        address.setState("Karnataka");
        em.persist(address);

        Hospital hospital = new Hospital();
        hospital.setId(1);
        hospital.setName("Physcho Hospital");
        hospital.setCeo("Dr. Sonu");
        em.persist(hospital);

        Branch branch = new Branch();
        branch.setId(1);
        branch.setBname("North Wing");
        branch.setManager("Mr. Sekhar");
        branch.setHospital(hospital);
        branch.setAddress(address);
        em.persist(branch);

        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setDname("Dr. Suman");
        doctor.setSpecification("Gamerlogist");
        doctor.setYoe(15);
        doctor.setBranch(branch);
        em.persist(doctor);

        Disease disease = new Disease();
        disease.setId(1);
        disease.setName("Pubg");
        disease.setSymptomes("Fever, Cough");
        em.persist(disease);

        Patients patient = new Patients();
        patient.setId(1);
        patient.setName("Suman Sekhar");
        patient.setBloodgroup("O+");
        patient.setWeight(70);
        patient.setAge(30);
        Set<Disease> diseases = new HashSet<>();
        diseases.add(disease);
        patient.setDiseases(diseases);
        em.persist(patient);

        Encounters encounter = new Encounters();
        encounter.setId(1);
        encounter.setName("Routine Checkup");
        encounter.setSymptomes("None");
        encounter.setAge(30);
        encounter.setPatient(patient);
        em.persist(encounter);

        et.commit();
    }
}
