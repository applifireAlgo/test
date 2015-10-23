package salesforce.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesforce.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesforce.app.server.repository.VillageRepository;
import salesforce.app.shared.location.Village;
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
import salesforce.app.shared.location.Country;
import salesforce.app.server.repository.CountryRepository;
import salesforce.app.shared.location.District;
import salesforce.app.server.repository.DistrictRepository;
import salesforce.app.shared.location.Region;
import salesforce.app.server.repository.RegionRepository;
import salesforce.app.shared.location.State;
import salesforce.app.server.repository.StateRepository;
import salesforce.app.shared.location.Taluka;
import salesforce.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

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
            country.setCapital("EOz3eHWMnng6VqaaeGxhWLwEMv8PNeiX");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(8);
            country.setCountryCode1("ZZ2");
            country.setCountryCode2("Vqi");
            country.setCountryFlag("J2TWy53eQpqZv7actlgLpBLNL7Eq5E5tnupvGnlWIRBgw5B9DE");
            country.setCountryName("WRCvOHvBRoF9hbCBOLgwFPrXNocQx5LYe01x4u0aD1W0TwUzBJ");
            country.setCurrencyCode("oi9");
            country.setCurrencyName("mwEYjI6ero3B11nr5Bjm0utDoQtsDFtXu9el061hTyo6m64q7v");
            country.setCurrencySymbol("99UIVIsWimY2qSfDWUfnQoAwO82tbkdu");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("np0ecWBPcbORgY6h5jOC7CFg62Lq3ziu");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("40rF0sl2MWgdh6T2a8r2OvTRCemOoLYgQdKvAdyfBWJLEHyFg9");
            state.setStateCapitalLatitude(10);
            state.setStateCapitalLongitude(7);
            state.setStateCode(2);
            state.setStateCodeChar2("0J72aftt936efBMgCIf9OJHNTXw97iIi");
            state.setStateCodeChar3("HLegde5tZy8dF3jyOhlbhLwvBW9hiOd1");
            state.setStateDescription("bl1I0Kd7NnAXJCZFAUBRZrG1VC0Nf5Q2kONjh6HbaCn8lurAso");
            state.setStateFlag("2busRtfNdbG1zdzA528QK8m0BjJYHiqkuMBdnANr1OVVCdk5RU");
            state.setStateName("EAUUiYFA2sFxkIeCU1f8IEIjN6Xmr06ObAbdJyZ0yc0iPsMArR");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(0);
            region.setRegionCodeChar2("1FpeM6FqHwvGPH9DPpICfAIOZbYmNZfB");
            region.setRegionDescription("hY0HlATJUpKigRYeG8jgx2okxpY4XWd8msy5ds20w030St5fRd");
            region.setRegionFlag("3JtixhmpW2NUMXZzgww2QpKMunNJGifOb4IwiLDKD97xk6q4zL");
            region.setRegionLatitude(9);
            region.setRegionLongitude(8);
            region.setRegionName("EAqCpzGRzGP8FgeG0x82jBDuv8l807HW3HENxo8f688eN2jU13");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("5RVmQm9cIkDQmKUghF2ZSzBcrPBP3YOw");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("jaNL4KLD5NDiEIMrRE5U8AJ9nyjzU0unyXfmzbYSd7pRXXvXs5");
            district.setDistrictFlag("0hhjN46yDdLhr9yLb9eqhebYlQOdJ1VyYFnUmUraqbpMEtXZ5y");
            district.setDistrictLatitude(7);
            district.setDistrictLongitude(10);
            district.setName("c3ruKJK9dZXoI2L3Pvyl9FP39Pi4hYp3UwTusszuO6yaCVvLTe");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("3b4co0auUxIOJH7XSHJXN3V80hlt5VOa");
            taluka.setTalukaDescription("whPwQOwZa9HwltcChOQ2p5dM3454ucJnQekJr5H4ZOlAAPozYy");
            taluka.setTalukaFlag("zHqHuKBp4cFFPNjKqsFaFdI5UkaZiHlpKK7lmUAtcz3AuHob3l");
            taluka.setTalukaLatitude(9);
            taluka.setTalukaLongitude(8);
            taluka.setTalukaName("XmM6ZtD7L8o4WVcIXN3UN8CB1unptxjSAEtWmsdUs90MMWyeqK");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("qWtnsvcAlyeOkPiwQIicZGzMMGsOkodZ");
            village.setVillageDescription("zWQ6C6NAVP9mjridfOv7gx6iSW3DhopseSqHbUWakLpgD5RYSC");
            village.setVillageFlag("DDSNwxZHvyBrMPSrPVKVXhIoiIKouKjVuLqPIJXei7c2ALkLRW");
            village.setVillageLatitude(0);
            village.setVillageLongtitude(9);
            village.setVillageName("X6Vo8643iwupdt8k5wzxQZgTh1amUC17TsZ8YhETaj3z2Zmm7U");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
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

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("2808P2zj4YNJlErLGn2fWTStxJUSfgLz");
            village.setVillageDescription("DbZPZrCBEwJj1tSMtKbPwlnKVjBbFpxINr8jCMtHAUFsmwjioL");
            village.setVillageFlag("VVT8E0E55xWzIeglmadQvgCBXM8OxrYfVYDbr2lfBdiDK19y3k");
            village.setVillageLatitude(6);
            village.setVillageLongtitude(3);
            village.setVillageName("gqDYtnGLbZ6j9kcwQM5JHdlIjzlYLb33nsEfPNRUs8D1A5Tn9j");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
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
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
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
