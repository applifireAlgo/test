package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.CityRepository;
import project.app.shared.location.City;
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
import project.app.shared.location.State;
import project.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase {

    @Autowired
    private CityRepository<City> cityRepository;

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
            country.setCapital("yRha2MB7IMOyZqMbHmPSPos9Z4aT90Vx");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(0);
            country.setCountryCode1("Hxg");
            country.setCountryCode2("sBZ");
            country.setCountryFlag("OCAHboPuT1z4pvyG88PpuAnXrnc9ApiFFx2Up0IWwr7KYLWPnv");
            country.setCountryName("NFysG5wg03Hficgd1nlSTSOCZWOIfmjeNwbKp7hYcVxyrJ0Bmi");
            country.setCurrencyCode("R6s");
            country.setCurrencyName("f2p6CczGwCi0PZwKQkSfKl3wVQVouJtYQdumjsiUXdw4yOKg7i");
            country.setCurrencySymbol("VeywNRtLM0D3Jfa8IrQKZPcFCQHi2N4O");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("LsdwgveXz3HWaF4WCe7oFI1Kb48dwpcc3ePzQoBMfC8n5aFlsd");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(3);
            state.setStateCode(0);
            state.setStateCodeChar2("NAol4Aqi3WPWcAwsSWVr5pgiOmY2Iqrq");
            state.setStateCodeChar3("bMqgMYPD0m18ZvYnSLRfiR5pEAbhpOiI");
            state.setStateDescription("zKgni3v5wAePSYaj1g3KtADK6F1jR3giW8i8Ow1YdwX9R99dIG");
            state.setStateFlag("J4JC2b8hCwNB1ZLwo5PZuP7VmqHZpjhqpbIgpTQBcU1BSuoe7O");
            state.setStateName("umxzLL8Jdb1oe4c1x90CgJCsqMCqLeffAi8Yuo12wjGubg80eM");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("WwChPmvAKeU6KGG3lqQJoHFac8D2ftCi");
            city.setCityDescription("wzuUbCWkUgu0GpqRtSYcWJZzEwgjskL3CiG2maXzOvhZZqz5eL");
            city.setCityFlag("EfsaetedxoWEadJFmK8dl17w3ft1o7v4AfPQO6TpevUUIGVVx2");
            city.setCityLatitude(5);
            city.setCityLongitude(8);
            city.setCityName("SEhmRz8LVdo1x3dljYj6gN5lkWNL0AKJqRYu4qaYAPai4CsRy7");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey());
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.setEntityValidator(entityValidator);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityCode(3);
            city.setCityCodeChar2("IVM4mivHzsLxSy4InwSRlmbBhau91u9H");
            city.setCityDescription("srTjk37ekinBNlRRfUIZGXI0XAEVwq0q3NHJMPTrOzfaW43vjM");
            city.setCityFlag("Aqeyihk7bbrdRumRiDLJcx7JaTVpHqCEU8azY2a8tj2HZcjlNw");
            city.setCityLatitude(2);
            city.setCityLongitude(1);
            city.setCityName("SfLyoZmPycGuDz7oR5t8YOAdudE8FqXQ2WuL0OPqFa56iFnw3h");
            city.setVersionId(1);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
