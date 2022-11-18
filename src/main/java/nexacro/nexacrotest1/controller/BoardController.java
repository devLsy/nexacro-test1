package nexacro.nexacrotest1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexacro.nexacrotest1.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public String findList(Model model) {
        List<Map<String, Object>> list = boardService.findList();
        model.addAttribute("list", list);
        return null;
        // 넥사크로 경로로 변경 해야 함
//        return "board/list";
    }
}
