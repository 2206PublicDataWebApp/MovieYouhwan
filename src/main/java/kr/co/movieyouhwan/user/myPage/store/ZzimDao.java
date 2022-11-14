package kr.co.movieyouhwan.user.myPage.store;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.myPage.domain.Zzim;

@Repository
public class ZzimDao {
	@Autowired SqlSessionTemplate session;
	/**
	 * 찜 저장
	 * @param zzim
	 * @return
	 */
	public MovieList saveZzim(Zzim zzim) {
		// MOVIE_TBL에 해당 게시물의 zzim수를 +1하기 위함
		MovieList movieList = new MovieList();
		movieList.setMovieNo(zzim.getMovieNo());
		// 해당 게시물에 zzim +1함
		session.update("MemberMapper.movieListZzimUp", movieList);
		
		// ZZIM_TBL에 추가
		int result = session.insert("MemberMapper.movieListZzimSave", zzim);
		
		// ZZIM_TBL에 좋아요 추가 성공하면 갱신되는 하트 갯수를 가져옴
		if (result == 1) { 
			int zzimCount = session.selectOne("MemberMapper.movieListZzimCount", movieList);
			movieList.setMovieZzim(zzimCount);
			
		}
		return movieList;
	}
	public MovieList revomeZzim(Zzim zzim) {
		// MOVIE_TBL에 해당 게시물의 zzim수를 -1하기 위함
		MovieList movieList = new MovieList();
		movieList.setMovieNo(zzim.getMovieNo());
		// 해당 게시물에 zzim +1함
		session.update("MemberMapper.movieListZzimDown", movieList);
		
		// ZZIM_TBL에 추가
		int result = session.delete("MemberMapper.movieListZzimRemove", zzim);
		
		// ZZIM_TBL에 갱신되는 하트 갯수를 가져옴
		if (result == 1) { 
			int zzimCount = session.selectOne("MemberMapper.movieListZzimCount", movieList);
			movieList.setMovieZzim(zzimCount);
		}
		return movieList;
	}
}
