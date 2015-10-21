package salesforce.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesforce.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesforce.app.server.repository.CoreContactsRepository;
import salesforce.app.shared.contacts.CoreContacts;
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
import salesforce.app.shared.contacts.Gender;
import salesforce.app.server.repository.GenderRepository;
import salesforce.app.shared.location.Language;
import salesforce.app.server.repository.LanguageRepository;
import salesforce.app.shared.location.Timezone;
import salesforce.app.server.repository.TimezoneRepository;
import salesforce.app.shared.contacts.Title;
import salesforce.app.server.repository.TitleRepository;
import salesforce.app.shared.location.Address;
import salesforce.app.server.repository.AddressRepository;
import salesforce.app.shared.location.AddressType;
import salesforce.app.server.repository.AddressTypeRepository;
import salesforce.app.shared.location.City;
import salesforce.app.server.repository.CityRepository;
import salesforce.app.shared.location.Country;
import salesforce.app.server.repository.CountryRepository;
import salesforce.app.shared.location.State;
import salesforce.app.server.repository.StateRepository;
import salesforce.app.shared.contacts.CommunicationData;
import salesforce.app.shared.contacts.CommunicationGroup;
import salesforce.app.server.repository.CommunicationGroupRepository;
import salesforce.app.shared.contacts.CommunicationType;
import salesforce.app.server.repository.CommunicationTypeRepository;

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
            gender.setGender("HVq2cwagLroyhN2SARAKDZGraoqwHTWdP39wprX0kB0mqYgEz1");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("ZY");
            language.setAlpha3("B3l");
            language.setAlpha4("oBQ1");
            language.setAlpha4parentid(1);
            language.setLanguage("TLzlGswseJgIPgNpcD8djXxA410RuU9MlU1la2wZzwvjBXjUH5");
            language.setLanguageDescription("bOBoUpnSXeJhZ5boNSTFsaXNbajqJAiOAmnfioyfyJbnwMQXUm");
            language.setLanguageIcon("UDpD7RCMqBpLm9JkL6HtSo7gaQFFiy0cQikOyZgYvtxtAxVxcL");
            language.setLanguageType("iym6MUccf2mOZnLReOMPI2jD1aFujgcf");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("NGgnQfoAw3PqvdWqReylYHBW0x1e64EHdiFQHmbDuXKCDpDPmm");
            timezone.setCountry("BjtoLPKzgsBCbKIQ8zdJgTaitaSw8cITNcgTIJANDWHszzSW3Y");
            timezone.setGmtLabel("PCMskZHtQeeCymDbYxWeWmQdIqaJAehkmFe0fsC5Zqmbb4MhP5");
            timezone.setTimeZoneLabel("tUu5T6AGTepw1WA0LZiHSYhBRU0bglqrePte4JYd8I20CpuQqh");
            timezone.setUtcdifference(4);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("07kl9ZuHx3UuqjfTzVIlIrX10SOhouGioZ4RBm0CtNaLRLoqr4");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(19);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("ioWsa7ersFKTYZvgc2jrocbNGAZyW89D4HQNImvyJyiiqUrisu");
            corecontacts.setFirstName("5W3SSns4DoYTyvDxwYJBPqitBLIpZL0zvZ21C5y6cmhZf5Owkv");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("DP8n3VvKHzTGQ4BCdcm7vdHm14OU1uoEPkiHyUKs9y9mgn0CN5");
            corecontacts.setMiddleName("WiartxlbKoAA7zhWdjBmvxH1wA2CQQWLa4ARLsQ7IEGO4bUwsV");
            corecontacts.setNativeFirstName("ZqorRM2Qf1KfuCSwItp1onKq9C1m8kPMoVnxq9Own6detKEDpf");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("LIPEfKaiDupvz88Sf7ySrdQsj0eEBPpNdXQypzUoBHaL4XnyLy");
            corecontacts.setNativeMiddleName("bhEp5h8b7TsEXdcuHJpcjCGaahKKUbtVVAP1WAU0liDWyDpDDN");
            corecontacts.setNativeTitle("6iknnbGwQCPDBXUpRIRJek7qKTYb7VTU8XcEoAFO02D3Ow79H9");
            corecontacts.setPhoneNumber("4YI1f4oYFGFiJQkl6jBa");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("4S8sLhAs7vCktiPdyEjF4FwoJ5D8tSrqEjcJsmVFJJt6pVmFgO");
            address.setAddress2("n4Ym2mif5XRPnuvOwz22rXPUtS9VFYDwnb0zPVMUj6CS6x7CvK");
            address.setAddress3("91L7REhVg1TlsZUt2y2AW1D3a3GY3AMCflI0oYYaK99cGGMbkg");
            address.setAddressLabel("PeoxbnUdIWu");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("sVC5Piy03w9w86wg227bIbuADjTUh2lEGC3fIqXocTdY72oV6I");
            addresstype.setAddressTypeDesc("0nZW9YcEwIWX0EXOSTQn6BFZS0NFEnY79Muoua67HivoITix1v");
            addresstype.setAddressTypeIcon("U7AE5SkgODY5ysBHDitfpIqkt0HKRfvvLbwx2zqGDxITLVI7Yv");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("1c6sWlnc07JTynMKgBo34i3MlTJaywtx");
            city.setCityDescription("tkVkfILAUZaCXdiE5Q1kUkWun5mioW3e1edYBnqEDbWSW9XwA5");
            city.setCityFlag("reh6SL0Fq1gnPxOtATd53VkgPdlBE9vWhERFDN9MJZ8bRfXUXv");
            city.setCityLatitude(8);
            city.setCityLongitude(10);
            city.setCityName("7nkUgG965TMPdH5ueiaKFuFxTjhM66BkxjM9DGTVNDq4xFvO3T");
            Country country = new Country();
            country.setCapital("fr5ReIBEZxV98gcrxd0zx65igSX3aYbA");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(6);
            country.setCountryCode1("Uvb");
            country.setCountryCode2("mE7");
            country.setCountryFlag("N5X3IVA0LezD1g3aqMBWmfQTXJXqSLX6Y07oUT7OVFf1zFepqp");
            country.setCountryName("rNe4rXSWIkOEgV9E39gpCjDCBaxLkuoS7l8oCeFWcwKNQ3sZCG");
            country.setCurrencyCode("1Qn");
            country.setCurrencyName("infVieF8qDpvoyr2TSXgvXOFAtXeeU5fksWBawTZIDZ3wNT56u");
            country.setCurrencySymbol("xbjmTgvS5dhI6xCvx1oYB5n6APYK22aq");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("97071sGbWgv2EgrvU6Gd6xGPCgaqdWbjAGOHO3wNHnmA3eSfAW");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(10);
            state.setStateCode(1);
            state.setStateCodeChar2("Z6B4aEeC5mLGxo4YRANgBujQCbFaSBf2");
            state.setStateCodeChar3("JU1kxHTFXuM7rrFcIubWY3xZewwX4mby");
            state.setStateDescription("HTcw8CXM4FsPZ5V6OR4qizVBsBwvO2l6zGE9HfUBZZr4TG50FI");
            state.setStateFlag("K4cP11NJLNnnkpRSbTrg7KoQRFWcYf43WSDXy0GukaRnSRFdsJ");
            state.setStateName("CXmo7WEZPGIdb2p3qoHS1qso3FlawkDUz75PGvHndSJMta7u6I");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("82YRBAVqeleI2Buw5CJGpeSqd9h8tjAD");
            city.setCityDescription("LU9oXA6S8vMFigaqzGPnfntYnvCi9Wzu1lpAL168Sich4I360i");
            city.setCityFlag("tijyd6BebKJ34gNnBlWiGpDWZPTluYUWo4TvrM7BgRQKGLrYAO");
            city.setCityLatitude(1);
            city.setCityLongitude(9);
            city.setCityName("VOE3l2oUzZLpkVUQYQzC16WHWAdb0XyNmSwFN5fdxRor8sXlWf");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("v5JlLZCg1CXec7aHWDJoZGDKqT5Ua42HgRkiKZt80Z0TqA2mW5");
            address.setAddress2("pI6yW93Rw45RPJilsWk6KDA88IoCWYaiivlMcTyh3RkwjA67nv");
            address.setAddress3("KN05qtC1i9LHfEgHDYD6YaV9WXPCxenpKhLpfOuUwGfAK8OOe8");
            address.setAddressLabel("3AH4Mgs76qM");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("4Ia8yKpVFiMz4pOwzZ6G2Sh1GAsU5MQy39RTSdY83yiRD4IOfN");
            address.setLongitude("2bsc50yYLK0WtXGnzVKTyBsmTQFW5e95OzYXENLtUcSK3FUSnI");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("1tJJ28");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("fYm");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("fTq9GeUaJapt1Dv3yxCafmmhZTcKZm6hgzGhpVusYhm1oUt2e7");
            communicationgroup.setCommGroupName("teHbkjSDYOqG0Fmc4AFs7vDifswbs8oCuPsgeg4wyllZNJ3Wvx");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("Pj3FHrGZvrEfNABTqYJGV9ZJAdysNfe3EbXIqvj0sDCyU10Q8q");
            communicationtype.setCommTypeName("M1DqIPAOKASknTyn1uKLEwsDuEjLkqaMwMcXkaLKcqKNFazm9h");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("xGy");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
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
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(15);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("UavPtExPYaYmNfdzl9bglprlxiZ9Ug6iF8Sax1TsXgYnDnFXDC");
            corecontacts.setFirstName("nsIhNLB6VMwkLBMn7616rbpKNd0PLb80C1x0X6e9oMPxdCuFEl");
            corecontacts.setLastName("mu6JFY3M6ITHyNLIlur5Q3kqSvjlsKKmSYVEdDa1wFsvvuma9U");
            corecontacts.setMiddleName("eZ9BbNBJMmCJf8UODdzV2wQzAGwr8gF8O2IprPb8fEwnAsy7zx");
            corecontacts.setNativeFirstName("kYYagqY0C01wjOADXRcFBIBP98AHMm06sqYoSUkhLgevCRfvaw");
            corecontacts.setNativeLastName("Klvu1NqqJsePeo11Bwv2ZtGrDKTmI48OFlVHqOIpEgiHRYbFR3");
            corecontacts.setNativeMiddleName("AUQyPdyuHZnXprhTmB3Wqnape54J00E4Ce2qkNDwsBq0vkKaXv");
            corecontacts.setNativeTitle("KR1zbqoUNrOXdQB8UZQfqG0VSuc7A4c0s8nX56ipULzn6ypvHo");
            corecontacts.setPhoneNumber("jnlP0WIM4WbwENx3a1El");
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
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
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
