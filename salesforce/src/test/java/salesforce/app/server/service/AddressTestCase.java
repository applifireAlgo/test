package salesforce.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesforce.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesforce.app.server.repository.AddressRepository;
import salesforce.app.shared.location.Address;
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
import salesforce.app.shared.location.AddressType;
import salesforce.app.server.repository.AddressTypeRepository;
import salesforce.app.shared.location.City;
import salesforce.app.server.repository.CityRepository;
import salesforce.app.shared.location.Country;
import salesforce.app.server.repository.CountryRepository;
import salesforce.app.shared.location.State;
import salesforce.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("ejVpEQn7c7UqLt7vqE94B9PP5mkiDf3acPOluoVBWY4pFwVRG2");
            addresstype.setAddressTypeDesc("SbYIk6B3SE24XRq7GSiXAAOOUACxhvjHyyWKRYtKVzJN26e9LY");
            addresstype.setAddressTypeIcon("UNxCmWEqtv28AFlgZFs3f7vNcCUxrTVsOdQDoOyGB4P0lLhqv4");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("UfT3ItapGEDAE5lKLURWmDRD5BmLDMs4");
            city.setCityDescription("llU5CcENeZi26MiMfvh0kdp0B335T9W0fHPqL4T5ZM13pKlFrA");
            city.setCityFlag("5Scx70EGDHcivfaBwilW7qzhs43lb87p3fyGAADZNiwEEBTnTt");
            city.setCityLatitude(0);
            city.setCityLongitude(6);
            city.setCityName("0WGihOIHeau19GZvIs3XjZ1WtcQksvLNQK38AAvufj0kqOm1mq");
            Country country = new Country();
            country.setCapital("oVj6AOZpdUk8lcybdDrSlms4Ljdn5wtp");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(11);
            country.setCountryCode1("X9f");
            country.setCountryCode2("3K3");
            country.setCountryFlag("mfKvxJXg9ZY1pSUe73Cp0HWO5jEp1OWmvtob7l2x3ttgNALkkG");
            country.setCountryName("Fh00F7X83v2waRFxAzSdrXKLIJnXYNeOKJTCTn0Lq6E5ooRiBl");
            country.setCurrencyCode("mxR");
            country.setCurrencyName("TEZRHOz4ZcNdeInedHY1j2xBo5IrHQ0tHxaK2a3phpfyFsAxm5");
            country.setCurrencySymbol("x4hhDyllz0M77YPkktLw52tUGDcLQ2O3");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("OkjjycDoMsKC0Zxd37P1oJ5pkMRGYeVePqD3AY0WJXzuK30gQJ");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(10);
            state.setStateCode(1);
            state.setStateCodeChar2("55Fpdeux5G0NkvzcuN4Uo6iz9r4FSSXB");
            state.setStateCodeChar3("UKUNSxtGclNQTaapcZPcv6gojfyQ8gra");
            state.setStateDescription("f9fM26Jf3LUYwc4Ox2WLWYH7pkrcf4iXy9AkaEOsDLG67FgjR1");
            state.setStateFlag("GnDdPVGDy9iU8mIqR3W3mC04LjITujCJdu0veWh1B2i9HO2BSu");
            state.setStateName("gyQxz4NsDBf8xTNXWDNDjHD7xLt7ssrC9jIaVN0aFO922aPcoG");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("zejE37jCx1j6WlHFtn3BHr2EjRMPnbo2");
            city.setCityDescription("YRMpAsZXDFRsDrAg85Zt4Lk9NO1DcpKvEECPKZfOhdbdNXwZyV");
            city.setCityFlag("tuCNqpYR6ovikvhcmcTkEOubkl2yLG2cgCEmesxw1cPAxcqZWD");
            city.setCityLatitude(3);
            city.setCityLongitude(9);
            city.setCityName("hYdeFM7qSKqZ9fjiFgBQfBHPelbVI5ppEbelOTJ9DpBtXAXyCN");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("mzpL2fjBeQI3Nx9nIkGKMBqIGSpRo78D2eGRRFQaKU7r19tEXN");
            address.setAddress2("Tq5XqblueziTxH563mhsi6eVxJ3yiczspVAZFAAxI9gugVleSK");
            address.setAddress3("NkpiUFv5OQAKjkqhi1c8iGE9x06UrZu1R1Ua0fSSCslo18VXmS");
            address.setAddressLabel("kiPET2CqXlA");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("00MXp3SyNpRcOQas4DBWew2S2Jbdwq6ULqRZz99lXehkHdHORh");
            address.setLongitude("mQp78HPTUHdAZtBZMwqzSHO25Auplvh2hUR46CwOYKRvlDiSx3");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("voXYQj");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("VgDY9m4nYANWZVpKtTIZwrkDe91ytUpfHHYVv2cHgsLpv48v25");
            address.setAddress2("hKJMG2VSCea2QUa4QhIOmsPVlEpopVCm5JEMm3pmdDq4RQ0JH5");
            address.setAddress3("afoUNy6jDOrOuI0N2LQuYshSDjoVWrXjaUEfseFZZQRM5KGnot");
            address.setAddressLabel("TfBHSU17h1m");
            address.setLatitude("Vby8f3Fxn10FIEHlHaUHTh2b1nqjwHkiNqpuCvITfDD0JWnXGc");
            address.setLongitude("4C0EfHqrlKRa9Fbzt3ZIs7pT4IFVD5pEHniDsQF49UlA4ZOCa7");
            address.setVersionId(1);
            address.setZipcode("W90OCV");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
