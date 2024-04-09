package it.object.tempolibero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.object.tempolibero.model.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {

}
