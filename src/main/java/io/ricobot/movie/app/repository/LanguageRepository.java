package io.ricobot.movie.app.repository;

import io.ricobot.movie.app.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface LanguageRepository extends JpaRepository<Language, Long> {

}