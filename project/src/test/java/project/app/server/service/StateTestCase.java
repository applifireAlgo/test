package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.StateRepository;
import project.app.shared.location.State;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import project.app.shared.location.Country;
import project.app.server.repository.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase {

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Country country = new Country();
            country.setCapital("OpPHunyOtaAogyNqua7XxYNzuG3kA79G");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(6);
            country.setCountryCode1("w5D");
            country.setCountryCode2("UYP");
            country.setCountryFlag("LokDp4GJKyV8CcuUvwdKNrxiE8VR2fnIHVfEc2EDZXOHN3NKii");
            country.setCountryName("5D8AVkme8ArVauRZvsrfCA91z2Tx0mpBONqnzNLM6JW0wHUYgt");
            country.setCurrencyCode("aND");
            country.setCurrencyName("GFoZ8Nnv4z2aanLT5rdrsPoKvlth2t9MKamlO3OXgbcMW3OauB");
            country.setCurrencySymbol("visWQuUd3TrsCQcQxgtdhIS2TU422ya6");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            state.setStateCapital("nCSPFRWCnKEazJBUVCsO9skDLm8HkTUUcetNjC5T1rCVnrrtDW");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(4);
            state.setStateCode(1);
            state.setStateCodeChar2("AVWJABDJa4ZsUzWqRrwvZnvflfjE0wZN");
            state.setStateCodeChar3("acaO70aK3HLoleSdSdEQK5kyjoDlRaS9");
            state.setStateDescription("cW01zjiKCqGAKBWyrSoKdwdhj2vbc49hFJF0NfQu8dZLZP3bHd");
            state.setStateFlag("1QygAvEK8HySCG7vnelZRmTzgAfv95PoRGMcF0ZivX6XNkdnCv");
            state.setStateName("7SdZOQFqnBQv6i6GTbGVBG81SKnWXNMC6yic76dJDoGaO9720G");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.setEntityValidator(entityValidator);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCapital("jpfmb1q6jFKRmlKelnslXlPFpqX4bUlYaRI88GK0vLL9FwwhDE");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("qzzZrnFvGs4g4ZO7EcaawGYXXJDmPQew");
            state.setStateCodeChar3("f7FDxZwy8Y4q1ESKqayzsrLsr8USZQFZ");
            state.setStateDescription("NVAwPSOc4875Vi03SNIAaeu1S7zK4Tpz7Ru43WBKUBA3u6ychT");
            state.setStateFlag("cb2Qj0TYZgo8cgyPTJ3WE5fbIbvh4m7kxE62h5bG2orgcWFplW");
            state.setStateName("L3RHp8hz4NSyzH8WBO56Ff4MXGe3rVuXeaVDLS7b0zS4xxr7m1");
            state.setVersionId(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
