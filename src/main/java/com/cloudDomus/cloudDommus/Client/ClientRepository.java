package com.cloudDomus.cloudDommus.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);
    Client findByID(Long id);
    Client deleteByID(Long id);
}
