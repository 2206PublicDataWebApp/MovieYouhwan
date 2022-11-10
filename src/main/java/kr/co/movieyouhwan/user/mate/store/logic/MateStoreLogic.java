package kr.co.movieyouhwan.user.mate.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.user.mate.domain.CinemaOption;
import kr.co.movieyouhwan.user.mate.domain.GenreOption;
import kr.co.movieyouhwan.user.mate.store.MateStore;

@Repository
public class MateStoreLogic implements MateStore {

	@Override
	public int selectMateStatus(SqlSessionTemplate session, String memberId) {
		int result=session.selectOne("MateMapper.selectMateStatus", memberId);
		return result;
	}

	@Override
	public int updateMateStatusY(SqlSessionTemplate session, String memberId) {
		int result=session.update("MateMapper.updateMateStatusY", memberId);
		return result;
	}

	@Override
	public List<CinemaOption> selectCinemaOption(SqlSessionTemplate session) {
		List<CinemaOption> cinemaOptionList=session.selectList("MateMapper.selectCinemaOption");
		return cinemaOptionList;
	}

	@Override
	public List<GenreOption> selectGenreOption(SqlSessionTemplate session) {
		List<GenreOption> genreOptionList=session.selectList("MateMapper.selectGenreOption");
		return genreOptionList;
	}

}
