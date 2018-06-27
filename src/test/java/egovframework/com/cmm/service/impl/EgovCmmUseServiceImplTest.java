package egovframework.com.cmm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:egovframework/spring/com/**/context-*.xml")
public class EgovCmmUseServiceImplTest {

	protected Logger egovLogger = LoggerFactory.getLogger(getClass());

	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService egovCmmUseService;

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	@Test
	public void selectCmmCodeDetail() throws Exception {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		List<CmmnDetailCode> selectCmmCodeDetail = egovCmmUseService.selectCmmCodeDetail(vo);

		egovLogger.debug("");
		egovLogger.debug("selectCmmCodeDetail=" + selectCmmCodeDetail);

		selectCmmCodeDetail.forEach(result -> {
			egovLogger.debug("");
			egovLogger.debug("result=" + result);

			egovLogger.debug("getCodeId=" + result.getCodeId());
			egovLogger.debug("getCodeIdNm=" + result.getCodeIdNm());
			egovLogger.debug("getCode=" + result.getCode());
			egovLogger.debug("getCodeNm=" + result.getCodeNm());
		});
	}

	@Test
	public void selectCmmCodeDetails() throws Exception {
		List<ComDefaultCodeVO> voList = new ArrayList<>();

		ComDefaultCodeVO vo = null;

		vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");
		voList.add(vo);

		vo = new ComDefaultCodeVO();
		vo.setCodeId("COM002");
		voList.add(vo);

		Map<String, List<CmmnDetailCode>> selectCmmCodeDetails = egovCmmUseService.selectCmmCodeDetails(voList);

		egovLogger.debug("");
		egovLogger.debug("selectCmmCodeDetails=" + selectCmmCodeDetails);

		selectCmmCodeDetails.forEach((k, v) -> {
			egovLogger.debug("");
			egovLogger.debug("k=" + k);
			egovLogger.debug("v=" + v);

			v.forEach(result -> {
				egovLogger.debug("");
				egovLogger.debug("result=" + result);

				egovLogger.debug("getCodeId=" + result.getCodeId());
				egovLogger.debug("getCodeIdNm=" + result.getCodeIdNm());
				egovLogger.debug("getCode=" + result.getCode());
				egovLogger.debug("getCodeNm=" + result.getCodeNm());
			});
		});
	}

}
