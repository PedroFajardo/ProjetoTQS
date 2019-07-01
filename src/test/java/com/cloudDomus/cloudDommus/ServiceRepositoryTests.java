package com.cloudDomus.cloudDommus;

import com.cloudDomus.cloudDommus.Service.Service;
import com.cloudDomus.cloudDommus.Service.ServiceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ServiceRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ServiceRepository serviceRepository;

    @Test
    public void findByType_Service() {

        Service service = new Service("Lavagem", "open 24/7");
        entityManager.persist(service);
        entityManager.flush();

        Service found = serviceRepository.findByType(service.getType());

        assertThat(found.getType()).isEqualTo(service.getType());

    }

    @Test
    public void assertThatIsNotEmpty() {

        Service service = new Service("Babysitter", "only during the day");
        entityManager.persist(service);
        entityManager.flush();

        List<Service> serviceByType = serviceRepository.getByType("Babysitter");
        assertThat(serviceByType).isNotNull().isNotEmpty();

    }

}
