package kr.co.movieyouhwan.user.mate.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.user.mate.service.MateService;
import kr.co.movieyouhwan.user.mate.store.MateStore;

@Service
public class MateServiceImpl implements MateService{
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private MateStore mStore;

	@Override
	public int printMateStatus(String memberId) {
		int result=mStore.selectMateStatus(session, memberId);
		return result;
	}

	@Override
	public int modifyMateStatusY(String memberId) {
		int result=mStore.updateMateStatusY(session, memberId);
		return result;
	}

}
