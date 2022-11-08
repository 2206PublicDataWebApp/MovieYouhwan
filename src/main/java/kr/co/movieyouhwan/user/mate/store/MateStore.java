package kr.co.movieyouhwan.user.mate.store;

import org.mybatis.spring.SqlSessionTemplate;

public interface MateStore {

	int selectMateStatus(SqlSessionTemplate session, String memberId);

	int updateMateStatusY(SqlSessionTemplate session, String memberId);

}
