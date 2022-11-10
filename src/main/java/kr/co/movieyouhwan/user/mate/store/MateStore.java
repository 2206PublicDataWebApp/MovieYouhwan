package kr.co.movieyouhwan.user.mate.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.mate.domain.CinemaOption;
import kr.co.movieyouhwan.user.mate.domain.GenreOption;

public interface MateStore {

	int selectMateStatus(SqlSessionTemplate session, String memberId);

	int updateMateStatusY(SqlSessionTemplate session, String memberId);

	List<CinemaOption> selectCinemaOption(SqlSessionTemplate session);

	List<GenreOption> selectGenreOption(SqlSessionTemplate session);

}
