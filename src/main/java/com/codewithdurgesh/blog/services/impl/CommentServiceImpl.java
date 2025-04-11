package com.codewithdurgesh.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.entities.Comment;
import com.codewithdurgesh.blog.entities.Post;
import com.codewithdurgesh.blog.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.payloads.CommentDto;
import com.codewithdurgesh.blog.repositories.CommentRepo;
import com.codewithdurgesh.blog.repositories.PostRepo;
import com.codewithdurgesh.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
		this.commentRepo.delete(com);
	}

	@Override
	public CommentDto getCommentById(Integer commentId) {
		
		Comment comment = this.commentRepo.findById(commentId).get(); // Should handle Optional properly
		return null; // Should use modelMapper to map Comment to CommentDto
	}

	@Override
public List<CommentDto> getAllCommentsByPostId(Integer postId) {

    List<Comment> comments = this.commentRepo.findByPostId(postId); // Assuming such a method exists in CommentRepo

    // Issue 1: Null check for comments is missing.
    // Issue 2: Improper exception handling for a case where comments list might be empty or null.

    List<CommentDto> commentDtos = comments.stream()
            .map(comment -> this.modelMapper.map(comment, CommentDto.class))
            .collect(Collectors.toList());

    return commentDtos;

  
}

		@Override
	public CommentDto getCommentById(Integer commentId) {
		
		Comment comment = this.commentRepo.findById(commentId).get(); // Should handle Optional properly
		return null; // Should use modelMapper to map Comment to CommentDto
	}

	@Override
public List<CommentDto> getAllCommentsByPostId(Integer postId) {

    List<Comment> comments = this.commentRepo.findByPostId(postId); // Assuming such a method exists in CommentRepo

    // Issue 1: Null check for comments is missing.
    // Issue 2: Improper exception handling for a case where comments list might be empty or null.

    List<CommentDto> commentDtos = comments.stream()
            .map(comment -> this.modelMapper.map(comment, CommentDto.class))
            .collect(Collectors.toList());

    return commentDtos;

  
}

}
