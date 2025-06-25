package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.PostDto;
import com.barcode.uniplo.domain.PostType;
import com.barcode.uniplo.domain.SearchCondition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;
    @Test
    void insert() {

        for(int i=0; i<200; i++) {
            PostDto dto = new PostDto(null, 1, LocalDateTime.now(), LocalDateTime.now(), "QNA" + i,"no_content" + i, 0, 0, 0, 0, 0,"QNA", "N", "문의", "배송");
            postRepository.insert(dto);
        }
        for(int i=0; i<200; i++) {
            PostDto dto = new PostDto(null, 1, LocalDateTime.now(), LocalDateTime.now(), "FAQ" + i,"no_content" + i, 0, 0, 0, 0, 0,"FAQ", "N", "문의", "배송");
            postRepository.insert(dto);
        }

        for(int i=0; i<200; i++) {
            PostDto dto = new PostDto(null, 1, LocalDateTime.now(), LocalDateTime.now(), "NOTICE" + i,"no_content" + i, 0, 0, 0, 0, 0,"NOTICE", "N", "문의", "배송");
            postRepository.insert(dto);
        }
    }


    @Test
    void SCTest1() {

        SearchCondition sc = new SearchCondition(
                2,
                10,
                "",
                "",
                PostType.QNA
        );

        List<PostDto> result = postRepository.searchSelectPage(sc);
        System.out.println("검색 결과 개수: " + result.size());
        for (PostDto post : result) {
            System.out.println(post);
        }
    }
}