package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.TalukaRepository;
import project.app.shared.location.Taluka;
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
import project.app.shared.location.District;
import project.app.server.repository.DistrictRepository;
import project.app.shared.location.Region;
import project.app.server.repository.RegionRepository;
import project.app.shared.location.State;
import project.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TalukaTestCase {

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

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
            country.setCapital("mo5ecglox7lZSpZdw51aMKCbJH2flte5");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(2);
            country.setCountryCode1("2KY");
            country.setCountryCode2("5qf");
            country.setCountryFlag("Z8j2JW3lMWcKe6HVxgOMq34JqicIKS8iNYrQHdiy2PvXi08aHg");
            country.setCountryName("byWJIqLh2xh1xZ5CQME3GgHIkCfgpIXFt5w6pfS4HcD6QRLC27");
            country.setCurrencyCode("GXH");
            country.setCurrencyName("1RNB8i5YlIy53teWi9rmZrMCqICMiBUiUNKvy0YGdcwyVrp3YL");
            country.setCurrencySymbol("EvANxvFIyPE5kWBorduZKcxrH6XEeOCI");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("HlArlaWLE6MHSjITOK40gAlTB6Hm2DIe");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("jHxtKBx2u30s3A5NTrKUjBJLP7BhG82hm0da7DlsiL2Tpi0fOv");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(11);
            state.setStateCode(2);
            state.setStateCodeChar2("5DgIlb7mliwBDwmuU4z5qsT0c1NVGA3a");
            state.setStateCodeChar3("cVUsVH94P1nCvhGpagEQ6363Fb1kbHX4");
            state.setStateDescription("Jd5Fdtir4nbwHL6Cnnm7lRo45q9v6vDZed9iqrsYx5Sy37J4Mh");
            state.setStateFlag("9UNLInfG7gSKskyQyXlSSNWPOcFYHT7yUg6kDq5Z5d5b7kuSwO");
            state.setStateName("ygC2fEBzvKxoxDTw2ConnLVEdPLfQl37xRhEZV2oZy3hsTlHG3");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(1);
            region.setRegionCodeChar2("EpCJ17Gnw7KKvj2YwB8439ZaLNSPplhi");
            region.setRegionDescription("Nj6qakv35Yd9FspZVU0aI6HTqB6rQmJTJkGPV4rBJ7rYlT9naP");
            region.setRegionFlag("zztSKRcGpBP9HHzzIsUJw9VSwgAvhHMkrKfHx0TEXwKSOqoPTI");
            region.setRegionLatitude(11);
            region.setRegionLongitude(7);
            region.setRegionName("dB9RtLo7YiANV2Tmov9a3cO5UbUkmYRpRjdHJGl4O5FI7nat28");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("tzOxdxFdwSZ08jERpnLKz51sAlBBsOQA");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("NIhk3EzpOm6vli9DTMm287JdWqkLTJkOv3F7ex9HSuLGfItMzE");
            district.setDistrictFlag("bkurBbtMWWFLhuG10pjd59WFXS7iYInAdzshtPRrtojGFcfnV8");
            district.setDistrictLatitude(8);
            district.setDistrictLongitude(0);
            district.setName("NqdUygx4AoQ76JDUCe1tt2PHxYmQKF3h99m20jNeHWDSWk1Trt");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey());
            taluka.setTalukaCode("bzAYPyRUZUczOjVYWjguGGhDV3W6CeWg");
            taluka.setTalukaDescription("JCJdXlOJ4VR09mR8ir155i81eH8BTuJhGsq6vQiP2ErVxxJkAs");
            taluka.setTalukaFlag("5qGPNRle7VSyKsVx7BkK0wawq1l34vpoj5yzZ2hEplMqzbWhrZ");
            taluka.setTalukaLatitude(2);
            taluka.setTalukaLongitude(11);
            taluka.setTalukaName("EMT1ATAEjF2ZuvglN3u9JiytC1qsq6mI6tL7FWrO2RBW6rLXWe");
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            taluka.setEntityValidator(entityValidator);
            taluka.isValid();
            talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            Taluka taluka = talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
            taluka.setTalukaCode("Qm8efB4W0N5WTr5tIMFoJJPOt9WDxlxX");
            taluka.setTalukaDescription("z1BocVBOsp2u6KdfFrzAIDmbT9x5pmWV8ji2ukEmSBx8TxBw7t");
            taluka.setTalukaFlag("8bKJXxgFelSbAiiCz2WsXiDF5oxEG1ozJRP7sDvIJQU9ddk8FV");
            taluka.setTalukaLatitude(11);
            taluka.setTalukaLongitude(1);
            taluka.setTalukaName("pTwDWgPRrzCXXLINfezK7swJMeCHjtjdyo44RUS5RlqQzeZfUG");
            taluka.setVersionId(1);
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            talukaRepository.update(taluka);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Taluka> listofcountryId = talukaRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Taluka> listofdistrictId = talukaRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Taluka> listofregionId = talukaRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
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
            java.util.List<Taluka> listofstateId = talukaRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
