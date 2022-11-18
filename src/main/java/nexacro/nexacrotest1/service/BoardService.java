package nexacro.nexacrotest1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexacro.nexacrotest1.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardMapper boardMapper;

    public List<Map<String, Object>> findList() {
        return boardMapper.findList();
    }
}
