package com.inven.book.springboot.service;

import com.inven.book.springboot.domain.posts.Posts;
import com.inven.book.springboot.domain.posts.PostsRepository;
import com.inven.book.springboot.web.dto.PostsResponseDto;
import com.inven.book.springboot.web.dto.PostsSaveRequestDto;
import com.inven.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                                     .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        return new PostsResponseDto(postsRepository.findById(id)
                                                   .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id)));
    }
}
