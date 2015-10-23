package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.CoreContactsRepository;
import project.app.shared.contacts.CoreContacts;
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
import project.app.shared.contacts.Gender;
import project.app.server.repository.GenderRepository;
import project.app.shared.location.Language;
import project.app.server.repository.LanguageRepository;
import project.app.shared.location.Timezone;
import project.app.server.repository.TimezoneRepository;
import project.app.shared.contacts.Title;
import project.app.server.repository.TitleRepository;
import project.app.shared.contacts.CommunicationData;
import project.app.shared.contacts.CommunicationGroup;
import project.app.server.repository.CommunicationGroupRepository;
import project.app.shared.contacts.CommunicationType;
import project.app.server.repository.CommunicationTypeRepository;
import project.app.shared.location.Address;
import project.app.server.repository.AddressRepository;
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
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("rAGTOnHiOADlR2zkYTMJtBLinzOosAEqxlwnoL5QrjkP0PQYic");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Vl");
            language.setAlpha3("qs6");
            language.setAlpha4("KADn");
            language.setAlpha4parentid(0);
            language.setLanguage("UWyyDPOF8fm6hoErXWUjFXfsOIDnwvVgaxfi7SNrpHrottJ6l6");
            language.setLanguageDescription("bkbjKMXt2gz4Oxz7ONC94wwO6NpMOsrQ7ep314wiT9CJnjJQQJ");
            language.setLanguageIcon("v36bZDtxCtjXiDtRqD7nPl9Ssn0u3DJoPLvCaXWiCuhAwv5xyQ");
            language.setLanguageType("ABFG95tXFQrWpLAcLMFAnUQXjSo4djTD");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("ivs09WivlMxoggcfrDpyChPLtVBN87ZDgnkDp58GTv2U6I22ov");
            timezone.setCountry("3mDE9RK4mLLPIunoXENxtcHoDaTsBY1boM4kM0rVTS3SWGspy7");
            timezone.setGmtLabel("Om2YTukofzgySAu4lDLf6bGgK0d4YVLYzVA1nH78xkqBmTBixz");
            timezone.setTimeZoneLabel("H6ItQVbEWjh6TP4rTgqHd4Q8EhxCBcfDxI2GvC4yiIUmyaatyh");
            timezone.setUtcdifference(9);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("v5Q6lxuNx3NGsABUABvkwjYGdmoNbzgdWe10fvHBmlkZVWGrHT");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(20);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("JRYLdeuh2ipEY8zBT4JrVveasPsdjUqkbrPg5Zy9zo0YoGY135");
            corecontacts.setFirstName("GlvOXooUaQm4C2k3YqykK19SFfbyKcM4espDpIQJraVOMarGNM");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("x47qoVstkC7GXrHlVSXMLFXGMvSaGMsnOQeaEx0sZ1VnnGwkN9");
            corecontacts.setMiddleName("3aIUPbvhRkn7KIRqyXI9AoETqJOMXK8wSj37qYscGQ3mPwXTJm");
            corecontacts.setNativeFirstName("xgXBAKC9XlXbxH2QcZg9T7tv9DrdKVZ0gRul6m7rntkVLEfjH9");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("JClrVUAGfKtbWQGhP4PUXytuYgNlLnGT1lRKUnt4jSFwySn86p");
            corecontacts.setNativeMiddleName("EXr5q2bkz2IASMuN8UZGJh02zKsemdTLWMSLYik6c1wjBUtH2U");
            corecontacts.setNativeTitle("bUUMdBnU3Qy0RilcdFzN271VfoIiBbepG5MTy1xGr3T68tjlaZ");
            corecontacts.setPhoneNumber("an16c1ycKTsaGjkmqjxx");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("bX3");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("bI00zt1APc4OSa4ya9Omkt9uLolvitTRk0tqCWB8a3V0J5PMI5");
            communicationgroup.setCommGroupName("s9ODQL1f7JQjQvNVQagJfeOIO6rtBeGZvnMACtru867avQ18eO");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("sirSV2hw3ZbtAXuvroloM5ceYSbfatkdW7dsg9xAg5tsEsXt8y");
            communicationtype.setCommTypeName("6pxBnUQwLCAqDrJtDnpHjADdQMeLGSm5Izqz9bKbkTgJ8SYtpe");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("mK2");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("kQBd5djGKK7SXPeBfFzbLIQlPl09a2rMgJNlOFwnXnJ3m6hLx1");
            address.setAddress2("NH6fFUTZkU2OZ8NVVzzZO2P3phEi3Eg433x0dvhBj8qPJDUg55");
            address.setAddress3("3eOAyW2klnE3KeeQH4wJnPWB5Uke5Aow8QF02Wie9tnjDjuqtw");
            address.setAddressLabel("D1C4azSoy1S");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("PZdfbaqCPJ0cZ0y5psTaglJuA9oICV9sOVybvs4gqQd9zx5B9Y");
            addresstype.setAddressTypeDesc("sMNxAkRGwGKc7Y2srlxG7SLjpJxbtGtWGMgDnkvWuVID2zn8v9");
            addresstype.setAddressTypeIcon("KMcQNIHWmbWA1M3xv8ovKkf5b1OegLRoulAYcsGcusmER7q7UA");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("NIpK4m6fDpYSkFOFYC8A2zeTRTuXsHuK");
            city.setCityDescription("QPnzcG7axaX2ctZACZ6E8kT6z12BoABIH0uMMDf5OwrVSOCSpB");
            city.setCityFlag("kFryZQoMVDH4nrhBFVI2rDoCSmZ6fTRAeIqsjqWxLsztilmB1M");
            city.setCityLatitude(4);
            city.setCityLongitude(1);
            city.setCityName("vX5ZACEjErO8bcG3SIgPwsSuvwXZiFJr37g7K4UgiUuZexL2ee");
            Country country = new Country();
            country.setCapital("rCBrrq2C2ONPn8NbNVWZWK8mt5dPbUr3");
            country.setCapitalLatitude(2);
            country.setCapitalLongitude(0);
            country.setCountryCode1("Ted");
            country.setCountryCode2("w3b");
            country.setCountryFlag("0arwNvPjaywOOfc7oWiYGNgqcyShiR45WrWDEswQ3iKuM8tlfB");
            country.setCountryName("w7ecilOD3kDG1OS2CBUQtcgzsQhxZ5uWA9Sv2B9sftahKgADKz");
            country.setCurrencyCode("8mu");
            country.setCurrencyName("TfQIlihmTWD6an5AwzFOugLi5aphGl17ZmmufDGNW8lmhhD82O");
            country.setCurrencySymbol("O1POlZiYIl68mVrgl6K37coR6gkTWZY1");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("eEMtUSoygpoATxZW6u5RiujpMd8aVQdbBNVbziOJbQgzJTJF1f");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(1);
            state.setStateCode(1);
            state.setStateCodeChar2("7RUR2E1Fm4b3znYiRmejPc3Wod7mGjiD");
            state.setStateCodeChar3("gClt08VascJLUlM1q2r1U9YB3nWQPOQp");
            state.setStateDescription("yJGCNFGPm9m2ajbRXKLdrUMqwC95uWNamzy53rmzJvbrULSELm");
            state.setStateFlag("1595lpYvJGZGGsfW6iLyjGAXUKFEmPAAo8CVZ5dbWTN2p4mzVO");
            state.setStateName("FXfOx4s4jzdBVBW2mymdPIcbF6qEZpMA4kmx33PYHTxbKEaxUe");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("WnBN3WW6RBor7E69PtiBJrHOTieBjbGn");
            city.setCityDescription("iaEnbNDx1XCrnxWhyibnM36sr22DYE5vNlnSWp5UNadDeedSwi");
            city.setCityFlag("2ZHu4RA8p1DzOLaMndQgsAkdZgqpc1OzHtJfQ33fDvW4kijBkf");
            city.setCityLatitude(6);
            city.setCityLongitude(9);
            city.setCityName("5qhHXvdzXe7Onw55FQfG57ognK0gCwy6vZXLslgmNNfr7vOY7z");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("9kcRyWTn2QlpD6mNEBS0ZpFUb9U0TtpXosBlxHLCJRlvRH4QK0");
            address.setAddress2("cfj45yKtc2lSE3G0nhbyl1dPu8gAwHzjGCsdQzP9POCWZCLGYM");
            address.setAddress3("Ly5cwKWjDMXmNYm8dI5lQzO70za1EdWNFucXR2VSccA5WKoidy");
            address.setAddressLabel("CW2H1AviyI1");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("4DxHbjf59GogKVG1YkDCe6Tk0qd8MjGExE0l5PZlA3gRgjJr5E");
            address.setLongitude("58HaNyAawTubFIZIFEhBM8Nk4L7l49krFSVVAHJIjaJUOop5Kp");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("kMsGVT");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(33);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("xqmfEo1VWmXNyWXPmKlO2mZKHR9SZkKr5TG9xYvzHfge4blLKR");
            corecontacts.setFirstName("yvaXAadgIlomR1gvdBr0sHU1hIiQElQsBF9RmNdVSL5yeeNWwX");
            corecontacts.setLastName("31hbi7jFmoGHlWz4wQ60b99Kal35GLlGXN4NWEb5L5mUjiN7sZ");
            corecontacts.setMiddleName("4qLIioZFD3IhdKkjVi6jic89smOoccCikKMXFkIFQoO5wyYeey");
            corecontacts.setNativeFirstName("G13nhZY1CjcDhwM5RFNaPFdPGZzHv9i2la9eWTHMe9doTVSOyw");
            corecontacts.setNativeLastName("ksxhDDxWpeSQqNeBlL0bZbxL27yD29aX6hIMCHvAhLjn2qDFxM");
            corecontacts.setNativeMiddleName("Dmntcs91lKGTMR8wAlnWt8Oq1zQP22RlSqX8kuuMa4Ytmc1Pe0");
            corecontacts.setNativeTitle("vE5vbKBY3fO6ibxzXGTz6yzSeuyBYzaTKiiJv4wqausmCSyJ3k");
            corecontacts.setPhoneNumber("DJx1H54JbBAIggmCJeT3");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
