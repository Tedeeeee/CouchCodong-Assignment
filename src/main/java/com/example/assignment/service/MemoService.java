package com.example.assignment.service;

import com.example.assignment.Entity.Category;
import com.example.assignment.Entity.Memo;
import com.example.assignment.Entity.dto.MemoDTO;
import com.example.assignment.repository.CategoryRepository;
import com.example.assignment.repository.MemoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    private final CategoryRepository categoryRepository;

    public Memo createMemo(MemoDTO memoDTO) {
        // 메모의 제목이나 내용은 중복이 되어도 상관이 없다.

        // 받은 카테고리 id 를 통해 category 를 찾아야 한다.
        Category category = categoryRepository.findCategoryById(memoDTO.getCategory_id());

        // category 가 없다면 카테고리의 문제를 발생
        if (category == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 카테고리입니다");
        }

        Memo memo = Memo.builder()
                .category(category)
                .name(memoDTO.getName())
                .content(memoDTO.getContent())
                .build();

        return memoRepository.save(memo);
    }

    public Memo getMemo(Long id) {
        return memoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 메모는 존재하지 않습니다."));
    }

    public Memo MemoUpdate(MemoDTO memoDTO) {
        Optional<Memo> memoId = memoRepository.findById(memoDTO.getMemo_id());

        if (memoId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 메모입니다.");
        }

        Category category = categoryRepository.findCategoryById(memoDTO.getCategory_id());

        if (category == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 카테고리입니다");
        }

        // 메모를 업데이트 할떄 다른 내용까지 모두 보내서 그 값을 기존의 값에 덧씌울 예정이다.
        Memo memo = Memo.builder()
                .id(memoDTO.getMemo_id())
                .category(category)
                .name(memoDTO.getName())
                .content(memoDTO.getContent())
                .build();

        return memoRepository.save(memo);
    }

    public boolean deleteMemo(Long id) {
        Optional<Memo> memo = memoRepository.findById(id);

        if (memo.isPresent()) {
            memoRepository.deleteById(id);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 메모입니다");
        }
    }

    public List<Memo> findAllMemo(Long id) {
        return memoRepository.findAll().stream()
                .filter(memo -> memo.getCategory().getId().equals(id))
                .collect(Collectors.toList());
    }
}
