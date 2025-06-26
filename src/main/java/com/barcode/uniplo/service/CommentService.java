package com.barcode.uniplo.service;

import com.barcode.uniplo.domain.CommentDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentService {
    int getCount(Integer post_id);

    @Transactional(rollbackFor = Exception.class)
        // updateCommentCount랑 delete 모두 성공해야하니까 @Transactional. 예외 발생하면 rollback해라.
    int remove(Integer comment_id, Integer post_id, Integer user_id);

    @Transactional(rollbackFor = Exception.class)
    int write(CommentDto commentDto);

    List<CommentDto> getList(Integer post_id);

    CommentDto read(Integer comment_id);

    int modify(CommentDto commentDto);
}
