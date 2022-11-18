package nexacro.nexacrotest1.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    List<Map<String, Object>> findList();
}
