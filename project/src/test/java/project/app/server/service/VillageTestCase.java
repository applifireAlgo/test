package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.VillageRepository;
import project.app.shared.location.Village;
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
import project.app.shared.location.Taluka;
import project.app.server.repository.TalukaRepository;

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
            country.setCapital("xbWegOzkX9HplegRO2MITyNDpVqNFxnP");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(1);
            country.setCountryCode1("jQJ");
            country.setCountryCode2("NTm");
            country.setCountryFlag("EZO6QyeiAO6uylX6AbdZUWJdQw58kBqr5cRGyi613exmcVJZmZ");
            country.setCountryName("QHis7b1RtKYeMg0psogvP8QRczW3Mh05hsrm9MfA7MUTRTl2Va");
            country.setCurrencyCode("D9i");
            country.setCurrencyName("fHt3eTaFQeFZ3j6MGNhsHOie9OsDoU0Oup9dsgVSpqesH1tZ7B");
            country.setCurrencySymbol("ewpFTD3q5yYDqe5w9x2lheOPY5yiUBVz");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("ip0pKPpRCVOAdkYArTGe05NdMp6g3Me6");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("9BK4xKz3tiJAWAwtfZ8Exf6x0OK32bdpDyc43BV2TimC6TroZV");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(5);
            state.setStateCode(1);
            state.setStateCodeChar2("SpqYXOdTWiQzo2bmxHtb9TXF83FY0qdM");
            state.setStateCodeChar3("IzQOrrHeDpUTnykLpGmA6JRXR6aSjDHF");
            state.setStateDescription("09OAy0FHbQbMBWToysLhb1B3z0YVxbwglbJASLRHKAryUr1apJ");
            state.setStateFlag("h6UzXViNJyJRRHBHZxpxejQdsEhpxkBbyZQKTKOZn9FLhaFNUU");
            state.setStateName("HPX19PuersbFmfTYEC1AogyFVnpwqaqVRw0tCFVFVOMHanF4Jt");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(3);
            region.setRegionCodeChar2("zRcwINjM7pV9WVPeYYMeVT1W1l4ZLUq8");
            region.setRegionDescription("20lLZoXEyb4mLerWlU1OAW33HV8praKC92WylzTDtZjWUhiUZf");
            region.setRegionFlag("e5U3sft3PuD2bdx9Bt2chWveI106YuxOkrWM7tTr7Unet4JDcu");
            region.setRegionLatitude(4);
            region.setRegionLongitude(3);
            region.setRegionName("nPWg3qesoWuZbH4cv3tcvPB7WSP4XL2R1zj0kPN13WjR929uha");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("y0mUHxDSXATRtuLAxGzg0KYVAItVLXLa");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("SbD2IAIDlfBa4itnGuCS2rTscLUKNywByRYLNJTArxBrywETIl");
            district.setDistrictFlag("I6zDtuWO909yLAKYFrIaks0wknOL0AlvYFe6kJC0VL2DqkYudX");
            district.setDistrictLatitude(10);
            district.setDistrictLongitude(0);
            district.setName("uLEtgPgg3UDZMoj6KvKvMHlRZQ7BfnH6v9b6PhanbYbG5Gwnt8");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("HiaH1AJ1zJjHRWxwS4pjQNIGbW5UA8E1");
            taluka.setTalukaDescription("vU6rupaqEhBy65kjMoC5pVy9I1g2m65iwH8a5TDuJPi9vOBgcL");
            taluka.setTalukaFlag("jbOH6wVEbFIgH4syOu1YewWMf3vHqW7emFAJna91nyRHx83grm");
            taluka.setTalukaLatitude(10);
            taluka.setTalukaLongitude(1);
            taluka.setTalukaName("KQdCIpC2QkUueT4VFzEf83QiZCqdWqHBil543NhmYeGQMBfzeZ");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("MxYq0JSbnr6d0dIv8qgLawIoLmpUnmft");
            village.setVillageDescription("De3BWHSYogniCugkQfGQw34goHiJkneNSxZN3NZZgOagZmmKYf");
            village.setVillageFlag("XVFXgDiY8Sxr3ta54vB9HnudaQAq9Ta2VFowO8cfN6WfwdIZgj");
            village.setVillageLatitude(8);
            village.setVillageLongtitude(2);
            village.setVillageName("RKschZOyxb11tkpQcRKdOSGY8g3DR7txxINRult3GP2b1oFtqi");
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
            village.setVillageCode("9TH8IfgeqGStDQENgQ3QNX1YOc191wZc");
            village.setVillageDescription("sIAI5MtGUe35TXeKiOVKuF4l4YUaGo5cHaQvisyYgERp6lYYVv");
            village.setVillageFlag("QF5r0E4ICf9Rtw8lm3CGBsKu1tyvxdXd8rJuKN46m6MkrQ9paS");
            village.setVillageLatitude(1);
            village.setVillageLongtitude(0);
            village.setVillageName("3d3DQNLImYXFaIL6xK091OOy2976qBNl0I8vBHdkYNitMWLQKn");
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
