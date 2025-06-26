package com.barcode.uniplo.service;

import com.barcode.uniplo.domain.CommentDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentService {
    int getCount(Integer post_id);

    int remove(Integer comment_id, Integer post_id, Integer user_id);

    int write(CommentDto commentDto);

    List<CommentDto> getList(Integer post_id);

    CommentDto read(Integer comment_id);

    int modify(CommentDto commentDto);
}
