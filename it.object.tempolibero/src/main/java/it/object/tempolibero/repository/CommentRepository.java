package it.object.tempolibero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.object.tempolibero.model.Comment;

public interface CommentRepository extends JpaRepository <Comment, Long>{

}
