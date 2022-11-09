package kr.co.movieyouhwan.user.mate.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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

}
