package nexacro.nexacrotest1.mapper;

import nexacro.nexacrotest1.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberVO> findList();
}
