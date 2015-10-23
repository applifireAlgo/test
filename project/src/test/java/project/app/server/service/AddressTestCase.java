package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.AddressRepository;
import project.app.shared.location.Address;
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
import project.app.shared.location.AddressType;
import project.app.server.repository.AddressTypeRepository;
import project.app.shared.location.City;
import project.app.server.repository.CityRepository;
import project.app.shared.location.Country;
import project.app.server.repository.CountryRepository;
import project.app.shared.location.State;
import project.app.server.repository.StateRepository;

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
            addresstype.setAddressType("kQJyu7eETCsd0IZGzAyj0mlWM7gq7drg8mmf7bnSOYVpi1e6F7");
            addresstype.setAddressTypeDesc("VRPY2VaWipFPKIw6npiq8ke6lUh1tiy65Hdew0pgLtt5ZGYvOl");
            addresstype.setAddressTypeIcon("73ztCXV2lCY3wsxsq7eSMTvr4Y23TrmZOyyFPudyrVbmGauvBd");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("xV4TnJT4Fur6dU7B9sv1Sp602ex616So");
            city.setCityDescription("LM1UK1ANkzldu8BMsw8PsL8BgqBjluhQogVbPD9KKVIwz9Ia7a");
            city.setCityFlag("qQ2k3hqQ7N3F94cG1hNkSHg1MDFlKW88ePgLq4QfDpskrTH9UH");
            city.setCityLatitude(4);
            city.setCityLongitude(4);
            city.setCityName("qcCOaTVGASi7lnHApU9Iji4YdR7Z6vevNw6ZDE81ytMrIu0pHT");
            Country country = new Country();
            country.setCapital("9moR3dFeuL2k7ebICjI67yaeuaqQhYz6");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(10);
            country.setCountryCode1("h6A");
            country.setCountryCode2("ZJy");
            country.setCountryFlag("szWpPzKZSqqxcxUoIXFVAVmMNtUx0S0uft4eCuoO9nCoOFjVcC");
            country.setCountryName("7T81ePEgnpcSMv3nOorl5RLFIKFvoTNmfO0kJQvKn1RUTEgS5A");
            country.setCurrencyCode("7zJ");
            country.setCurrencyName("dSn0Wxhqjyy5UevhFaBzhTcmWfwzEV8gt4PdAqrj4dmDZkWqva");
            country.setCurrencySymbol("b14WquFooVqPmK1cJUEjWSnsxj5vM8HQ");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("nsfPPiGhXBWLS3EtXlWguID8iDFOdCcwiZxrPXtcx8r7gU6kJA");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(1);
            state.setStateCode(1);
            state.setStateCodeChar2("c3fnbY486bhm5msJfQyDSZ5w74qn7fbY");
            state.setStateCodeChar3("VNbGCnOVaIENj7U4Xub4GCEy69IRxctp");
            state.setStateDescription("BjHLQRiRdeO5UeXY670IoI2VQ2PA0YQpohs6Iq9YDeat1zscY8");
            state.setStateFlag("Rike2IbFNhXQptK3FvxwH5Rl95DFeJfSN94V5ey9eAionn7s2H");
            state.setStateName("QYHsPmhYWpT4y5KRa7NEFxlAiwWsPMxyWIIISuMtAjxU1ZSTHy");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("dWt2ijGfz8a3eCyT2InMuWCqkEbIZQLy");
            city.setCityDescription("qqt6pfoDy4ROZjOaw6BTXZbDZgARYGkRMuNyrS1TxJYBVJCsmw");
            city.setCityFlag("1aqqWKY18k94F8ask778MrsWUbOmhrt6wazrS3rsFQGYjsytIz");
            city.setCityLatitude(2);
            city.setCityLongitude(4);
            city.setCityName("Tylqr9xBPupkaKgdJ4aLKE8k73zXjDf6BHJG5WqyxPP9l83Kt5");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("l83tcJpYxo1Yg04OKjFkKo2uXRWitkJSKbQ7bj5FMBeuTPQMqk");
            address.setAddress2("k9zitq35Ie29HiszxEqUC8XpmTLxcu0zpSg4t6fYKVpc0SGyjL");
            address.setAddress3("neEgnIT0dY83j5sSdQuTr0T254m7Crbj1V1naayqBRyQqPlxfs");
            address.setAddressLabel("4HKlD1e7FIL");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("HFmvWIeLvQo8EZtKcd05UQ4vBgdNOVQMkKl32Q1ux29QG6Qagm");
            address.setLongitude("bQj5g8LlJ0K5tGdwuC1ienFQ1MEwYrRKxz48VnN5zwiEAjOP1y");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("psLV9H");
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
            address.setAddress1("HRx5yH6mssLxMUfgRFLmLisLIbiglfDI543PFjXC5BDMjN0JIX");
            address.setAddress2("VAD8arMowM9JfQQ52i5hnCUfmBdFRsm94kvbeDzf8IcpcWkgSE");
            address.setAddress3("B2XHp9KQQXFEtiS2xJV0ZJNxhGKfHwfLo1XEkbUdGw6ZH4KgjW");
            address.setAddressLabel("W3PtZQeDzKD");
            address.setLatitude("36T1UgBY0QZduB8kfWeIPxghBg1WEWBw3BMbKlqRmaYP1PPQyU");
            address.setLongitude("VsBpq5N0p8wGOy7CalfOuyNMvruqlMfxLYtbNLlXaRMK8gkI7D");
            address.setVersionId(1);
            address.setZipcode("zK0Gmc");
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
