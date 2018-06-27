package egovframework.com.cmm.service.impl;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:egovframework/spring/com/**/context-*.xml")
public class CmmUseDAOTest {

	protected Logger egovLogger = LoggerFactory.getLogger(getClass());

	@Resource(name = "cmmUseDAO")
	private CmmUseDAO cmmUseDAO;

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	@Test
	public void selectCmmCodeDetail() throws Exception {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		List<CmmnDetailCode> results = cmmUseDAO.selectCmmCodeDetail(vo);

		egovLogger.debug("results=" + results);

		// Guide to the Java 8 forEach
		// http://www.baeldung.com/foreach-java

		forEach(results);
		forEach2(results);
		forEach3(results);
		forEach4(results);
		forEach5(results);
		forEach6(results);
		forEach7(results);
	}

	private void forEach(List<CmmnDetailCode> results) {
		egovLogger.debug("");
		egovLogger.debug("2.1. The Consumer Interface");

		results.forEach(new Consumer<CmmnDetailCode>() {
			@Override
			public void accept(CmmnDetailCode result) {
				egovLogger.debug("result=" + result);
				egovLogger.debug("getCodeId=" + result.getCodeId());
				egovLogger.debug("getCodeIdNm=" + result.getCodeIdNm());
				egovLogger.debug("getCode=" + result.getCode());
				egovLogger.debug("getCodeNm=" + result.getCodeNm());
			}
		});
	}

	private void forEach2(List<CmmnDetailCode> results) {
		egovLogger.debug("");

		Consumer<CmmnDetailCode> action = result -> {
			egovLogger.debug("result=" + result);
			egovLogger.debug("getCodeId=" + result.getCodeId());
			egovLogger.debug("getCodeIdNm=" + result.getCodeIdNm());
			egovLogger.debug("getCode=" + result.getCode());
			egovLogger.debug("getCodeNm=" + result.getCodeNm());
		};

		results.forEach(action);
	}

	private void forEach3(List<CmmnDetailCode> results) {
		egovLogger.debug("");
		egovLogger.debug("3.1. Internal Iterator");

		results.forEach(result -> egovLogger.debug("result=" + result));
	}

	private void forEach4(List<CmmnDetailCode> results) {
		egovLogger.debug("");
		egovLogger.debug("3.2. External Iterator");

		for (CmmnDetailCode result : results) {
			egovLogger.debug("result=" + result);
			egovLogger.debug("getCodeId=" + result.getCodeId());
			egovLogger.debug("getCodeIdNm=" + result.getCodeIdNm());
			egovLogger.debug("getCode=" + result.getCode());
			egovLogger.debug("getCodeNm=" + result.getCodeNm());
		}
	}

	private void forEach5(List<CmmnDetailCode> results) {
		egovLogger.debug("");
		egovLogger.debug("4.1. Anonymous Consumer Implementation");

		Consumer<CmmnDetailCode> action = new Consumer<CmmnDetailCode>() {
			@Override
			public void accept(CmmnDetailCode result) {
				egovLogger.debug("result=" + result);
				egovLogger.debug("getCodeId=" + result.getCodeId());
				egovLogger.debug("getCodeIdNm=" + result.getCodeIdNm());
				egovLogger.debug("getCode=" + result.getCode());
				egovLogger.debug("getCodeNm=" + result.getCodeNm());
			}
		};

		results.forEach(action);
	}

	private void forEach6(List<CmmnDetailCode> results) {
		egovLogger.debug("");
		egovLogger.debug("4.2. A Lambda Expression");

		results.forEach(result -> egovLogger.debug("result=" + result));

		egovLogger.debug("");

		results.forEach(result -> {
			egovLogger.debug("result=" + result);
			egovLogger.debug("getCodeId=" + result.getCodeId());
			egovLogger.debug("getCodeIdNm=" + result.getCodeIdNm());
			egovLogger.debug("getCode=" + result.getCode());
			egovLogger.debug("getCodeNm=" + result.getCodeNm());
		});
	}

	private void forEach7(List<CmmnDetailCode> results) {
		egovLogger.debug("");
		egovLogger.debug("4.3. A Method Reference");

		results.forEach(System.out::println);
	}

}
