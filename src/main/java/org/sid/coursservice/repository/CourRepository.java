package org.sid.coursservice.repository;

import org.sid.coursservice.entities.Cour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourRepository extends JpaRepository<Cour,Long > {

}
