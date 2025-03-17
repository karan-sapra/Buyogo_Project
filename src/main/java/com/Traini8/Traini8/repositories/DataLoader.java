package com.Traini8.Traini8.repositories;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Traini8.Traini8.entities.Address;
import com.Traini8.Traini8.entities.ClientEntity;
import com.Traini8.Traini8.entities.TrainingCenter;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClientAuth clientRepository;

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists for ClientEntity
        if (clientRepository.count() == 0) {
            ClientEntity client = new ClientEntity();
            client.setClientId("akshay");
            client.setClientToken("akshay@123");
            clientRepository.save(client);
        }

        // Check if data already exists for TrainingCenter
        if (trainingCenterRepository.count() == 0) {
            Random random = new Random();

            // Add 10 rows with random data
            for (int i = 1; i <= 10; i++) {
                TrainingCenter trainingCenter = new TrainingCenter();

                // Set random center name
                trainingCenter.setCenterName("Training Center " + i);

                // Generate a random 12-character center code
                trainingCenter.setCenterCode(generateRandomCode(12));

                // Set random address
                Address address = new Address();
                address.setCity("City " + i);
                address.setState("State " + i);
                address.setDetailedAddress("Address " + i);
                address.setPincode(String.valueOf(100000 + random.nextInt(900000))); // Random 6-digit pincode
                trainingCenter.setAddress(address);

                // Set random student capacity (between 50 and 500)
                trainingCenter.setStudentCapacity(50 + random.nextInt(451));

                // Set random courses offered
                trainingCenter.setCoursesOffered(List.of("Java", "Spring Boot", "Python", "Course " + i));

                // Set random contact email
                trainingCenter.setContactEmail("training" + i + "@example.com");

                // Set random contact phone (10 digits)
                trainingCenter.setContactPhone(generateRandomPhoneNumber());

                // Save the TrainingCenter object
                trainingCenterRepository.save(trainingCenter);
            }
        }
    }

    // Helper method to generate a random alphanumeric code of a given length
    private String generateRandomCode(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            code.append(characters.charAt(random.nextInt(characters.length())));
        }
        return code.toString();
    }

    // Helper method to generate a random 10-digit phone number
    private String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }
}