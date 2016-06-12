package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jhkang on 2016-06-12.
 */
public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
