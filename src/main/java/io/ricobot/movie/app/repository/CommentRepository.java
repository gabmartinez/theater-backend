package io.ricobot.movie.app.repository;

import io.ricobot.movie.app.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
