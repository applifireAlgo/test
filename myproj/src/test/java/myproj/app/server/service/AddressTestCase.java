package myproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import myproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import myproj.app.server.repository.AddressRepository;
import myproj.app.shared.location.Address;
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
import myproj.app.shared.location.AddressType;
import myproj.app.server.repository.AddressTypeRepository;
import myproj.app.shared.location.City;
import myproj.app.server.repository.CityRepository;
import myproj.app.shared.location.Country;
import myproj.app.server.repository.CountryRepository;
import myproj.app.shared.location.State;
import myproj.app.server.repository.StateRepository;

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
            addresstype.setAddressType("KVNG8O6rjBfUBajkySu33jmx1xWAJQGiwbPc6J6G16tuo5bJyR");
            addresstype.setAddressTypeDesc("Q8FU3VnFkoAN6bsLJKAvWIdmz0SJO46Om8ERCHOgpFixwp84ti");
            addresstype.setAddressTypeIcon("p09tKvNdyOj8eaTu0ISu5NP6HOXzr0tAt2VjwivRs28xHAUhDl");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("r7vizLVBiKD9eDoNVz2mk6O8eiwUlTRH");
            city.setCityDescription("Eid5tCYe96J4iznJGPBWqRMO4DGL9gFSPebbPNSqbtUhZvsDVq");
            city.setCityFlag("rDVeVLNXLZAxe3dBZ9jRchXrN0Xu7WP11eP98FBpcju3TC2Ygu");
            city.setCityLatitude(8);
            city.setCityLongitude(8);
            city.setCityName("DVnkmCBkkeD0k2k4MtUHP3UBbgElWG006371jC0qMdYkXws497");
            Country country = new Country();
            country.setCapital("Up1TtV9RCoMzWAcKulWdaPKBRlQwkNEw");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(5);
            country.setCountryCode1("I3Q");
            country.setCountryCode2("TSq");
            country.setCountryFlag("b3O3eN6t1ws6SucBuBIl0pSPqMNDYbIgqDbZxH5f1bTqNU9KGW");
            country.setCountryName("NvEMpFF1d9UznMfM5MZvH6MYjlinIZVQgRMesss0SfqRSsOcVg");
            country.setCurrencyCode("eGj");
            country.setCurrencyName("yLOUFvTmxeAriIGJvM9btWf8NmWRhOg1FZcPfKlRMfWzNA4Dut");
            country.setCurrencySymbol("34N9LqYcdzFTkGPJgmO4EYJtaiagrunQ");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("vJQLMzxuUrQQIVrjvDGKooU39kLJrSzOAGkKuk7nSLJnLq787I");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(1);
            state.setStateCode(2);
            state.setStateCodeChar2("peyu4Xv2SEKIPBJrMnkOsUesahHwCfjp");
            state.setStateCodeChar3("zRFlWIXQ4zZztkR8AIKTCJ3g38GI9KnF");
            state.setStateDescription("TSthE9XcK4aZ8UzBQzxyG1SYKSahGMSoei3vjWuo6vgAPr6L3j");
            state.setStateFlag("xKHVk36lJmsoWUG9jtTgmkCIhU6aFQnczJCL6y6PxPShGzKxdN");
            state.setStateName("QIUIdehSBIP6B04CRuBg4KIVa9CF6Wb6JlvMCzq5FvnJWboKWT");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("dfdthuyWb1ezbaqwYaeOQ7d5YM7vEjaf");
            city.setCityDescription("mJtec8tRkcYTpFtsa3cogaGXg2hujghh8vH7Ue7k0jPbLgtj9z");
            city.setCityFlag("F7h11pUh8MsCcjF7gRCcnOWXpUOdMQwLB8K941E7QjRSsc7laI");
            city.setCityLatitude(6);
            city.setCityLongitude(8);
            city.setCityName("CD6X5qO2jN1qb8mfU8m415OPDtxJNBogy8FxF7ZKk8U7v3mdjb");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("QZA3sUTtGYPqxDwNQkFsh8pwQKZO50ifsUzoIVYq4tq3dES7x3");
            address.setAddress2("sRYQAuVoYHCQkh8nYc5p2WioGTGTptZ1hNSxnmSIzkgr1ntEwP");
            address.setAddress3("uyzMYK7NlO3mKSmiilbRwJeBDf7ulBl0JW8WqYWxfTiCcKELob");
            address.setAddressLabel("awJRD7JeAzM");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("fFdkMQ8KPMGqp5LbOZ5zkfPWl2JSk2UdRKRUTqFBiot42gqdQB");
            address.setLongitude("0DDWxoIr7pNDIpJbgldRgxMu3v2MPOEcLtKSyH2oloN0D9QEXN");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("WdhnWu");
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
            address.setAddress1("rjQwd4HQRepMPkYNbG0KxLugMcOZgmPAE4lnoySnZeB3OeIQdv");
            address.setAddress2("3Fw0cp4hLlwAExF0bWpRyUP7ajjkbYXODYDznASLIOSAZOx7HM");
            address.setAddress3("A1QNRviItheD9nKsS7yISSbzlrjp74VDNRH80cgD5tQ8VgQwsl");
            address.setAddressLabel("ljKtLbhbaf1");
            address.setLatitude("pZe8eR55ZOof6Ot1ZFvyDypqt8tUXDWVURyzgVeqVDTyPPOuUC");
            address.setLongitude("H8ZS3bxhNToGb3yae0ix8rIMfHJKpMKlzNQGP5RuQFkkcltOxe");
            address.setVersionId(1);
            address.setZipcode("h4Rws3");
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
